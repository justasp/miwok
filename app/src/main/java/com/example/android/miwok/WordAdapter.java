package com.example.android.miwok;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private BaseActivity context;
    private int colorResourceId;

    public WordAdapter(BaseActivity context, int colorResourceId) {
        this.context = context;
        this.colorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ConstraintLayout textContainer = viewItem.findViewById(R.id.text_container);
        textContainer.setBackgroundColor(viewItem.getResources().getColor(this.colorResourceId));
        return new ViewHolder(viewItem);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        context.stopPlaying();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.englishTranslation.setText(context.words.get(position).getDefaultTranslation());
        holder.miwokTranslation.setText(context.words.get(position).getMiwokTranslation());
        if (context.words.get(position).getImageResourceId() != 0) {
            holder.translationImage.setImageResource(context.words.get(position).getImageResourceId());
        } else {
            holder.translationImage.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener((view) -> {
            context.onPlay(position);

        });
    }


    @Override
    public int getItemCount() {
        return context.words.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView miwokTranslation;
        TextView englishTranslation;
        ImageView translationImage;
        ImageButton playButton;

        public ViewHolder(View wordView) {
            super(wordView);
            this.miwokTranslation = wordView.findViewById(R.id.miwok_text_view);
            this.englishTranslation = wordView.findViewById(R.id.english_text_view);
            this.translationImage = wordView.findViewById(R.id.translation_image);
            this.playButton = wordView.findViewById(R.id.play_button);
        }
    }

}
