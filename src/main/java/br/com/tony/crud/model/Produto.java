package br.com.tony.crud.model;

import br.com.tony.crud.model.persistencia.dao.ProdutoDAO;

import java.util.Date;

public class Produto {

    private Integer id;
    private String nome;
    private String descricao;
    private Date dataDeCadastro;

    public Produto(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeCadastro = new Date();
        ProdutoDAO dao = new ProdutoDAO();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    @Override
    public String toString() {
        return  "ID: " + this.getId() + ", Produto: " + this.getNome() + ", Descrição: " + this.getDescricao() +
                ", Data de Cadastro: " + getDataDeCadastro() + "\n";
    }

    public void cadastraProduto(){
        ProdutoDAO dao = new ProdutoDAO();
        if (!dao.duplicata(this)){
            dao.cadastraProduto(this);
            System.out.println("Produto cadastrado com sucesso");
        } else {
            System.out.println("Produto já cadastrado!");
        }
    }
}
