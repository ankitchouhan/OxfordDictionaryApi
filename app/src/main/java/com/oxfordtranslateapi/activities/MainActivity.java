package com.oxfordtranslateapi.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oxfordtranslateapi.R;
import com.oxfordtranslateapi.adapters.MeaningAdapter;
import com.oxfordtranslateapi.interfaces.NetworkListener;
import com.oxfordtranslateapi.model.MeaningModel;
import com.oxfordtranslateapi.model.wordMeaning.LexicalEntry;
import com.oxfordtranslateapi.model.wordMeaning.OxfordModel;
import com.oxfordtranslateapi.network.ApiCall;
import com.oxfordtranslateapi.network.ApiInterface;
import com.oxfordtranslateapi.network.RestApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by Ankit Chouhan on 15/12/17.
 **/

public class MainActivity extends BaseActivity implements NetworkListener {


    private EditText searchEt;
    private Button searchBtn;
    private RecyclerView rvOxford;
    private MeaningAdapter mMeaningAdapter;
    private List<MeaningModel> mMeaningList;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    /**
     * initializes views.
     */
    private void initViews() {
        searchEt = findViewById(R.id.et_search);
        searchBtn = findViewById(R.id.btn_search);
        rvOxford = findViewById(R.id.rv_data);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setIndeterminate(true);
        rvOxford.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mMeaningList = new ArrayList<>();
        mMeaningAdapter = new MeaningAdapter(mMeaningList);
        rvOxford.setAdapter(mMeaningAdapter);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!searchEt.getText().toString().trim().isEmpty()) {
                    hitMeaningApi(searchEt.getText().toString().trim().toLowerCase());
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.please_enter_some_text), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * hitting get meaning api.
     */
    private void hitMeaningApi(String wordId) {
        progressBar.setVisibility(View.VISIBLE);
        ApiInterface apiInterface = RestApi.createService(MainActivity.this, ApiInterface.class);
        Call<ResponseBody> call = apiInterface.getWordDetails("entries/en/" + wordId);
        ApiCall.getInstance().hitService(this, call, this, 1);
    }

    @Override
    public void onSuccess(int responseCode, String response, int requestCode) {
        if (!isFinishing()) {
            progressBar.setVisibility(View.GONE);
            rvOxford.setVisibility(View.VISIBLE);
            if (responseCode == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                OxfordModel oxfordModel = new OxfordModel();
                try {
                    oxfordModel = objectMapper.readValue(response, OxfordModel.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (oxfordModel != null) {
                    if (oxfordModel.getResults().size() > 0) {
                        parseDictionaryData(oxfordModel.getResults().get(0).getLexicalEntries());
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Server error", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void onError(String response, int requestCode) {
        if (!isFinishing()) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, "Data Not Found", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure() {
        if (!isFinishing()) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, "Server error", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * parsing api data.
     *
     * @param results
     */
    private void parseDictionaryData(List<LexicalEntry> results) {
        if (results != null) {
            mMeaningList.clear();
            for (LexicalEntry lexicalEntry : results) {
                MeaningModel meaningModel = new MeaningModel();
                meaningModel.setLexicalCategory(lexicalEntry.getLexicalCategory());
                if (lexicalEntry.getEntries() != null && lexicalEntry.getEntries().size() > 0) {
                    meaningModel.setSenseList(lexicalEntry.getEntries().get(0).getSenses());
                }
                if (lexicalEntry.getPronunciations() != null && lexicalEntry.getPronunciations().size() > 0) {
                    meaningModel.setAudioFile(lexicalEntry.getPronunciations().get(0).getAudioFile());
                    meaningModel.setPhoneticWord(lexicalEntry.getPronunciations().get(0).getPhoneticSpelling());
                }
                mMeaningList.add(meaningModel);
            }
            mMeaningAdapter.notifyDataSetChanged();
        }
    }
}
