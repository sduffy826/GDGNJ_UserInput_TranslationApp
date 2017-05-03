package com.example.android.miwok;

/**
 * Created by seanduffy on 4/29/17.
 */

public class Word {
    private String mDefaultLanguageWord;
    private String mMiwokWord;
    private int mImageId;
    private boolean hasImageId;

    public Word(int imageId, String defLang, String miwok ) {
        mImageId = imageId;
        mDefaultLanguageWord = defLang;
        mMiwokWord = miwok;
        hasImageId = true;
    }

    public Word(String defLang, String miwok ) {
        mImageId = 0;
        mDefaultLanguageWord = defLang;
        mMiwokWord = miwok;
        hasImageId = false;
    }

    public String getDefaultWord() { return mDefaultLanguageWord; }
    public String getMiwokWord() { return mMiwokWord; }
    public int getImageId() { return mImageId; }
    public boolean hasImage() { return hasImageId; }
}
