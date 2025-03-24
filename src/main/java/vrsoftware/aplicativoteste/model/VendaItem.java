package vrsoftware.aplicativoteste.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaItem {

    private int idVenda;
    private int idProduto;
    private double preco;
    private int quantidade;

    public VendaItem(ResultSet vendaDb) throws SQLException {

        this.idVenda = vendaDb.getInt("id_venda");
        this.idProduto = vendaDb.getInt("id_produto");
        this.preco = vendaDb.getDouble("preco");
        this.quantidade = vendaDb.getInt("quantidade");

    }

    public VendaItem() {
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
