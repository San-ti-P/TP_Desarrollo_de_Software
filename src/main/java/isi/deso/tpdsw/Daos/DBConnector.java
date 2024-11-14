
package isi.deso.tpdsw.Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author santi
 */
public class DBConnector {
    
    private static DBConnector CONNECTOR_INSTANCE;
    
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String DB = "desotest";
    
    private Connection connection;
    
    private DBConnector(){
        try {
            connection = DriverManager.getConnection(URL+"/"+DB, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex.getLocalizedMessage());
        }
    }
    
    public static DBConnector getConnector(){
        if(CONNECTOR_INSTANCE == null) {
            CONNECTOR_INSTANCE = new DBConnector();
        }
        return CONNECTOR_INSTANCE;
    }
    
    public Connection getConnection(){
        return connection;
    }
}
