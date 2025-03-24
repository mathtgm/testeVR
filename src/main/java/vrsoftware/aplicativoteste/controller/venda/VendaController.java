package vrsoftware.aplicativoteste.controller.venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import vrsoftware.aplicativoteste.controller.cliente.ClienteController;
import vrsoftware.aplicativoteste.controller.database.ConnectionFactory;
import vrsoftware.aplicativoteste.controller.vendaitem.VendaItemController;
import vrsoftware.aplicativoteste.model.Cliente;
import vrsoftware.aplicativoteste.model.Venda;
import vrsoftware.aplicativoteste.model.VendaItem;
import vrsoftware.aplicativoteste.model.WhereClause;
import vrsoftware.aplicativoteste.model.tabelaVenda.VendaGroupByCliente;
import vrsoftware.aplicativoteste.model.tabelaVenda.VendaGroupByProduto;

public class VendaController {

    private Connection conexaoDb;
    private VendaItemController vendaItemController;
    private ClienteController clienteController;

    public VendaController() throws SQLException {

        this.vendaItemController = new VendaItemController();
        this.clienteController = new ClienteController();
        this.conexaoDb = new ConnectionFactory().getConexaoBanco();

    }

    public ArrayList<Venda> findAll(ArrayList<WhereClause> whereClause) throws SQLException {
        ArrayList<Venda> listaVendas = new ArrayList<>();
        String where = getWhereQuery(whereClause);
        String orderby = " ORDER BY id ASC";
        String query = "SELECT * FROM venda";
        PreparedStatement preparedStatement = null;

        query = query.concat(where).concat(orderby);
        preparedStatement = this.conexaoDb.prepareStatement(query);
        ResultSet resultado = preparedStatement.executeQuery();

        while (resultado.next()) {
            listaVendas.add(new Venda(resultado));
        }

        return listaVendas;
    }

    public Venda getById(int id) throws SQLException {
        PreparedStatement query = this.conexaoDb.prepareStatement("SELECT * FROM venda WHERE id=?");
        query.setInt(1, id);
        ResultSet resultado = query.executeQuery();
        resultado.next();
        return new Venda(resultado);
    }

    public Venda getByCliente(int idCliente) throws SQLException {
        PreparedStatement query = this.conexaoDb.prepareStatement("SELECT * FROM venda WHERE id_cliente=?");
        query.setInt(1, idCliente);
        ResultSet resultado = query.executeQuery();
        resultado.next();
        return new Venda(resultado);
    }

    public ArrayList<VendaGroupByCliente> findVendaGroupCliente(ArrayList<WhereClause> whereClause) throws SQLException {
        ArrayList<VendaGroupByCliente> listaVendas = new ArrayList<>();
        String where = getWhereQuery(whereClause);
        String query = "";
        String select = "SELECT v.id_cliente, c.nome, SUM(v.total) as total FROM venda v ";
        String innerJoin = " INNER JOIN cliente c ON v.id_cliente = c.id ";
        String group = " GROUP BY v.id_cliente, c.nome ";
        String orderby = " ORDER BY c.nome ASC";
        PreparedStatement preparedStatement = null;

        query = query.concat(select).concat(innerJoin).concat(where).concat(group).concat(orderby);
        preparedStatement = this.conexaoDb.prepareStatement(query);
        ResultSet resultado = preparedStatement.executeQuery();

        while (resultado.next()) {
            listaVendas.add(new VendaGroupByCliente(resultado));
        }

        return listaVendas;
    }

    public ArrayList<VendaGroupByProduto> findVendaGroupProduto(ArrayList<WhereClause> whereClause) throws SQLException {
        ArrayList<VendaGroupByProduto> listaVendas = new ArrayList<>();
        String where = getWhereQuery(whereClause);
        String query = "";
        String select = "SELECT p.id, p.descricao, SUM(vi.preco * vi.quantidade) as valor, SUM(quantidade) as quantidade FROM venda v ";
        String innerJoin = "INNER JOIN vendaitem vi ON v.id = vi.id_venda INNER JOIN produto p ON vi.id_produto = p.id ";
        String group = " GROUP BY p.id, p.descricao ";
        String orderby = " ORDER BY p.descricao ASC";
        PreparedStatement preparedStatement = null;

        query = query.concat(select).concat(innerJoin).concat(where).concat(group).concat(orderby);
        preparedStatement = this.conexaoDb.prepareStatement(query);
        ResultSet resultado = preparedStatement.executeQuery();

        while (resultado.next()) {
            listaVendas.add(new VendaGroupByProduto(resultado));
        }

        return listaVendas;
    }

