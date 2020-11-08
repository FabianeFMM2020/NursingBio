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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroAluno extends AppCompatActivity {

    private EditText campoUniversidade, campoCurso, campoEmail, campoSenha;
    private Button btnCadastrar;
    private CheckBox visualizar;

    private Usuario usuario;

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);
        InicializarComponentes();

        //Cadastrar do Usuário
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textoUniversidade = campoUniversidade.getText().toString();
                String textoCurso = campoCurso.getText().toString();
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                if( !textoUniversidade.isEmpty() ){
                    if( !textoCurso.isEmpty() ){
                        if( !textoEmail.isEmpty() ){
                            if( !textoSenha.isEmpty() ){

                                usuario = new Usuario();
                                usuario.setUniversidade( textoUniversidade );
                                usuario.setCurso( textoCurso );
                                usuario.setEmail( textoEmail );
                                usuario.setSenha( textoSenha );
                                Cadastrar( usuario );

                            }else{
                                Toast.makeText(CadastroAluno.this, "Preencha sua Senha", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(CadastroAluno.this, "Preencha seu Email", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(CadastroAluno.this, "Preencha seu Curso", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(CadastroAluno.this, "Preencha a Universidade", Toast.LENGTH_SHORT).show();
                }

            }
        });

        visualizar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    campoSenha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    campoSenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    /*
    Método reponsável por cadastrar usuário com e-mail e senha
    e fazer validações ao efetuar o cadastro
     */
    private void Cadastrar(Usuario usuario) {

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if ( task.isSuccessful() ){

                    Toast.makeText(CadastroAluno.this, "Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();

                    startActivity( new Intent(getApplicationContext(), Funcionalidades.class));
                    finish();

                }else{

                    String erroExcecao = "";
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        erroExcecao = "Digite uma senha mais forte!";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erroExcecao = "Por favor, digite um e-mail válido!";
                    }catch (FirebaseAuthUserCollisionException e){
                        erroExcecao = "Esta conta já foi cadastrada!";
                    }catch (Exception e){
                        erroExcecao = "ao cadastrar usuário: " +e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(CadastroAluno.this, "Erro: " + erroExcecao, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void InicializarComponentes() {
        campoUniversidade = (EditText)findViewById(R.id.textoUniversidadde);
        campoCurso = (EditText)findViewById(R.id.txtcurso);
        campoEmail = (EditText)findViewById(R.id.txtemail);
        campoSenha = (EditText)findViewById(R.id.txtsenha);
        btnCadastrar = (Button)findViewById(R.id.btnConcluir);
        visualizar = (CheckBox)findViewById(R.id.ver);
    }

    public void RetornarLogin(View view){
        Intent AlunoLogin = new Intent(this, Login.class);
        startActivity(AlunoLogin);
    }
}
