package vrsoftware.aplicativoteste.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vrsoftware.aplicativoteste.controller.database.ConnectionFactory;

public class ConfiguracaoSistema extends javax.swing.JInternalFrame {

    Connection connection = null;

    public ConfiguracaoSistema() {
        initComponents();
        try {
            this.connection = new ConnectionFactory().getConexaoBanco();
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracaoSistema.class.getName()).log(Level.SEVERE, null, ex);
            new CaixaAviso(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonDb = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Configuração do sistema");

        buttonDb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/db.png"))); // NOI18N
        buttonDb.setText("Criar tabelas");
        buttonDb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDbMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonDb, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(buttonDb)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDbMouseClicked
        try {
            criaTabelaCliente();
            criaTabelaProduto();
            criaTabelaVenda();
            criaTebelaVendaItem();
            new CaixaMensagem("Tabelas criadas com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracaoSistema.class.getName()).log(Level.SEVERE, null, ex);
            new CaixaAviso(ex.getMessage());
        }
    }//GEN-LAST:event_buttonDbMouseClicked

    private void criaBancoDados() throws SQLException {
        String query = "CREATE DATABASE \"aplicativoTeste\" WITH OWNER = postgres ENCODING = 'UTF8' LC_COLLATE = 'pt_BR.utf8' LC_CTYPE = 'pt_BR.utf8' LOCALE_PROVIDER = 'libc' TABLESPACE = pg_default CONNECTION LIMIT = -1 IS_TEMPLATE = False";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.executeUpdate();

    }

    private void criaTabelaCliente() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS cliente (id SERIAL NOT NULL,nome character varying(80) NOT NULL,valorlimitecompra double precision NOT NULL DEFAULT 0,diafechamentofatura integer NOT NULL DEFAULT 1,status integer NOT NULL DEFAULT 1,CONSTRAINT cliente_pkey PRIMARY KEY (id))";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    private void criaTabelaProduto() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS produto (id SERIAL NOT NULL,descricao character varying(120) NOT NULL,preco double precision NOT NULL DEFAULT 0,status integer NOT NULL DEFAULT 1,CONSTRAINT produto_pkey PRIMARY KEY (id))";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    private void criaTabelaVenda() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS venda (id SERIAL NOT NULL,id_cliente integer NOT NULL,datahoravenda timestamp without time zone NOT NULL,total double precision NOT NULL,CONSTRAINT venda_pkey PRIMARY KEY (id),CONSTRAINT fk_cliente FOREIGN KEY (id_cliente) REFERENCES public.cliente (id))";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    private void criaTebelaVendaItem() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS vendaitem (id_venda integer NOT NULL,id_produto integer NOT NULL,preco double precision NOT NULL DEFAULT 0,quantidade integer NOT NULL DEFAULT 1,CONSTRAINT fk_produto FOREIGN KEY (id_produto) REFERENCES produto (id),CONSTRAINT fk_venda FOREIGN KEY (id_venda) REFERENCES public.venda (id))";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDb;
    // End of variables declaration//GEN-END:variables
}
