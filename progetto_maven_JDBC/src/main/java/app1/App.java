package app1;

import java.sql.*;

public class App {

    private static final String URL = "jdbc:postgresql://localhost:5432/accademia";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";

    static void main(){
        String sql = "select * from persona where stipendio = ?";
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1 , 35500);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                System.out.println("ID: "+id+" Nome: "+nome+" Cognome: "+cognome);
            }


        } catch (SQLException e){
            System.out.println("Errore JDBC: "+e.getMessage());
        }
    }
}
