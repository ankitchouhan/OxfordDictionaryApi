package com.oxfordtranslateapi.adapters;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.oxfordtranslateapi.R;
import com.oxfordtranslateapi.model.MeaningModel;
import com.oxfordtranslateapi.model.wordMeaning.Example;
import com.oxfordtranslateapi.model.wordMeaning.Sense;

import java.io.IOException;
import java.util.List;


/**
 * Created by Ankit Chouhan on 15/12/17
 * */

public class MeaningAdapter extends RecyclerView.Adapter<MeaningAdapter.CustomViewHolder> {

    private List<MeaningModel> meaningModelList;
    private StringBuilder def, exam;
    private int count = 0, number = 0;

    public MeaningAdapter(List<MeaningModel> meaningModelList) {
        this.meaningModelList = meaningModelList;
        def = new StringBuilder();
        exam = new StringBuilder(

        );
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_meaning, parent, false));
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        if (meaningModelList != null) {
            if (meaningModelList.get(position).getLexicalCategory() != null && !meaningModelList.get(position).getLexicalCategory().isEmpty()) {
                holder.nounVerbCategoryTv.setText(meaningModelList.get(position).getLexicalCategory().trim());
            } else {
                holder.nounVerbCategoryTv.setVisibility(View.GONE);
            }
            if (meaningModelList.get(position).getPhoneticWord() != null && !meaningModelList.get(position).getPhoneticWord().isEmpty()) {
                holder.phoneticWordTv.setText(meaningModelList.get(position).getPhoneticWord());
            } else {
                holder.phoneticWordTv.setVisibility(View.GONE);
            }
            if (meaningModelList.get(position).getAudioFile() != null && !meaningModelList.get(position).getAudioFile().isEmpty()) {
                holder.audioIv.setVisibility(View.VISIBLE);
            } else {
                holder.audioIv.setVisibility(View.GONE);
            }
            if (meaningModelList.get(position).getSenseList() != null && meaningModelList.get(position).getSenseList().size() > 0) {
                def.delete(0, def.length());
                exam.delete(0, exam.length());
                count = 0;
                number = 0;
                for (Sense data : meaningModelList.get(position).getSenseList()) {
                    if (data.getDefinitions() != null && data.getDefinitions().size() > 0) {
                        for (String definition : data.getDefinitions()) {
                            if (!definition.isEmpty()) {
                                def.append((++count) + ". " + definition + "\n");
                            }
                        }
                        holder.meaningTv.setText(def);
                    }
                    if (data.getExamples() != null && data.getExamples().size() > 0) {
                        for (Example example : data.getExamples()) {
                            if (!example.getText().isEmpty()) {
                                exam.append((++number) + ". " + example.getText() + "\n");
                            }
                        }
                        holder.exampleTv.setText(exam);
                    }
                }
                if (def.length() == 0) {
                    holder.meaningTv.setVisibility(View.GONE);
                } else {
                    holder.meaningTv.setVisibility(View.VISIBLE);
                }
                if (exam.length() == 0) {
                    holder.exampleTv.setVisibility(View.GONE);
                    holder.exampleTextTv.setVisibility(View.GONE);
                } else {
                    holder.exampleTv.setVisibility(View.VISIBLE);
                    holder.exampleTextTv.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return meaningModelList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView nounVerbCategoryTv, meaningTv, exampleTv, phoneticWordTv,exampleTextTv;
        private ImageView audioIv;

        CustomViewHolder(View itemView) {
            super(itemView);
            nounVerbCategoryTv = itemView.findViewById(R.id.tv_noun_verb);
            meaningTv = itemView.findViewById(R.id.tv_meaning);
            exampleTv = itemView.findViewById(R.id.tv_example);
            audioIv = itemView.findViewById(R.id.tv_audio_clip);
            phoneticWordTv = itemView.findViewById(R.id.tv_phonetic_word);
            exampleTextTv = itemView.findViewById(R.id.tv_example_text);
            audioIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    try {
                        mediaPlayer.setDataSource(meaningModelList.get(getAdapterPosition()).getAudioFile());
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                mediaPlayer.start();
                            }
                        });
                        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                            @Override
                            public boolean onError(MediaPlayer mp, int what, int extra) {
                                mp.reset();
                                return true;
                            }
                        });
                        mediaPlayer.prepareAsync();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
