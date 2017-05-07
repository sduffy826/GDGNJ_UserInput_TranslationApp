package com.example.android.miwok;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * This class handles the Numbers activity, use this one to refer too, the logic in the other
 * activities (Colors, Family and Phrases) is almost identical so I didn't replicate the comments
 * here into those classes.
 */
public class NumbersActivity extends AppCompatActivity {
    ArrayList<Word> words;

    // AppHelper has common code for application, it handles playing audio (and managing it)
    private AppHelper appHelper;

    @Override
    protected void onStop() {
        super.onStop();
        // Call the helper method to clear media resources
        appHelper.clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Get app helper object, we pass in our context
        appHelper = new AppHelper(this);

        // We create the array list where each cell contains a word object, that object has
        // the english and miwok translation.
        words = new ArrayList<Word>();
        words.add(new Word(R.drawable.number_one, "one", "lutti", R.raw.number_one));
        words.add(new Word(R.drawable.number_two, "two", "otiiko", R.raw.number_two));
        words.add(new Word(R.drawable.number_three, "three", "tolookosu", R.raw.number_three));
        words.add(new Word(R.drawable.number_four, "four", "oyyisa", R.raw.number_four));
        words.add(new Word(R.drawable.number_five, "five", "massokka", R.raw.number_five));
        words.add(new Word(R.drawable.number_six, "six", "temmokka", R.raw.number_six));
        words.add(new Word(R.drawable.number_seven, "seven", "kenekaku", R.raw.number_seven));
        words.add(new Word(R.drawable.number_eight, "eight", "kawinta", R.raw.number_eight));
        words.add(new Word(R.drawable.number_nine, "nine", "wo'e", R.raw.number_nine));
        words.add(new Word(R.drawable.number_ten, "ten", "na'aacha", R.raw.number_ten));

        // We now create the custom adapter that has our words, required since the array is array
        // of two dimensional objects having english/miwok words
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        // Get list view object and add our custom adapter to it
        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);

        // Set the click listener to handle playing the audio file for the word selected
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Get the word the user clicked
                Word word = (Word) adapterView.getItemAtPosition(i);
                // Call helper method to play it; it also handles cleanup
                appHelper.playIt(word.getAudioId());
            }
        });
    }
}