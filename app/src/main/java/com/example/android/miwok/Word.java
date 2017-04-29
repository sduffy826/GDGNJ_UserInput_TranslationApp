package com.example.android.miwok;

/**
 * Created by seanduffy on 4/29/17.
 */

public class Word {
    private String defaultLanguageWord;
    private String miwokWord;

    public Word(String defLang, String miwok ) {
        defaultLanguageWord = defLang;
        miwokWord = miwok;
    }

    public String getDefaultWord() { return defaultLanguageWord; }
    public String getMiwokWord() { return miwokWord; }
}
