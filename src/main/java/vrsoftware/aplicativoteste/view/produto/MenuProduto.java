package vrsoftware.aplicativoteste.view.produto;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vrsoftware.aplicativoteste.controller.produto.ProdutoController;
import vrsoftware.aplicativoteste.model.Produto;
import vrsoftware.aplicativoteste.model.WhereClause;
import vrsoftware.aplicativoteste.view.CaixaAviso;
import vrsoftware.aplicativoteste.view.CaixaMensagem;
import vrsoftware.aplicativoteste.view.document.LimiteTexto;
import vrsoftware.aplicativoteste.view.document.OnlyNumbers;

public class MenuProduto extends javax.swing.JInternalFrame {

    private JDesktopPane desktopPane;
    private ProdutoController produtoController;

    public MenuProduto(JDesktopPane desktopPane) {
        try {
            initComponents();
            this.desktopPane = desktopPane;
            this.produtoController = new ProdutoController();
        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textCod = new javax.swing.JTextField();
        textDescricao = new javax.swing.JTextField();
        comboStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        buttonConsultar = new javax.swing.JMenu();
        buttonNovo = new javax.swing.JMenu();
        buttonEditar = new javax.swing.JMenu();
        buttonExcluir = new javax.swing.JMenu();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Menu produto");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        textCod.setDocument(new OnlyNumbers());
        textCod.setBorder(javax.swing.BorderFactory.createTitledBorder("Código"));

        textDescricao.setDocument(new LimiteTexto(120));
        textDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EXCLUIDO", "ATIVO" }));
        comboStatus.setSelectedIndex(1);
        comboStatus.setToolTipText("");
        comboStatus.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textCod, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Descrição", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProduto.setShowGrid(true);
        jScrollPane1.setViewportView(tabelaProduto);
        tabelaProduto.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        buttonConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/consulta.png"))); // NOI18N
        buttonConsultar.setText("Consultar");
        buttonConsultar.setToolTipText("Consultar usuário");
        buttonConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonConsultarMouseClicked(evt);
            }
        });
        jMenuBar1.add(buttonConsultar);

        buttonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicionar.png"))); // NOI18N
        buttonNovo.setText("Novo");
        buttonNovo.setToolTipText("Novo cliente");
        buttonNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonNovoMouseClicked(evt);
            }
        });
        jMenuBar1.add(buttonNovo);

        buttonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/alterar.png"))); // NOI18N
        buttonEditar.setText("Editar");
        buttonEditar.setToolTipText("Editar usuáro");
        buttonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEditarMouseClicked(evt);
            }
        });
        jMenuBar1.add(buttonEditar);

        buttonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excluir.png"))); // NOI18N
        buttonExcluir.setText("Excluir");
        buttonExcluir.setToolTipText("Excluir usuário");
        buttonExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonExcluirMouseClicked(evt);
            }
        });
        jMenuBar1.add(buttonExcluir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonConsultarMouseClicked
        consultarProduto();
    }//GEN-LAST:event_buttonConsultarMouseClicked

    private void buttonNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNovoMouseClicked
        CadastroEdicaoProduto cadastroEdicaoProduto = new CadastroEdicaoProduto();
        cadastroEdicaoProduto.setVisible(true);
        this.desktopPane.add(cadastroEdicaoProduto);
    }//GEN-LAST:event_buttonNovoMouseClicked

    private void buttonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEditarMouseClicked
        try {
            int idProduto = (Integer) this.tabelaProduto.getValueAt(this.tabelaProduto.getSelectedRow(), 0);
            Produto produto = this.produtoController.getById(idProduto);
            CadastroEdicaoProduto cadastroEdicaoProduto = new CadastroEdicaoProduto(produto);
            cadastroEdicaoProduto.setVisible(true);
            cadastroEdicaoProduto.setSelected(true);
            this.desktopPane.add(cadastroEdicaoProduto);           
        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MenuProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonEditarMouseClicked

    private void buttonExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonExcluirMouseClicked
         try {
            int idProduto = Integer.valueOf(this.tabelaProduto.getValueAt(this.tabelaProduto.getSelectedRow(), 0).toString());
            this.produtoController.delete(idProduto);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroEdicaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             new CaixaMensagem("Produto excluido");
         }
    }//GEN-LAST:event_buttonExcluirMouseClicked

    private void consultarProduto() {
        try {
            ArrayList<WhereClause> whereClause = extrairFiltros();
            ArrayList<Produto> listaProdutos = this.produtoController.findAll(whereClause);
            DefaultTableModel modeloTabela = (DefaultTableModel) this.tabelaProduto.getModel();
            modeloTabela.setRowCount(0);
            for (Produto produto : listaProdutos) {
                modeloTabela.addRow(new Object[]{
                    produto.getId(),
                    produto.getDescricao(),
                    NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(produto.getPreco()),});
            }
        } catch (SQLException ex) {
            if (ex.getErrorCode() != 0) {
                new CaixaAviso(ex.getMessage());
            }
        }
    }

    private ArrayList<WhereClause> extrairFiltros() {
        ArrayList<WhereClause> whereClause = new ArrayList<WhereClause>();

        if (!verificaCampo(this.textCod)) {
            whereClause.add(textFieldToWhereClause("id", textCod));
        }

        if (!verificaCampo(textDescricao)) {
            whereClause.add(textFieldToWhereClause("descricao", textDescricao));
        }

        whereClause.add(comboBoxToWhereClause("status", comboStatus));

        return whereClause;
    }

    private boolean verificaCampo(JTextField textField) {
        return textField.getText().isBlank();
    }

    private WhereClause textFieldToWhereClause(String campo, JTextField textField) {

        return new WhereClause(campo, textField.getText());

    }

    private WhereClause comboBoxToWhereClause(String campo, JComboBox comboBox) {

        return new WhereClause(campo, Integer.toString(comboBox.getSelectedIndex()));

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu buttonConsultar;
    private javax.swing.JMenu buttonEditar;
    private javax.swing.JMenu buttonExcluir;
    private javax.swing.JMenu buttonNovo;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTextField textCod;
    private javax.swing.JTextField textDescricao;
    // End of variables declaration//GEN-END:variables
}
