package vrsoftware.aplicativoteste.controller.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import vrsoftware.aplicativoteste.controller.database.ConnectionFactory;
import vrsoftware.aplicativoteste.model.Produto;
import vrsoftware.aplicativoteste.model.WhereClause;

public class ProdutoController {

    private Connection conexaoDb;

    public ProdutoController() throws SQLException {
        conexaoDb = new ConnectionFactory().getConexaoBanco();
    }

    public ArrayList<Produto> findAll(ArrayList<WhereClause> whereClause) throws SQLException {
        ArrayList<Produto> listaProduto = new ArrayList<>();
        String where = "";
        String orderby = " ORDER BY id ASC";
        String query = "SELECT * FROM produto";
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

        ResultSet resultado = preparedStatement.executeQuery();

        while (resultado.next()) {
            listaProduto.add(new Produto(resultado));
        }

        return listaProduto;

    }

    public Produto getById(int id) throws SQLException {
        PreparedStatement query = this.conexaoDb.prepareStatement("SELECT * FROM produto WHERE id=?");
        query.setInt(1, id);
        ResultSet resultado = query.executeQuery();

        if (resultado.next()) {
            return new Produto(resultado);
        }

        return null;
    }

    public void create(Produto produto) throws SQLException {
        PreparedStatement query = this.conexaoDb.prepareStatement("INSERT INTO produto (descricao,preco) VALUES (?,?)");
        query.setString(1, produto.getDescricao());
        query.setDouble(2, produto.getPreco());

        query.executeQuery();
    }

    public void update(Produto produto) throws SQLException {
        PreparedStatement query = this.conexaoDb.prepareCall("UPDATE produto SET descricao=?, preco=?, status=? WHERE id=?");
        query.setString(1, produto.getDescricao());
        query.setDouble(2, produto.getPreco());
        query.setDouble(3, produto.getStatus());
        query.setInt(4, produto.getId());

        query.executeQuery();
    }

    public void delete(int idProduto) throws SQLException {
        PreparedStatement query = this.conexaoDb.prepareStatement("UPDATE produto SET status=0 WHERE id=?");
        query.setInt(1, idProduto);

        query.executeQuery();

    }
}
