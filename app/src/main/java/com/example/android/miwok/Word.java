package com.example.android.miwok;

/**
 * This class represents a word in our app, it has the word in it's default language (english)
 * and also the Miwok translation; it also has the image/audio attributes; the boolean hasImageId
 * is true if there's an image associated with the word (to display on screen); every word has
 * an audio file :)
 *
 * Created by seanduffy on 4/29/17.
 */

public class Word {
    private String mDefaultLanguageWord;
    private String mMiwokWord;
    private int mImageId;
    private boolean hasImageId;
    private int mAudioId;

    // Constructor for words with images
    public Word(int imageId, String defLang, String miwok , int audioId) {
        mImageId = imageId;
        mDefaultLanguageWord = defLang;
        mMiwokWord = miwok;
        hasImageId = true;
        mAudioId = audioId;
    }

    // Constructor for words that don't contain an image
    public Word(String defLang, String miwok, int audioId ) {
        mImageId = 0;
        mDefaultLanguageWord = defLang;
        mMiwokWord = miwok;
        hasImageId = false;
        mAudioId = audioId;
    }

    // Public methods
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
