package vrsoftware.aplicativoteste.controller.database;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import vrsoftware.aplicativoteste.controller.config.PropConfig;

public class ConnectionFactory {

    private Properties properties = null;

    public ConnectionFactory() {
        try {
            this.properties = new PropConfig().getProp();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConexaoBanco() throws SQLException {
        Connection conexao = null;
        try {
            Class.forName("org.postgresql.Driver");
            
            
            String host = properties.getProperty("database.host");
            String port = properties.getProperty("database.port");
            String database = properties.getProperty("database.name");
            String user = properties.getProperty("database.user");
            String pswd = properties.getProperty("database.password");
            
            String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
            
            conexao = DriverManager.getConnection(url, user, pswd);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return conexao;
        }
    }


}
