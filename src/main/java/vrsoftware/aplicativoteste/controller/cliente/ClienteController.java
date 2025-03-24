package vrsoftware.aplicativoteste.controller.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import vrsoftware.aplicativoteste.controller.database.ConnectionFactory;
import vrsoftware.aplicativoteste.model.Cliente;
import vrsoftware.aplicativoteste.model.WhereClause;

public class ClienteController {

    private Connection conexaoDb;

    public ClienteController() throws SQLException {
        conexaoDb = new ConnectionFactory().getConexaoBanco();
    }

    public void create(Cliente cliente) throws SQLException {
        PreparedStatement query = this.conexaoDb.prepareStatement("INSERT INTO cliente (nome, diafechamentofatura, valorlimitecompra) VALUES (?,?,?)");
        query.setString(1, cliente.getNome());
        query.setInt(2, cliente.getDiaFechamentoFatura());
        query.setDouble(3, cliente.getValorLimiteCompra());

        query.executeUpdate();

    }

    public ArrayList<Cliente> findAll(ArrayList<WhereClause> whereClause) throws SQLException {
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        String where = "";
        String orderby = " ORDER BY id ASC";
        String query = "SELECT * FROM cliente";
        PreparedStatement preparedStatement = null;

        if (!whereClause.isEmpty()) {
            where += " WHERE ";

            for (Iterator<WhereClause> iterator = whereClause.iterator(); iterator.hasNext();) {
                WhereClause clause = iterator.next();
                try {
                    where = where.concat(clause.getCampo() + "=" + Integer.valueOf(clause.getValor()));
                } catch (Exception ex) {
                    where = where.concat(clause.getCampo() + " LIKE '%" + clause.getValor() + "%'");
                }

                if (iterator.hasNext()) {
                    where += " AND ";
                }
            }

        }

        query = query.concat(where).concat(orderby);

        preparedStatement = this.conexaoDb.prepareStatement(query);

        ResultSet resultadoConsulta = preparedStatement.executeQuery();

        while (resultadoConsulta.next()) {
            listaCliente.add(new Cliente(resultadoConsulta));
        }

        return listaCliente;
    }

    public Cliente getById(int id) throws SQLException {
        PreparedStatement query = this.conexaoDb.prepareStatement("SELECT * FROM cliente WHERE id=?");
        query.setInt(1, id);

        ResultSet resultadoConsulta = query.executeQuery();

        if (resultadoConsulta.next()) {
            return new Cliente(resultadoConsulta);

        }
        
        return null;
    }

    public void update(Cliente cliente) throws SQLException {
        PreparedStatement query = this.conexaoDb.prepareStatement("UPDATE cliente SET nome=?, valorlimitecompra=?, diafechamentofatura=?, status=? WHERE id=?");
        query.setString(1, cliente.getNome());
        query.setDouble(2, cliente.getValorLimiteCompra());
        query.setInt(3, cliente.getDiaFechamentoFatura());
        query.setInt(4, cliente.getStatus());
        query.setInt(5, cliente.getId());
        query.executeUpdate();
    }

    public void delete(int idVenda) throws SQLException {
        PreparedStatement query = this.conexaoDb.prepareStatement("UPDATE cliente SET status=0 WHERE id=?");
        query.setInt(1, idVenda);

        query.executeUpdate();
    }

}