    public void create(Venda venda) throws SQLException {
        VendaItemController vendaItemController = new VendaItemController();
        ResultSet sequencia = this.conexaoDb.prepareStatement("SELECT nextval('venda_id_seq')").executeQuery();
        PreparedStatement query = this.conexaoDb.prepareStatement("INSERT INTO venda (id, id_cliente, datahoravenda, total) VALUES (?,?,now(),?)");
        sequencia.next();

        query.setInt(1, sequencia.getInt(1));
        query.setInt(2, venda.getIdCliente());
        query.setDouble(3, venda.getTotal());

        query.executeUpdate();

        for (VendaItem item : venda.getListaItem()) {
            item.setIdVenda(sequencia.getInt(1));
            vendaItemController.create(item);
        }

    }

    public void update(Venda venda) throws SQLException {
        PreparedStatement query = this.conexaoDb.prepareStatement("UPDATE venda SET id_cliente=?, total=? WHERE id=?");
        query.setInt(1, venda.getIdCliente());
        query.setDouble(2, venda.getTotal());
        query.setInt(3, venda.getId());

        query.executeUpdate();
        this.vendaItemController.delete(venda.getId());
        venda.getListaItem().forEach((item) -> {
            try {
                item.setIdVenda(venda.getId());
                vendaItemController.create(item);
            } catch (SQLException ex) {
                Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void delete(int idVenda) throws SQLException {
        this.vendaItemController.delete(idVenda);
        PreparedStatement query = this.conexaoDb.prepareStatement("DELETE FROM venda CASCADE WHERE id=?");
        query.setInt(1, idVenda);

        query.executeUpdate();
    }

    public String getWhereQuery(ArrayList<WhereClause> whereClause) {
        String where = "";
        if (!whereClause.isEmpty()) {
            where += " WHERE ";

            for (Iterator<WhereClause> iterator = whereClause.iterator(); iterator.hasNext();) {
                WhereClause clause = iterator.next();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

                try {
                    Date dataInicio = dateFormat.parse(clause.getValor().split(",")[0]);
                    Date dataFim = dateFormat.parse(clause.getValor().split(",")[1]);
                    SimpleDateFormat dateDbFormat = new SimpleDateFormat("yyyy-mm-dd");
                    where = where.concat(clause.getCampo() + " BETWEEN '" + dateDbFormat.format(dataInicio) + " 00:00:00' AND '" + dateDbFormat.format(dataFim) + " 23:59:59'");
                } catch (ParseException pex) {
                    try {
                        where = where.concat(clause.getCampo() + "=" + Integer.parseInt(clause.getValor()));
                    } catch (Exception ex) {
                        where = where.concat(clause.getCampo() + " LIKE '%" + clause.getValor() + "%'");
                    }
                }

                if (iterator.hasNext()) {
                    where += " AND ";
                }
            }

        }
        return where;
    }

    public double getValorTotalVendaClienteCredito(int idCliente, Date dataInicio, Date dataFim) throws SQLException {
        String formatedDataInicio = new SimpleDateFormat("yyyy-MM-dd").format(dataInicio);
        String formatedDataFim = new SimpleDateFormat("yyyy-MM-dd").format(dataFim);

        PreparedStatement query = this.conexaoDb
                .prepareStatement("SELECT SUM(total) as totalvendas FROM venda WHERE id_cliente = ? AND datahoravenda BETWEEN '" + formatedDataInicio + " 00:00:00' AND '" + formatedDataFim + " 23:59:59'");
        query.setInt(1, idCliente);

        ResultSet resultado = query.executeQuery();

        if (resultado.next()) {
            return resultado.getDouble("totalvendas");
        }
        return 0.00;
    }
}
