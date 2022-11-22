package br.com.tony.crud.model;

public class Usuario {
    private String nome;
    private String senha;
    private int id ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuário ID: " + this.getId() + ", Nome: " + this.getNome() + ", Senha: " + this.getSenha() + "\n";
    }
}
