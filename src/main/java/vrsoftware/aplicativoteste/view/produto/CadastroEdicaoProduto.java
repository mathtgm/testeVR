package vrsoftware.aplicativoteste.view.produto;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vrsoftware.aplicativoteste.controller.produto.ProdutoController;
import vrsoftware.aplicativoteste.model.Produto;
import vrsoftware.aplicativoteste.view.CaixaMensagem;
import vrsoftware.aplicativoteste.view.document.LimiteTexto;

public class CadastroEdicaoProduto extends javax.swing.JInternalFrame {

    private Produto produto;

    public CadastroEdicaoProduto() {
        initComponents();
        initCadastroProduto();
    }

    public CadastroEdicaoProduto(Produto produto) {
        initComponents();
        this.produto = produto;
        initEdicaoProduto();
    }

    public void initCadastroProduto() {
        this.setTitle("Cadastro de produto");
    }

    public void initEdicaoProduto() {
        this.setTitle("Edição de produto");
        preencheFormulario();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textId = new javax.swing.JTextField();
        textDescricao = new javax.swing.JTextField();
        textPreco = new javax.swing.JFormattedTextField();
        comboStatus = new javax.swing.JComboBox<>();
        buttonSalvar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setLayer(1);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        textId.setEditable(false);
        textId.setBorder(javax.swing.BorderFactory.createTitledBorder("Código"));

        textDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));
        textDescricao.setDocument(new LimiteTexto(80));

        textPreco.setBorder(javax.swing.BorderFactory.createTitledBorder("Preço (R$)"));
        textPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EXCLUIDO", "ATIVO" }));
        comboStatus.setSelectedIndex(1);
        comboStatus.setToolTipText("");
        comboStatus.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSalvar)
                    .addComponent(buttonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_buttonCancelarMouseClicked

    private void buttonSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSalvarMouseClicked
        try {
            ProdutoController produtoController = new ProdutoController();
            if (this.produto != null) {
                salvarProduto(produtoController);
            } else {
                criarProduto(produtoController);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroEdicaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new CaixaMensagem("Produto salvo");
            this.dispose();
        }
    }//GEN-LAST:event_buttonSalvarMouseClicked

    private void salvarProduto(ProdutoController produtoController) {
        try {
            this.produto = montaProduto();
            produtoController.update(this.produto);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroEdicaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void criarProduto(ProdutoController produtoController) {
        try {
            Produto produto = montaProduto();
            produtoController.create(produto);
            
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroEdicaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Produto montaProduto() {
        Produto produto = new Produto();
        if (!textId.getText().isBlank()) {
            produto.setId(Integer.valueOf(textId.getText()));
        }
        produto.setDescricao(textDescricao.getText());
        produto.setPreco(formatToDouble(textPreco.getText()));
        produto.setStatus(this.comboStatus.getSelectedIndex());
        
        return produto;
    }
    
    private Double formatToDouble(String valor) {
        String valorFormatado = valor.replace(".", "").replace(",", ".");
        return Double.parseDouble(valorFormatado);
    }
    
    private void preencheFormulario() {
        this.textId.setText(String.valueOf(produto.getId()));
        this.textPreco.setValue(produto.getPreco());
        this.textDescricao.setText(produto.getDescricao());
        this.comboStatus.setSelectedIndex(produto.getStatus());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JTextField textDescricao;
    private javax.swing.JTextField textId;
    private javax.swing.JFormattedTextField textPreco;
    // End of variables declaration//GEN-END:variables
}
