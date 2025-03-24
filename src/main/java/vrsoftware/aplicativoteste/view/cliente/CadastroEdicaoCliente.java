package vrsoftware.aplicativoteste.view.cliente;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vrsoftware.aplicativoteste.controller.cliente.ClienteController;
import vrsoftware.aplicativoteste.model.Cliente;
import vrsoftware.aplicativoteste.view.CaixaMensagem;
import vrsoftware.aplicativoteste.view.document.LimiteTexto;
import vrsoftware.aplicativoteste.view.document.OnlyNumbers;

public class CadastroEdicaoCliente extends javax.swing.JInternalFrame {

    Cliente cliente = null;

    public CadastroEdicaoCliente() {
        initComponents();
        initTelaCadastro();
    }

    public CadastroEdicaoCliente(Cliente cliente) {
        initComponents();
        initTelaEdicao(cliente);
    }

    public void initTelaCadastro() {
        this.title = "Cadastro de cliente";
        this.comboStatus.setEnabled(false);
    }

    public void initTelaEdicao(Cliente cliente) {
        this.title = "Edição de cliente";
        this.cliente = cliente;
        preencheFormulario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textId = new javax.swing.JTextField();
        textNome = new javax.swing.JTextField();
        textDiaFechamento = new javax.swing.JTextField();
        buttonSalvar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        textLimiteCompra = new javax.swing.JFormattedTextField();
        comboStatus = new javax.swing.JComboBox<>();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setLayer(1);

        textId.setEditable(false);
        textId.setBorder(javax.swing.BorderFactory.createTitledBorder("Código"));

        textNome.setToolTipText("");
        textNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));
        textNome.setDocument(new LimiteTexto(80));

        textDiaFechamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Dia Fechamento Fatura"));
        textDiaFechamento.setDocument(new OnlyNumbers());

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

        textLimiteCompra.setBorder(javax.swing.BorderFactory.createTitledBorder("Limite compra"));
        textLimiteCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EXCLUIDO", "ATIVO" }));
        comboStatus.setSelectedIndex(1);
        comboStatus.setToolTipText("");
        comboStatus.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNome))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textLimiteCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textDiaFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textLimiteCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDiaFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSalvar)
                    .addComponent(buttonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSalvarMouseClicked
        try {
            ClienteController clienteController = new ClienteController();
            if (this.cliente != null) {
                salvarCliente(clienteController);
            } else {
                criarCliente(clienteController);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroEdicaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new CaixaMensagem("Cliente salvo");
            this.dispose();
        }

    }//GEN-LAST:event_buttonSalvarMouseClicked

    private void buttonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_buttonCancelarMouseClicked

    private void salvarCliente(ClienteController clienteController) {
        try {
            this.cliente = montaCliente();
            clienteController.update(this.cliente);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroEdicaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void criarCliente(ClienteController clienteController) {
        try {
            Cliente cliente = montaCliente();
            clienteController.create(cliente);
            
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroEdicaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Cliente montaCliente() {
        Cliente cliente = new Cliente();

        if (!textId.getText().isBlank()) {
            cliente.setId(Integer.parseInt(textId.getText()));
        }

        cliente.setNome(textNome.getText());
        cliente.setDiaFechamentoFatura(Integer.parseInt(textDiaFechamento.getText()));
        cliente.setValorLimiteCompra(formatToDouble(textLimiteCompra.getText()));
        cliente.setStatus(comboStatus.getSelectedIndex());

        return cliente;
    }

    private Double formatToDouble(String valor) {
        String valorFormatado = valor.replace(".", "").replace(",", ".");
        return Double.parseDouble(valorFormatado);
    }

    private void preencheFormulario() {
        this.textId.setText(String.valueOf(cliente.getId()));
        this.textLimiteCompra.setValue(cliente.getValorLimiteCompra());
        this.textNome.setText(cliente.getNome());
        this.textDiaFechamento.setText(String.valueOf(cliente.getDiaFechamentoFatura()));
        this.comboStatus.setSelectedIndex(cliente.getStatus());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JTextField textDiaFechamento;
    private javax.swing.JTextField textId;
    private javax.swing.JFormattedTextField textLimiteCompra;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}
