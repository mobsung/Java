package ReportAziendale.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private static final String PROPS_FILE= "/dbGestioneUtenti.properties";
    private static final Properties props=new Properties();

    static {
        try {
            InputStream in = GestioneUtenti.db.Database.class.getResourceAsStream(PROPS_FILE);
            if(in==null) {
                throw new RuntimeException("Errore nella lettura delle properties: "+PROPS_FILE);
            }
            props.load(in);
        }catch(IOException e) {
            throw new RuntimeException("Errore nella lettura delle properties: "+PROPS_FILE,e);
        }
    }

    public static Connection getConnection() throws SQLException {

        String URL=props.getProperty("db.url");
        String USER=props.getProperty("db.user");
        String PASS=props.getProperty("db.password");

        return  DriverManager.getConnection(URL,USER,PASS);
    }
}
