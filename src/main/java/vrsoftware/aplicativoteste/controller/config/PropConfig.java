package vrsoftware.aplicativoteste.controller.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropConfig {
    
    private final Properties prop;
    private final FileInputStream arquivo;

    public PropConfig() throws FileNotFoundException {
        this.prop = new Properties();
        this.arquivo = new FileInputStream("./config.properties");
        carregaProp();
    }
    
    private void carregaProp() {
        try {
            this.prop.load(arquivo);
        } catch (IOException ex) {
            Logger.getLogger("Arquivo de configuração não encontrado");
        }
    }
    
    public Properties getProp() {
        return prop;
    }
    
    
}
