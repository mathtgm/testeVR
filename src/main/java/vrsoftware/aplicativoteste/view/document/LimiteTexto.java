package vrsoftware.aplicativoteste.view.document;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimiteTexto extends PlainDocument {
    
    private int limite;

    public LimiteTexto() {
    }
    
    
    public LimiteTexto(int limite) {
        super();
        this.limite = limite;
    }
    
    
    
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if(offs <= limite) {
            super.insertString(offs, str, a);
        } else {
            return;
        }
        
    }
    
}
