package vrsoftware.aplicativoteste.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    private int id;
    private String nome;
    private double valorLimiteCompra;
    private int diaFechamentoFatura;
    private int status;

    public Cliente() {
    }

    public Cliente(ResultSet clienteDb) {

        try {
            this.id = clienteDb.getInt("id");
            this.nome = clienteDb.getString("nome");
            this.diaFechamentoFatura = clienteDb.getInt("diafechamentofatura");
            this.valorLimiteCompra = clienteDb.getFloat("valorlimitecompra");
            this.status = clienteDb.getInt("status");
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

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

    public double getValorLimiteCompra() {
        return valorLimiteCompra;
    }

    public void setValorLimiteCompra(double valorLimiteCompra) {
        this.valorLimiteCompra = valorLimiteCompra;
    }

    public int getDiaFechamentoFatura() {
        return diaFechamentoFatura;
    }

    public void setDiaFechamentoFatura(int diaFechamentoFatura) {
        this.diaFechamentoFatura = diaFechamentoFatura;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
