package com.example.bio_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class EsqueceuSenha extends AppCompatActivity {

    private EditText Campoemail;
    private Button btnBuscar;

    FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueceu_senha);
        Inicializar();
    }

    private void Inicializar() {
        Campoemail = (EditText)findViewById(R.id.txtbuscar);
        btnBuscar = (Button)findViewById(R.id.btnRecuperar);

        autenticacao = FirebaseAuth.getInstance();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Campoemail.getText().toString();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(EsqueceuSenha.this, "Insira seu email corretamente", Toast.LENGTH_SHORT).show();
                }else{
                    autenticacao.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(EsqueceuSenha.this, "Por favor visite seu email para formatar sua senha", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(EsqueceuSenha.this, Login.class));
                            }else{
                                String message = task.getException().getMessage();
                                Toast.makeText(EsqueceuSenha.this, "Error: "+message, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
    public void RetornarLogin(View view){
        Intent AlunoLogin = new Intent(this, Login.class);
        startActivity(AlunoLogin);
    }

}

