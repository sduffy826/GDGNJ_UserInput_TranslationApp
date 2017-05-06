package com.example.android.miwok;

import android.app.Activity;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by seanduffy on 4/29/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int backGroundColor;

    public WordAdapter(Activity context, ArrayList<Word> theList, int theColor) {
        super(context, 0, theList);
        backGroundColor = theColor;
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

        // Set the background color for the container with the textviews
        LinearLayout textLinearLayout = (LinearLayout) listItemView
                .findViewById(R.id.text_container);

        // Get the color that the resource id maps to
        int color = ContextCompat.getColor(getContext(), backGroundColor);
        textLinearLayout.setBackgroundColor(color);

        // Set the text views for the default word and the miwok word
        TextView defaultView = (TextView) listItemView.findViewById(R.id.text_default_word);
        defaultView.setText(currWord.getDefaultWord());

        TextView miwokView = (TextView) listItemView.findViewById(R.id.text_miwok_word);
        miwokView.setText(currWord.getMiwokWord());

        ImageView iconImageView = (ImageView) listItemView.findViewById(R.id.play_icon);
        iconImageView.setBackgroundColor(color);

        return listItemView;
    }
}
