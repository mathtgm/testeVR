package vrsoftware.aplicativoteste.view.cliente;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vrsoftware.aplicativoteste.controller.cliente.ClienteController;
import vrsoftware.aplicativoteste.model.Cliente;
import vrsoftware.aplicativoteste.model.WhereClause;
import vrsoftware.aplicativoteste.view.CaixaAviso;
import vrsoftware.aplicativoteste.view.CaixaMensagem;
import vrsoftware.aplicativoteste.view.document.LimiteTexto;
import vrsoftware.aplicativoteste.view.document.OnlyNumbers;

public class MenuCliente extends javax.swing.JInternalFrame {

    private ClienteController clienteController;
    private JDesktopPane desktopPane;

    public MenuCliente(JDesktopPane desktopPane) {
        try {
            initComponents();
            this.clienteController = new ClienteController();
            this.desktopPane = desktopPane;
        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        textNome = new javax.swing.JTextField();
        textId = new javax.swing.JTextField();
        comboStatus = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        buttonConsultar = new javax.swing.JMenu();
        buttonNovo = new javax.swing.JMenu();
        buttonEditar = new javax.swing.JMenu();
        buttonExcluir = new javax.swing.JMenu();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Menu cliente");
        setMinimumSize(new java.awt.Dimension(800, 600));

        tabelaCliente.setAutoCreateRowSorter(true);
        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Nome", "Limite", "Data Fechamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCliente.setShowGrid(true);
        jScrollPane1.setViewportView(tabelaCliente);
        tabelaCliente.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabelaCliente.getColumnModel().getColumnCount() > 0) {
            tabelaCliente.getColumnModel().getColumn(1).setMinWidth(50);
            tabelaCliente.getColumnModel().getColumn(2).setMinWidth(10);
            tabelaCliente.getColumnModel().getColumn(3).setMinWidth(5);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        textNome.setDocument(new LimiteTexto());
        textNome.setToolTipText("Nome cliente");
        textNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        textId.setDocument(new OnlyNumbers());
        textId.setToolTipText("Código cliente");
        textId.setBorder(javax.swing.BorderFactory.createTitledBorder("Código"));

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EXCLUIDO", "ATIVO" }));
        comboStatus.setSelectedIndex(1);
        comboStatus.setToolTipText("Status");
        comboStatus.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/consulta.png"))); // NOI18N
        buttonConsultar.setText("Consultar");
        buttonConsultar.setToolTipText("Consultar produto");
        buttonConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonConsultarMouseClicked(evt);
            }
        });
        jMenuBar1.add(buttonConsultar);

        buttonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicionar.png"))); // NOI18N
        buttonNovo.setText("Novo");
        buttonNovo.setToolTipText("Novo produto");
        buttonNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonNovoMouseClicked(evt);
            }
        });
        jMenuBar1.add(buttonNovo);

        buttonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/alterar.png"))); // NOI18N
        buttonEditar.setText("Editar");
        buttonEditar.setToolTipText("Editar produto");
        buttonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEditarMouseClicked(evt);
            }
        });
        jMenuBar1.add(buttonEditar);

        buttonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excluir.png"))); // NOI18N
        buttonExcluir.setText("Excluir");
        buttonExcluir.setToolTipText("Excluir produto");
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonConsultarMouseClicked
        consultarCliente();
    }//GEN-LAST:event_buttonConsultarMouseClicked

    private void buttonNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNovoMouseClicked
        CadastroEdicaoCliente cadastroEdicaoCliente = new CadastroEdicaoCliente();
        this.desktopPane.add(cadastroEdicaoCliente);
        cadastroEdicaoCliente.setVisible(true);
    }//GEN-LAST:event_buttonNovoMouseClicked

    private void buttonExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonExcluirMouseClicked
        try {
            int idCliente = Integer.valueOf(this.tabelaCliente.getValueAt(this.tabelaCliente.getSelectedRow(), 0).toString());
            this.clienteController.delete(idCliente);

        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        } finally {
            new CaixaMensagem("Cliente excluído");
            consultarCliente();
        }
    }//GEN-LAST:event_buttonExcluirMouseClicked

    private void buttonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEditarMouseClicked
        try {
            int idCliente = Integer.valueOf(this.tabelaCliente.getValueAt(this.tabelaCliente.getSelectedRow(), 0).toString());
            Cliente cliente = clienteController.getById(idCliente);
            CadastroEdicaoCliente cadastroEdicaoCliente = new CadastroEdicaoCliente(cliente);
            this.desktopPane.add(cadastroEdicaoCliente);
            cadastroEdicaoCliente.setVisible(true);
        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }
    }//GEN-LAST:event_buttonEditarMouseClicked

    private void consultarCliente() {
        try {
            ArrayList<WhereClause> whereClause = extrairFiltros();
            ArrayList<Cliente> listaClientes = this.clienteController.findAll(whereClause);
            DefaultTableModel modeloTabela = (DefaultTableModel) this.tabelaCliente.getModel();
            modeloTabela.setRowCount(0);
            for (Cliente cliente : listaClientes) {
                modeloTabela.addRow(new Object[]{
                    cliente.getId(),
                    cliente.getNome(),
                    NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(cliente.getValorLimiteCompra()),
                    cliente.getDiaFechamentoFatura(),});
            }
        } catch (SQLException ex) {
            if (ex.getErrorCode() != 0) {
                new CaixaAviso(ex.getMessage());
            }
        }
    }

    private ArrayList<WhereClause> extrairFiltros() {
        ArrayList<WhereClause> whereClause = new ArrayList<WhereClause>();

        if (!verificaCampo(textId)) {
            whereClause.add(textFieldToWhereClause("id", textId));
        }

        if (!verificaCampo(textNome)) {
            whereClause.add(textFieldToWhereClause("nome", textNome));
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
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}
