package vrsoftware.aplicativoteste.view.venda;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import vrsoftware.aplicativoteste.controller.produto.ProdutoController;
import vrsoftware.aplicativoteste.model.Produto;
import vrsoftware.aplicativoteste.model.VendaItem;
import vrsoftware.aplicativoteste.view.CaixaAviso;

public class AdicionaProduto extends javax.swing.JDialog {
    
    private VendaItem item = null;
    private Produto produto = null;

    public AdicionaProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public VendaItem getItem() {
        return item;
    }
    
    public void setItem(VendaItem vendaItem) {
        this.item = vendaItem;
        edicaoItem();
    }
    
    public void edicaoItem() {
        this.textId.setEditable(false);
        preencherCamposEdicao();
    }
    
    public void preencherCamposEdicao() {
        try {
            ProdutoController produtoController = new ProdutoController();
            this.produto = produtoController.getById(item.getIdProduto());
            textId.setText(String.valueOf(item.getIdProduto()));
            atualizaCampos();
            desabilitaCamposEdicao();
        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textId = new javax.swing.JTextField();
        textDescricao = new javax.swing.JTextField();
        spinnerQuantidade = new javax.swing.JSpinner();
        buttonAdd = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        labelPrecoUnid = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        textId.setBorder(javax.swing.BorderFactory.createTitledBorder("Cod."));
        textId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textIdFocusLost(evt);
            }
        });

        textDescricao.setEditable(false);
        textDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));

        spinnerQuantidade.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinnerQuantidade.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantidade"));
        spinnerQuantidade.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                spinnerQuantidadePropertyChange(evt);
            }
        });

        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicionar.png"))); // NOI18N
        buttonAdd.setText("Adicionar");
        buttonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAddMouseClicked(evt);
            }
        });

        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancelar.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCancelarMouseClicked(evt);
            }
        });

        labelPrecoUnid.setBorder(javax.swing.BorderFactory.createTitledBorder("Preço unid"));

        labelTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Total R$"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textDescricao))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(spinnerQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelPrecoUnid, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(buttonAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonCancelar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinnerQuantidade)
                    .addComponent(labelPrecoUnid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdd)
                    .addComponent(buttonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textIdFocusLost
        try {
            ProdutoController produtoController = new ProdutoController();
            this.produto = produtoController.getById(Integer.parseInt(textId.getText()));

            atualizaCampos();

        } catch (SQLException ex) {
            new CaixaAviso(ex.getMessage());
        }
    }//GEN-LAST:event_textIdFocusLost

    private void spinnerQuantidadePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_spinnerQuantidadePropertyChange
        atualizaCampos();
    }//GEN-LAST:event_spinnerQuantidadePropertyChange

    private void buttonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddMouseClicked
        if (this.produto != null) {
            montaVendaItem();
            this.dispose();
        }
    }//GEN-LAST:event_buttonAddMouseClicked

    private void buttonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_buttonCancelarMouseClicked
    
    private void atualizaCampos() {
        if (this.produto != null) {
            int quantidade = (Integer) this.spinnerQuantidade.getValue();
            double precoUnid = this.produto.getPreco();
            Double total = quantidade * precoUnid;

            labelTotal.setText(NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(total));
            labelPrecoUnid.setText(NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(this.produto.getPreco()));
            textDescricao.setText(this.produto.getDescricao());
        }

    }
    
    private void desabilitaCamposEdicao() {
        this.textId.setEditable(false);
    }
    
    private void montaVendaItem() {
        if(this.item == null) {
            this.item = new VendaItem();
        }
        this.item.setIdProduto(produto.getId());
        this.item.setPreco(this.produto.getPreco());
        this.item.setQuantidade((Integer) this.spinnerQuantidade.getValue());
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdicionaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdicionaProduto dialog = new AdicionaProduto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JLabel labelPrecoUnid;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JSpinner spinnerQuantidade;
    private javax.swing.JTextField textDescricao;
    private javax.swing.JTextField textId;
    // End of variables declaration//GEN-END:variables
}
