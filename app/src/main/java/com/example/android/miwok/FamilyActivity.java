package com.example.android.miwok;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    ArrayList<Word> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // We create the array list where each cell contains a word object, that object has
        // the english and miwok translation.
        words = new ArrayList<Word>();
        words.add(new Word(R.drawable.family_father,"father", "ape"));
        words.add(new Word(R.drawable.family_mother,"mother", "ata"));
        words.add(new Word(R.drawable.family_son,"son", "angsi"));
        words.add(new Word(R.drawable.family_daughter,"daughter", "tune"));
        words.add(new Word(R.drawable.family_older_brother,"older brother", "taachi"));
        words.add(new Word(R.drawable.family_younger_brother,"younger brother", "chalitti"));
        words.add(new Word(R.drawable.family_older_sister,"older sister", "tete"));
        words.add(new Word(R.drawable.family_younger_sister,"younger sister", "kolliti"));
        words.add(new Word(R.drawable.family_grandmother,"grandmother", "ama"));
        words.add(new Word(R.drawable.family_grandfather,"grandfather", "paapa"));

        // We now create the custom adapter that has our words, required since the array is array
        // of two dimensional objects having english/miwok words
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

        // Get list view object and add our custom adapter to it
        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);
    }
}