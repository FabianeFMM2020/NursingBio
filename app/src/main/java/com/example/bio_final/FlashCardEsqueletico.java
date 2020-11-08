package com.example.bio_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FlashCardEsqueletico extends AppCompatActivity {

    //Criar Botões e Textos que serão usados para Comunicação
    private Button botaoverdadeiro;
    private Button botaofalso;
    private Button proximaquestao;
    private TextView questoes;
    private Button voltar;

    private QuestionModel[] mQuestionBank  = new QuestionModel[] {
            new QuestionModel (R.string.SistemaEsqueletico_um, false),
            new QuestionModel (R.string.SistemaEsqueletico_dois, true),
            new QuestionModel (R.string.SistemaEsqueletico_tres, false),
            new QuestionModel (R.string.SistemaEsqueletico_quatro, true),
            new QuestionModel (R.string.SistemaEsqueletico_cinco, true)
    };
    private int mCurrentIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card_esqueletico);

        questoes = (TextView)findViewById(R.id.Questoes);
        botaoverdadeiro = (Button) findViewById(R.id.btnVerdadeiro);
        botaofalso = (Button) findViewById(R.id.btnFalso);
        proximaquestao = (Button) findViewById(R.id.ProximaQuestao);

        botaoverdadeiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        botaofalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
        proximaquestao.setOnClickListener(new View.OnClickListener() {
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
        questoes.setText(question);
    }
}
