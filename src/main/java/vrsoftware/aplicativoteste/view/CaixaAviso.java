package vrsoftware.aplicativoteste.view;

import javax.swing.JOptionPane;

public class CaixaAviso {

    public CaixaAviso(String msg) {
        JOptionPane.showMessageDialog(null, "Erro ao executar ação: " + msg);
    }

}
