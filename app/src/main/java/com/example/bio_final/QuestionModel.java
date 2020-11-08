package com.example.bio_final;

public class QuestionModel {

    private int mTextId;
    private boolean mAnswer;

    //Criar um Construtor
    public QuestionModel(int mTextId, boolean mAnswer) {
        this.mTextId = mTextId;
        this.mAnswer = mAnswer;
    }

    public void setmTextId(int mTextId) {
        this.mTextId = mTextId;
    }

    public void setmAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }

    public int getmTextId() {
        return mTextId;
    }

    public boolean ismAnswer() {
        return mAnswer;
    }
}
