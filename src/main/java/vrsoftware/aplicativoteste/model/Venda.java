package vrsoftware.aplicativoteste.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Venda {

    private int id;
    private int idCliente;
    private Date dataHoraVenda;
    private double total;
    private ArrayList<VendaItem> listaItem;

    public Venda() {
    }

    public Venda(ResultSet vendaDb) throws SQLException {
        this.id = vendaDb.getInt("id");
        this.idCliente = vendaDb.getInt("id_cliente");
        this.dataHoraVenda = vendaDb.getDate("datahoravenda");
        this.total = vendaDb.getDouble("total");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<VendaItem> getListaItem() {
        return listaItem;
    }

    public void setListaItem(ArrayList<VendaItem> listaItem) {
        this.listaItem = listaItem;
    }

    public Date getDataHoraVenda() {
        return dataHoraVenda;
    }

    public void setDataHoraVenda(Date dataHoraVenda) {
        this.dataHoraVenda = dataHoraVenda;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
