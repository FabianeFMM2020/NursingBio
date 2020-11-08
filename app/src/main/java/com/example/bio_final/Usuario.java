package com.example.bio_final;

public class Usuario {
    private String id;
    private String universidade;
    private String curso;
    private String email;
    private String senha;
    private String caminhofoto;

    public Usuario(String id, String universidade, String curso, String email, String senha, String caminhofoto) {
        this.id = id;
        this.universidade = universidade;
        this.curso = curso;
        this.email = email;
        this.senha = senha;
        this.caminhofoto = caminhofoto;
    }

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCaminhofoto() {
        return caminhofoto;
    }

    public void setCaminhofoto(String caminhofoto) {
        this.caminhofoto = caminhofoto;
    }
}
