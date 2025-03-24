package vrsoftware.aplicativoteste.model.tabelaVenda;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaGroupByProduto {

    private int id;
    private String descricao;
    private double valor;
    private int quantidade;

    public VendaGroupByProduto(ResultSet vendaDb) throws SQLException {
        this.id = vendaDb.getInt("id");
        this.descricao = vendaDb.getString("descricao");
        this.valor = vendaDb.getDouble("valor");
        this.quantidade = vendaDb.getInt("quantidade");
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
