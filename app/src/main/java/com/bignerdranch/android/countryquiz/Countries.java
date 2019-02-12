package com.bignerdranch.android.countryquiz;

public class Countries {

    private int mTextResId;
    private int mFlagImageId;

    public Countries (int flagImageId, int textResId){
        mTextResId = textResId;
        mFlagImageId = flagImageId;
    }
    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public int getFlagImageId() {
        return mFlagImageId;
    }

    public void setFlagImageId(int flagImageId) {
        mFlagImageId = flagImageId;
    }
}
