package com.example.bio_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FlashCardDigestorio extends AppCompatActivity {

    //Criar Botões e Textos que serão usados para Comunicação
    private Button botaotrue;
    private Button botaofalse;
    private Button botaonext;
    private TextView mQuestion;
    private Button voltar;

    private QuestionModel[] mQuestionBank  = new QuestionModel[] {
            new QuestionModel (R.string.question_one, true),
            new QuestionModel (R.string.question_two, true),
            new QuestionModel (R.string.question_three, true),
            new QuestionModel (R.string.question_four, false)
    };
    private int mCurrentIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card_digestorio);

        mQuestion = (TextView)findViewById(R.id.questions);
        botaotrue = (Button) findViewById(R.id.btn_true);
        botaofalse = (Button) findViewById(R.id.btn_false);
        botaonext = (Button) findViewById(R.id.next_button);


        botaotrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        botaofalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
        botaonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        //Declarando Método
        updateQuestion();
    }

    private void checkAnswer(boolean b) {
        boolean answerTrue = mQuestionBank[mCurrentIndex].ismAnswer();
        int messageResId = 0;
        if(b == answerTrue){
            messageResId = R.string.correct_toast;
        }else{
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    private void updateQuestion() {
        int question = mQuestionBank [mCurrentIndex].getmTextId();
        mQuestion.setText(question);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
