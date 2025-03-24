package vrsoftware.aplicativoteste.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Produto {

    private int id;
    private String descricao;
    private double preco;
    private int status;

    public Produto() {
    }

    public Produto(ResultSet produtoDb) throws SQLException {
        this.id = produtoDb.getInt("id");
        this.descricao = produtoDb.getString("descricao");
        this.preco = produtoDb.getDouble("preco");
        this.status = produtoDb.getInt("status");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
