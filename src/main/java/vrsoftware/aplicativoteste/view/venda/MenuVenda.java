package vrsoftware.aplicativoteste.view.venda;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vrsoftware.aplicativoteste.controller.cliente.ClienteController;
import vrsoftware.aplicativoteste.controller.venda.VendaController;
import vrsoftware.aplicativoteste.controller.vendaitem.VendaItemController;
import vrsoftware.aplicativoteste.model.Cliente;
import vrsoftware.aplicativoteste.model.Venda;
import vrsoftware.aplicativoteste.model.WhereClause;
import vrsoftware.aplicativoteste.model.tabelaVenda.VendaGroupByCliente;
import vrsoftware.aplicativoteste.model.tabelaVenda.VendaGroupByProduto;
import vrsoftware.aplicativoteste.view.CaixaAviso;
import vrsoftware.aplicativoteste.view.document.OnlyNumbers;

public class MenuVenda extends javax.swing.JInternalFrame {

    private JDesktopPane desktopPane;
    private VendaController vendaController;
    private VendaItemController vendaItemController;
    private ClienteController clienteController;

    public MenuVenda(JDesktopPane desktopPane) {
        try {
            initComponents();
            this.desktopPane = desktopPane;
            this.vendaController = new VendaController();
            this.vendaItemController = new VendaItemController();
            this.clienteController = new ClienteController();
        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoTipoConsulta = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        textCod = new javax.swing.JTextField();
        textCodCliente = new javax.swing.JTextField();
        textCodProduto = new javax.swing.JTextField();
        textDataInicio = new javax.swing.JFormattedTextField();
        textDataFim = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        radioCliente = new javax.swing.JRadioButton();
        radioProduto = new javax.swing.JRadioButton();
        radioVenda = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVenda = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        buttonConsultar = new javax.swing.JMenu();
        buttonNovo = new javax.swing.JMenu();
        buttonEditar = new javax.swing.JMenu();
        buttonExcluir = new javax.swing.JMenu();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Menu venda");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        textCod.setDocument(new OnlyNumbers());
        textCod.setBorder(javax.swing.BorderFactory.createTitledBorder("Código"));

        textCodCliente.setDocument(new OnlyNumbers());
        textCodCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cod. Cliente"));

        textCodProduto.setDocument(new OnlyNumbers());
        textCodProduto.setEditable(false);
        textCodProduto.setBorder(javax.swing.BorderFactory.createTitledBorder("Cod. Produto"));

        textDataInicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Data inicio"));
        try {
            textDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textDataInicio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                textDataInicioPropertyChange(evt);
            }
        });

