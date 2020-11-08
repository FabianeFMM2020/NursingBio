package com.example.bio_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AnimationDrawable anim;
    private Button btnComecar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        anim = (AnimationDrawable) btnComecar.getBackground();
        anim.setEnterFadeDuration(2300);
        anim.setExitFadeDuration(2300);
    }

    public void Usuario(View view){
        Intent UsuarioAluno = new Intent(this, UsuarioAluno.class);
        startActivity(UsuarioAluno);
    }

    private void init() {
        this.btnComecar = findViewById(R.id.btnComecar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (anim!=null && !anim.isRunning()){
            anim.start();
        }
    }

    protected void onPause() {
        super.onPause();

        if (anim!=null && !anim.isRunning()){
            anim.stop();
        }
    }
}
