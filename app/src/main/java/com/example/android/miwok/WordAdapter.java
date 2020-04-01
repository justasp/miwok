package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {


    public WordAdapter(@NonNull Context context, int resource, @NonNull List<Word> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemview = convertView;
        if (listItemview == null) {
            listItemview = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word word = getItem(position);
        TextView defaultText = listItemview.findViewById(R.id.english_text_view);
        defaultText.setText(word.getDefaultTranslation());

        TextView miwokTranslation = listItemview.findViewById(R.id.miwok_text_view);
        miwokTranslation.setText(word.getMiwokTranslation());

        return listItemview;
    }
}