        textDataFim.setBorder(javax.swing.BorderFactory.createTitledBorder("Data fim"));
        try {
            textDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textDataFim.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                textDataFimPropertyChange(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Agrupamento"));

        grupoTipoConsulta.add(radioCliente);
        radioCliente.setText("Cliente");
        radioCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioClienteMouseClicked(evt);
            }
        });

        grupoTipoConsulta.add(radioProduto);
        radioProduto.setText("Produto");
        radioProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioProdutoMouseClicked(evt);
            }
        });

        grupoTipoConsulta.add(radioVenda);
        radioVenda.setSelected(true);
        radioVenda.setText("Venda");
        radioVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioVendaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioVenda)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioVenda)
                    .addComponent(radioProduto)
                    .addComponent(radioCliente))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textCod, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tabelaVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cod. Cliente", "Cliente", "Valor total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaVenda.setOpaque(false);
        tabelaVenda.setShowGrid(true);
        jScrollPane1.setViewportView(tabelaVenda);
        tabelaVenda.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonConsultarMouseClicked
        if (this.radioVenda.isSelected()) {
            consultaVenda();
        }

        if (this.radioCliente.isSelected()) {
            cosultaCliente();
        }

        if (this.radioProduto.isSelected()) {
            consultaProduto();
        }
    }//GEN-LAST:event_buttonConsultarMouseClicked

    private void textDataInicioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textDataInicioPropertyChange
        verificaDataValida(this.textDataInicio);
    }//GEN-LAST:event_textDataInicioPropertyChange

    private void textDataFimPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textDataFimPropertyChange
        verificaDataValida(this.textDataFim);
    }//GEN-LAST:event_textDataFimPropertyChange

    private void radioClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioClienteMouseClicked
        desabilitaCampo(this.textCodProduto);
        habilitaCampo(this.textCodCliente);
        habilitaCampo(this.textCodCliente);
        desabilitaBotoes();
    }//GEN-LAST:event_radioClienteMouseClicked

    private void radioVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioVendaMouseClicked
        desabilitaCampo(this.textCodProduto);
        habilitaCampo(this.textCod);
        habilitaCampo(this.textCodCliente);
        habilitaBotoes();
    }//GEN-LAST:event_radioVendaMouseClicked

    private void radioProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioProdutoMouseClicked
        desabilitaCampo(this.textCod);
        habilitaCampo(this.textCodProduto);
        habilitaCampo(this.textCodCliente);
        desabilitaBotoes();
    }//GEN-LAST:event_radioProdutoMouseClicked

    private void buttonNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNovoMouseClicked
        CadastroEdicaoVenda cadastroEdicaoVenda = new CadastroEdicaoVenda();
        cadastroEdicaoVenda.setVisible(true);
        this.desktopPane.add(cadastroEdicaoVenda);
    }//GEN-LAST:event_buttonNovoMouseClicked

    private void buttonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEditarMouseClicked
        try {
            int indexLinha = this.tabelaVenda.getSelectedRow();
            int idVenda = (Integer) this.tabelaVenda.getValueAt(indexLinha, 0);
            Venda venda = this.vendaController.getById(idVenda);
            CadastroEdicaoVenda cadastroEdicaoVenda = new CadastroEdicaoVenda(venda);
            cadastroEdicaoVenda.setVisible(true);
            this.desktopPane.add(cadastroEdicaoVenda);
        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }

    }//GEN-LAST:event_buttonEditarMouseClicked

    private void buttonExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonExcluirMouseClicked
        try {
            int indexLinha = this.tabelaVenda.getSelectedRow();
            int idVenda = (Integer) this.tabelaVenda.getValueAt(indexLinha, 0);
            this.vendaController.delete(idVenda);
            consultaVenda();
        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }
    }//GEN-LAST:event_buttonExcluirMouseClicked

    public void desabilitaCampo(JTextField textField) {
        textField.setEditable(false);
        textField.setText("");
    }

    public void habilitaCampo(JTextField textField) {
        textField.setEditable(true);
    }

    private void consultaVenda() {
        setColunasTabelaVenda();
        addRowTabelaVenda();
    }

    private void cosultaCliente() {
        setColunasTabelaCliente();
        addRowTabelaCliente();
    }

    private void consultaProduto() {
        setColunasTabelaProduto();
        addRowTabelaProduto();
    }

    private void setColunasTabelaVenda() {
        DefaultTableModel modeloTabelaVenda = getModelTableNotEditable();
        modeloTabelaVenda.addColumn("Cod. venda");
        modeloTabelaVenda.addColumn("Cod. Cliente");
        modeloTabelaVenda.addColumn("Cliente");
        modeloTabelaVenda.addColumn("Valor R$");
        modeloTabelaVenda.setRowCount(0);
        this.tabelaVenda.setModel(modeloTabelaVenda);
    }

    private void setColunasTabelaCliente() {
        DefaultTableModel modeloTabelaCliente = getModelTableNotEditable();
        modeloTabelaCliente.addColumn("Cod. Cliente");
        modeloTabelaCliente.addColumn("Nome");
        modeloTabelaCliente.addColumn("Total vendas R$");
        modeloTabelaCliente.setRowCount(0);
        this.tabelaVenda.setModel(modeloTabelaCliente);
    }

    private void setColunasTabelaProduto() {
        DefaultTableModel modeloTabelaCliente = getModelTableNotEditable();
        modeloTabelaCliente.addColumn("Cod. produto");
        modeloTabelaCliente.addColumn("Descrição");
        modeloTabelaCliente.addColumn("Quantidade total");
        modeloTabelaCliente.addColumn("Total vendas R$");
        modeloTabelaCliente.setRowCount(0);
        this.tabelaVenda.setModel(modeloTabelaCliente);
    }
    
    private DefaultTableModel getModelTableNotEditable() {
        return new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    private void addRowTabelaVenda() {
        try {
            ArrayList<WhereClause> whereClause = extrairFiltros();
            ArrayList<Venda> listaVendas = this.vendaController.findAll(whereClause);
            DefaultTableModel tabela = (DefaultTableModel) this.tabelaVenda.getModel();
            for (Venda venda : listaVendas) {

                Cliente cliente = this.clienteController.getById(venda.getIdCliente());
                tabela.addRow(new Object[]{
                    venda.getId(),
                    venda.getIdCliente(),
                    cliente.getNome(),
                    NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(venda.getTotal())
                });

            }

        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }
    }

    private void addRowTabelaCliente() {
        try {
            ArrayList<WhereClause> whereClause = extrairFiltros();
            ArrayList<VendaGroupByCliente> listaVendas = this.vendaController.findVendaGroupCliente(whereClause);
            DefaultTableModel tabela = (DefaultTableModel) this.tabelaVenda.getModel();
            for (VendaGroupByCliente venda : listaVendas) {
                tabela.addRow(new Object[]{
                    venda.getIdCliente(),
                    venda.getNome(),
                    NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(venda.getTotal())
                });

            }

        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }
    }

    private void addRowTabelaProduto() {
        try {
            ArrayList<WhereClause> whereClause = extrairFiltros();
            ArrayList<VendaGroupByProduto> listaVendas = this.vendaController.findVendaGroupProduto(whereClause);
            DefaultTableModel tabela = (DefaultTableModel) this.tabelaVenda.getModel();
            for (VendaGroupByProduto venda : listaVendas) {
                tabela.addRow(new Object[]{
                    venda.getId(),
                    venda.getDescricao(),
                    venda.getQuantidade(),
                    NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(venda.getValor())
                });

            }

        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }
    }

    private ArrayList<WhereClause> extrairFiltros() {
        ArrayList<WhereClause> whereClause = new ArrayList<WhereClause>();

        if (!verificaCampo(this.textCod)) {
            whereClause.add(textFieldToWhereClause("id", textCod));
        }

        if (!verificaCampo(this.textCodCliente)) {
            whereClause.add(textFieldToWhereClause("id_cliente", this.textCodCliente));
        }

        if (!verificaCampo(this.textCodProduto)) {
            whereClause.add(textFieldToWhereClause("id_produto", this.textCodProduto));
        }

        if (!(verificaCampo(this.textDataInicio) && verificaCampo(textDataFim))) {
            whereClause.add(dateToWhereClause("datahoravenda", this.textDataInicio, this.textDataFim));
        }

        return whereClause;
    }

    private boolean verificaCampo(JTextField textField) {
        return textField.getText().isBlank();
    }

    private boolean verificaCampo(JFormattedTextField formattedTextField) {
        return formattedTextField.getValue() == null;
    }

    private WhereClause textFieldToWhereClause(String campo, JTextField textField) {

        return new WhereClause(campo, textField.getText());

    }

    private WhereClause dateToWhereClause(String campo, JFormattedTextField campoDataInicio, JFormattedTextField campoDataFim) {
        String dataInicio = campoDataInicio.getText();
        String dataFim = (String) campoDataFim.getText();
        String periodo = dataInicio + "," + dataFim;

        return new WhereClause(campo, periodo);

    }

    private void verificaDataValida(JFormattedTextField textDate) {
        try {
            if (textDate.getValue() != null) {
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
                System.out.println(LocalDate.parse(textDate.getText(), dateFormat).toString());
            }

        } catch (DateTimeParseException ex) {
            textDate.setText("");
            textDate.setValue(null);
            new CaixaAviso("Data invalida");
            System.out.println(ex.getMessage());
        }

    }
    
    private void desabilitaBotoes() {
        this.buttonExcluir.setEnabled(false);
        this.buttonEditar.setEnabled(false);
    }
    
    private void habilitaBotoes() {
        this.buttonExcluir.setEnabled(true);
        this.buttonEditar.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu buttonConsultar;
    private javax.swing.JMenu buttonEditar;
    private javax.swing.JMenu buttonExcluir;
    private javax.swing.JMenu buttonNovo;
    private javax.swing.ButtonGroup grupoTipoConsulta;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioCliente;
    private javax.swing.JRadioButton radioProduto;
    private javax.swing.JRadioButton radioVenda;
    private javax.swing.JTable tabelaVenda;
    private javax.swing.JTextField textCod;
    private javax.swing.JTextField textCodCliente;
    private javax.swing.JTextField textCodProduto;
    private javax.swing.JFormattedTextField textDataFim;
    private javax.swing.JFormattedTextField textDataInicio;
    // End of variables declaration//GEN-END:variables
}
