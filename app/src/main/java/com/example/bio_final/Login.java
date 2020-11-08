package com.example.bio_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText campoEmail, campoSenha;
    private Button btnLogin;
    private ProgressBar progressBar;
    private CheckBox campovisualizar;

    private Usuario usuario;

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InicializarComponentes();

        campovisualizar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    campoSenha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    campoSenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        progressBar.setVisibility(View.GONE);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                if( !textoEmail.isEmpty() ){
                    if( !textoSenha.isEmpty() ){

                        usuario = new Usuario();
                        usuario.setEmail( textoEmail );
                        usuario.setSenha( textoSenha );
                        Login( usuario );

                    }else{
                        Toast.makeText(Login.this, "Confirme sua Senha", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Login.this, "Confirme seu E-mail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Login(Usuario usuario) {
        progressBar.setVisibility(View.VISIBLE);
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();

        autenticacao.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if ( task.isSuccessful() ){
                    progressBar.setVisibility(View.GONE);
                    startActivity(new Intent(getApplicationContext(), Funcionalidades.class));

                }else{
                    Toast.makeText(Login.this, "Erro ao fazer o Login", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

    private void InicializarComponentes() {
        campoEmail = (EditText)findViewById(R.id.txtEmail);
        campoSenha = (EditText)findViewById(R.id.txtSenha);
        btnLogin = (Button)findViewById(R.id.btnEntrar);
        progressBar = (ProgressBar) findViewById(R.id.progressEntrar);
        campovisualizar = (CheckBox) findViewById(R.id.checkVer);
    }

    public void RetornarMenu(View view){
        Intent UsuarioAluno = new Intent(this, UsuarioAluno.class);
        startActivity(UsuarioAluno);
    }

    public void MenuAluno(View view){
        Intent Funcionalidades = new Intent(this, Funcionalidades.class);
        startActivity(Funcionalidades);
    }

    public void CadastroAluno(View view){
        Intent CadastroAluno = new Intent(this, CadastroAluno.class);
        startActivity(CadastroAluno);
    }

    public void EsqueceuSenha(View view){
        Intent EsqueceuSenha = new Intent(this, EsqueceuSenha.class);
        startActivity(EsqueceuSenha);
    }
}
