package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by seanduffy on 4/29/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> theList) {
        super(context, 0, theList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        // If listItemView doesn't exist we'll create it, the LayoutInflater... creates an object
        // for the specified arguments
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent,false);
        }

        // Get word at position
        Word currWord = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image1);
        if (currWord.hasImage()) {
            imageView.setImageResource(currWord.getImageId());
            imageView.setVisibility(View.VISIBLE); // Since we reuse views set to visible
         }
        else {
            imageView.setVisibility(View.GONE);
        }

        // Set the text views for the default word and the miwok word
        TextView defaultView = (TextView) listItemView.findViewById(R.id.text1);
        defaultView.setText(currWord.getDefaultWord());

        TextView miwokView = (TextView) listItemView.findViewById(R.id.text2);
        miwokView.setText(currWord.getMiwokWord());

        return listItemView;
    }
}
