package com.example.android.miwok;

/**
 * Created by seanduffy on 4/29/17.
 */

public class Word {
    private String mDefaultLanguageWord;
    private String mMiwokWord;
    private int mImageId;
    private boolean hasImageId;
    private int mAudioId;

    public Word(int imageId, String defLang, String miwok , int audioId) {
        mImageId = imageId;
        mDefaultLanguageWord = defLang;
        mMiwokWord = miwok;
        hasImageId = true;
        mAudioId = audioId;
    }

    public Word(String defLang, String miwok, int audioId ) {
        mImageId = 0;
        mDefaultLanguageWord = defLang;
        mMiwokWord = miwok;
        hasImageId = false;
        mAudioId = audioId;
    }

    public String getDefaultWord() { return mDefaultLanguageWord; }
    public String getMiwokWord() { return mMiwokWord; }
    public int getImageId() { return mImageId; }
    public boolean hasImage() { return hasImageId; }
    public int getAudioId() { return mAudioId; }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultLanguageWord='" + mDefaultLanguageWord + '\'' +
                ", mMiwokWord='" + mMiwokWord + '\'' +
                ", mImageId=" + mImageId +
                ", hasImageId=" + hasImageId +
                ", mAudioId=" + mAudioId +
                '}';
    }
}
