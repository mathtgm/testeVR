package vrsoftware.aplicativoteste.view.venda;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import vrsoftware.aplicativoteste.controller.cliente.ClienteController;
import vrsoftware.aplicativoteste.controller.produto.ProdutoController;
import vrsoftware.aplicativoteste.controller.venda.VendaController;
import vrsoftware.aplicativoteste.controller.vendaitem.VendaItemController;
import vrsoftware.aplicativoteste.model.Cliente;
import vrsoftware.aplicativoteste.model.Produto;
import vrsoftware.aplicativoteste.model.Venda;
import vrsoftware.aplicativoteste.model.VendaItem;
import vrsoftware.aplicativoteste.view.CaixaAviso;
import vrsoftware.aplicativoteste.view.CaixaMensagem;
import vrsoftware.aplicativoteste.view.document.OnlyNumbers;

public class CadastroEdicaoVenda extends javax.swing.JInternalFrame {

    Venda venda = null;
    Cliente cliente = null;
    ArrayList<VendaItem> vendaItems = new ArrayList<>();
    VendaController vendaController;

    public CadastroEdicaoVenda() {
        initComponents();
        initControllers();
        initCadastroVenda();

    }

    public CadastroEdicaoVenda(Venda venda) {
        initComponents();
        initControllers();
        this.venda = venda;
        initAtualizacaoVenda();
    }

    private void initCadastroVenda() {
        this.setTitle("Cadastro de venda");
    }

    private void initAtualizacaoVenda() {
        this.setTitle("Atualização de venda");
        buscaListaVendaItem();
        preencheCampos();
    }

