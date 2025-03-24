package vrsoftware.aplicativoteste.controller.vendaitem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vrsoftware.aplicativoteste.controller.database.ConnectionFactory;
import vrsoftware.aplicativoteste.model.VendaItem;

public class VendaItemController {

    Connection conexaoDb;

    public VendaItemController() throws SQLException {

        conexaoDb = new ConnectionFactory().getConexaoBanco();

    }

    public ArrayList<VendaItem> findAll() throws SQLException {
        ArrayList<VendaItem> listaItens = new ArrayList<VendaItem>();
        PreparedStatement query = this.conexaoDb.prepareStatement("SELECT * FROM vendaitem");

        ResultSet resultado = query.executeQuery();

        while (resultado.next()) {
            listaItens.add(new VendaItem(resultado));
        }

        return listaItens;
    }

    public ArrayList<VendaItem> findByIdProduto(int idProduto) throws SQLException {
        ArrayList<VendaItem> listaItens = new ArrayList<VendaItem>();
        PreparedStatement query = this.conexaoDb.prepareStatement("SELECT * FROM vendaitem WHERE id_produto=?");
        query.setInt(1, idProduto);

        ResultSet resultado = query.executeQuery();

        while (resultado.next()) {
            listaItens.add(new VendaItem(resultado));
        }

        return listaItens;
    }

    public ArrayList<VendaItem> findByIdVenda(int idVenda) throws SQLException {
        ArrayList<VendaItem> listaItens = new ArrayList<VendaItem>();
        PreparedStatement query = this.conexaoDb.prepareStatement("SELECT * FROM vendaitem WHERE id_venda=?");
        query.setInt(1, idVenda);
        ResultSet resultado = query.executeQuery();

        while (resultado.next()) {
            listaItens.add(new VendaItem(resultado));
        }

        return listaItens;
    }

    public void create(VendaItem vendaItem) throws SQLException {
        PreparedStatement query = this.conexaoDb.prepareStatement("INSERT INTO vendaitem (id_produto, id_venda, quantidade, preco) VALUES (?,?,?,?)");
        query.setInt(1, vendaItem.getIdProduto());
        query.setInt(2, vendaItem.getIdVenda());
        query.setInt(3, vendaItem.getQuantidade());
        query.setDouble(4, vendaItem.getPreco());

        query.executeUpdate();
    }

    public void delete(int idVenda) throws SQLException {
        PreparedStatement query = this.conexaoDb.prepareStatement("DELETE FROM vendaitem WHERE id_venda=?");
        query.setInt(1, idVenda);
        
        query.executeUpdate();
    }

}
