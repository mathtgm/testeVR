package vrsoftware.aplicativoteste.model.tabelaVenda;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaGroupByCliente {
    private int idCliente;
    private String nome;
    private double total;

    public VendaGroupByCliente(ResultSet groupVendaDb) throws SQLException {
        this.idCliente = groupVendaDb.getInt("id_cliente");
        this.nome = groupVendaDb.getString("nome");
        this.total = groupVendaDb.getDouble("total");
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