    private void initControllers() {
        try {
            this.vendaController = new VendaController();
        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textCodCliente = new javax.swing.JTextField();
        textNomeCliente = new javax.swing.JTextField();
        textTotalVenda = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListaItem = new javax.swing.JTable();
        buttonAdd = new javax.swing.JButton();
        buttonExlcude = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        buttonSalvar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        textCodVenda = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setLayer(1);

        textCodCliente.setDocument(new OnlyNumbers());
        textCodCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cod. Cliente"));
        textCodCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textCodClienteFocusLost(evt);
            }
        });

        textNomeCliente.setEditable(false);
        textNomeCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome cliente"));

        textTotalVenda.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        textTotalVenda.setText("R$ 0,00");
        textTotalVenda.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Venda"));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));

        tableListaItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Descrição", "Quantidade", "Preço Unid.", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableListaItem.setOpaque(false);
        tableListaItem.setShowGrid(true);
        jScrollPane1.setViewportView(tableListaItem);

        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicionar.png"))); // NOI18N
        buttonAdd.setToolTipText("Adicionar produto");
        buttonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAddMouseClicked(evt);
            }
        });

        buttonExlcude.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excluir.png"))); // NOI18N
        buttonExlcude.setToolTipText("Remover produto");
        buttonExlcude.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonExlcudeMouseClicked(evt);
            }
        });

        buttonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/alterar.png"))); // NOI18N
        buttonEditar.setToolTipText("Editar produto");
        buttonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEditarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonExlcude)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEditar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAdd)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(buttonExlcude, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(buttonEditar, javax.swing.GroupLayout.Alignment.TRAILING))))
        );

        buttonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salvar.png"))); // NOI18N
        buttonSalvar.setText("Salvar");
        buttonSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSalvarMouseClicked(evt);
            }
        });

        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancelar.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCancelarMouseClicked(evt);
            }
        });

        textCodVenda.setEditable(false);
        textCodVenda.setBorder(javax.swing.BorderFactory.createTitledBorder("Cod."));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(textCodVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNomeCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCodVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCancelar)
                            .addComponent(buttonSalvar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(textTotalVenda))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddMouseClicked
        AdicionaProduto adicionaProduto = new AdicionaProduto(null, true);
        adicionaProduto.setVisible(true);
        VendaItem vendaItem = adicionaProduto.getItem();
        if (!isProdutoExistaLista(vendaItem)) {
            this.vendaItems.add(vendaItem);
            atualizaValorTotal();
            addRowTabelaProduto(vendaItem);
        } else {
            new CaixaMensagem("Produto não pode ser adicionado, pois já existe na lista");
        }
    }//GEN-LAST:event_buttonAddMouseClicked

    private void buttonExlcudeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonExlcudeMouseClicked
        if (isLinhaTabelaSelecionada()) {
            int indexLinha = this.tableListaItem.getSelectedRow();
            int idProduto = (int) this.tableListaItem.getValueAt(indexLinha, 0);
            removeVendaItemLista(idProduto);
            atualizaValorTotal();
            atualizaTabela();
        } else {
            new CaixaMensagem("Selecione algum produto para exclusão");
        }
    }//GEN-LAST:event_buttonExlcudeMouseClicked


    private void buttonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEditarMouseClicked
        AdicionaProduto adicionaProduto = new AdicionaProduto(null, true);
        if (isLinhaTabelaSelecionada()) {
            VendaItem vendaItem = getItemSelecionado();
            adicionaProduto.setItem(vendaItem);
            adicionaProduto.setVisible(true);
            if (vendaItem != null) {
                atualizaItemLista(vendaItem);
                atualizaValorTotal();
                atualizaTabela();
            }
        } else {
            new CaixaMensagem("Por favor selecione um produto para editar");
        }

    }//GEN-LAST:event_buttonEditarMouseClicked

    private void buttonSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSalvarMouseClicked
        clienteTemCredito(this.cliente);
        if (isCamposVazios()) {
            if (this.venda == null) {
                cadastroVenda();
            } else {
                atualizacaoVenda();
            }
            new CaixaMensagem("Venda salva!");
            this.dispose();
        }
    }//GEN-LAST:event_buttonSalvarMouseClicked

    private void textCodClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textCodClienteFocusLost
        preencheNomeCliente();
    }//GEN-LAST:event_textCodClienteFocusLost

    private void buttonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_buttonCancelarMouseClicked

    private void buscaListaVendaItem() {
        try {
            VendaItemController vendaItemController = new VendaItemController();
            this.vendaItems = vendaItemController.findByIdVenda(this.venda.getId());
        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }
    }

    private void preencheCampos() {
        this.textCodVenda.setText(String.valueOf(venda.getId()));
        this.textCodCliente.setText(String.valueOf(venda.getIdCliente()));
        this.textTotalVenda.setText(getFormatDinheiroValor(totalVendaItem()));
        preencheNomeCliente();
        atualizaTabela();
    }

    private void preencheNomeCliente() {
        try {
            ClienteController clienteController = new ClienteController();
            this.cliente = clienteController.getById(Integer.parseInt(this.textCodCliente.getText()));
            if (this.cliente != null) {
                this.textNomeCliente.setText(this.cliente.getNome());
            } else {
                this.textNomeCliente.setText("");
                new CaixaMensagem("Cliente não encontrado");
            }

        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }
    }

    private void addRowTabelaProduto(VendaItem item) {
        try {
            Produto produto = new ProdutoController().getById(item.getIdProduto());
            DefaultTableModel tabelaProduto = (DefaultTableModel) this.tableListaItem.getModel();
            tabelaProduto.addRow(new Object[]{
                item.getIdProduto(),
                produto.getDescricao(),
                item.getQuantidade(),
                NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(item.getPreco()),
                NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(item.getQuantidade() * item.getPreco())
            }
            );
        } catch (SQLException ex) {
            Logger.getLogger(CadastroEdicaoVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean isLinhaTabelaSelecionada() {
        return this.tableListaItem.getSelectedRow() != -1;
    }

    private void removeVendaItemLista(int idProduto) {
        this.vendaItems.forEach((item) -> {
            if (idProduto == item.getIdProduto()) {
                this.vendaItems.remove(item);
            }
        });
    }

    private VendaItem getItemSelecionado() {

        int index = this.tableListaItem.getSelectedRow();
        int idProduto = (Integer) this.tableListaItem.getValueAt(index, 0);
        Optional<VendaItem> vendaItem = this.vendaItems.stream().filter((item) -> item.getIdProduto() == idProduto).findFirst();

        return vendaItem.get();
    }

    private void atualizaValorTotal() {
        this.textTotalVenda.setText(getFormatDinheiroValor(totalVendaItem()));
    }

    private String getFormatDinheiroValor(double valor) {
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valor);
    }

    private void atualizaItemLista(VendaItem vendaItem) {
        this.vendaItems.forEach((item) -> {
            if (item.getIdProduto() == vendaItem.getIdProduto()) {
                item.setQuantidade(vendaItem.getQuantidade());
            }
        });
    }

    private void atualizaTabela() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) this.tableListaItem.getModel();
        defaultTableModel.setRowCount(0);
        this.vendaItems.forEach((item) -> {
            addRowTabelaProduto(item);
        });
    }

    private double totalVendaItem() {
        double totalVenda = this.vendaItems.stream()
                .map((item) -> item.getPreco() * item.getQuantidade())
                .reduce(0.00, (valor1, valor2) -> valor1 + valor2);

        return totalVenda;
    }

    private void cadastroVenda() {
        try {
            montaVenda();
            this.vendaController.create(this.venda);
        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
            Logger.getLogger(CadastroEdicaoVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void atualizacaoVenda() {
        try {
            montaVenda();
            this.vendaController.update(this.venda);
        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }
    }

    private void montaVenda() {
        if (this.venda == null) {
            this.venda = new Venda();
        }

        this.venda.setIdCliente(Integer.parseInt(textCodCliente.getText()));
        this.venda.setListaItem(vendaItems);
        this.venda.setTotal(totalVendaItem());
    }

    private boolean isProdutoExistaLista(VendaItem item) {
        boolean isProdutoExiste = this.vendaItems.stream()
                .map((vendaItem) -> vendaItem.getIdProduto())
                .anyMatch((idProduto) -> item.getIdProduto() == idProduto);

        return isProdutoExiste;
    }

    private boolean isCamposVazios() {
        if (textCodCliente.getText().isBlank()) {
            new CaixaMensagem("Impossível salvar, pois há campos sem preencher");
            return true;
        }

        return false;
    }

    public boolean clienteTemCredito(Cliente cliente) {
        try {
            Calendar dataInicio = Calendar.getInstance(new Locale("pt", "BR"));
            Calendar dataFim = Calendar.getInstance(new Locale("pt", "BR"));

            dataInicio.set(Calendar.DAY_OF_MONTH, cliente.getDiaFechamentoFatura());
            dataFim.set(Calendar.DAY_OF_MONTH, cliente.getDiaFechamentoFatura());
            dataFim.add(Calendar.DAY_OF_MONTH, 30);

            Double valorLimite = cliente.getValorLimiteCompra();
            Double totalVenda = totalVendaItem();
            Double valorTotalVendasCliente = this.vendaController.getValorTotalVendaClienteCredito(cliente.getId(), dataInicio.getTime(), dataFim.getTime());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            if ((valorTotalVendasCliente + totalVenda) >= cliente.getValorLimiteCompra()) {
                new CaixaMensagem("Limite excedido, valor dispoível: "
                        + getFormatDinheiroValor(valorLimite - (valorTotalVendasCliente + totalVenda))
                        + "\n Próximo dia de fechamento: " + dateFormat.format(dataFim.getTime()));
                return false;
            }

        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonExlcude;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableListaItem;
    private javax.swing.JTextField textCodCliente;
    private javax.swing.JTextField textCodVenda;
    private javax.swing.JTextField textNomeCliente;
    private javax.swing.JLabel textTotalVenda;
    // End of variables declaration//GEN-END:variables

}
