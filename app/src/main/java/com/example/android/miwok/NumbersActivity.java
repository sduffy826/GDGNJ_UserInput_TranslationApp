package com.example.android.miwok;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    ArrayList<Word> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // We create the array list where each cell contains a word object, that object has
        // the english and miwok translation.
        words = new ArrayList<Word>();
        words.add(new Word(R.drawable.number_one,"one","lutti"));
        words.add(new Word(R.drawable.number_two,"two","otiiko"));
        words.add(new Word(R.drawable.number_three,"three","tolookosu"));
        words.add(new Word(R.drawable.number_four,"four","oyyisa"));
        words.add(new Word(R.drawable.number_five,"five","massokka"));
        words.add(new Word(R.drawable.number_six,"six","temmokka"));
        words.add(new Word(R.drawable.number_seven,"seven","kenekaku"));
        words.add(new Word(R.drawable.number_eight,"eight","kawinta"));
        words.add(new Word(R.drawable.number_nine,"nine","wo'e"));
        words.add(new Word(R.drawable.number_ten,"ten","na'aacha"));

        // We now create the custom adapter that has our words, required since the array is array
        // of two dimensional objects having english/miwok words
        WordAdapter adapter = new WordAdapter(this, words);

        // Get list view object and add our custom adapter to it
        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);
    }
}