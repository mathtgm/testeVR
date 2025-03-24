package vrsoftware.aplicativoteste.view.menuInicial;

import vrsoftware.aplicativoteste.view.cliente.MenuCliente;
import vrsoftware.aplicativoteste.view.ConfiguracaoSistema;
import vrsoftware.aplicativoteste.view.produto.MenuProduto;
import vrsoftware.aplicativoteste.view.venda.MenuVenda;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopMenu = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        buttonMenuCliente = new javax.swing.JMenu();
        buttonMenuProduto = new javax.swing.JMenu();
        buttonMenuVenda = new javax.swing.JMenu();
        buttonConfiguracao = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplicativo de venda");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        javax.swing.GroupLayout desktopMenuLayout = new javax.swing.GroupLayout(desktopMenu);
        desktopMenu.setLayout(desktopMenuLayout);
        desktopMenuLayout.setHorizontalGroup(
            desktopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );
        desktopMenuLayout.setVerticalGroup(
            desktopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );

        buttonMenuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/usuario.png"))); // NOI18N
        buttonMenuCliente.setText("Cliente");
        buttonMenuCliente.setToolTipText("Menu Cliente");
        buttonMenuCliente.setActionCommand("buttonCliente");
        buttonMenuCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMenuClienteMouseClicked(evt);
            }
        });
        jMenuBar1.add(buttonMenuCliente);

        buttonMenuProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/produto.png"))); // NOI18N
        buttonMenuProduto.setText("Produto");
        buttonMenuProduto.setActionCommand("buttonProduto");
        buttonMenuProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMenuProdutoMouseClicked(evt);
            }
        });
        jMenuBar1.add(buttonMenuProduto);

        buttonMenuVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/venda.png"))); // NOI18N
        buttonMenuVenda.setText("Venda");
        buttonMenuVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMenuVendaMouseClicked(evt);
            }
        });
        jMenuBar1.add(buttonMenuVenda);

        buttonConfiguracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/config.png"))); // NOI18N
        buttonConfiguracao.setText("Configuração");
        buttonConfiguracao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonConfiguracaoMouseClicked(evt);
            }
        });
        jMenuBar1.add(buttonConfiguracao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopMenu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopMenu)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMenuClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMenuClienteMouseClicked
        MenuCliente menuCliente = new MenuCliente(this.desktopMenu);
        menuCliente.setVisible(true);
        this.desktopMenu.add(menuCliente);
    }//GEN-LAST:event_buttonMenuClienteMouseClicked

    private void buttonMenuProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMenuProdutoMouseClicked
        MenuProduto menuProduto = new MenuProduto(this.desktopMenu);
        menuProduto.setVisible(true);
        this.desktopMenu.add(menuProduto);
    }//GEN-LAST:event_buttonMenuProdutoMouseClicked

    private void buttonMenuVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMenuVendaMouseClicked
        MenuVenda menuVenda = new MenuVenda(this.desktopMenu);
        menuVenda.setVisible(true);
        this.desktopMenu.add(menuVenda);
    }//GEN-LAST:event_buttonMenuVendaMouseClicked

    private void buttonConfiguracaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonConfiguracaoMouseClicked
        ConfiguracaoSistema configuracaoSistema = new ConfiguracaoSistema();
        configuracaoSistema.setVisible(true);
        this.desktopMenu.add(configuracaoSistema);
    }//GEN-LAST:event_buttonConfiguracaoMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu buttonConfiguracao;
    private javax.swing.JMenu buttonMenuCliente;
    private javax.swing.JMenu buttonMenuProduto;
    private javax.swing.JMenu buttonMenuVenda;
    private javax.swing.JDesktopPane desktopMenu;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
