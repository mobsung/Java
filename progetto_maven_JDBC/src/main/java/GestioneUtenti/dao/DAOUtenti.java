package GestioneUtenti.dao;

import GestioneUtenti.Exceptions.CredenzialiErrateException;
import GestioneUtenti.Exceptions.UsernameErratoException;
import GestioneUtenti.Exceptions.UsernameGiaInUsoException;
import GestioneUtenti.dto.Utente;
import GestioneUtenti.db.Database;

import java.sql.*;
import java.util.HashMap;


public class DAOUtenti {

    public static Utente registrazione(String username, String nome, String cognome, String password, int annoNascita) throws UsernameGiaInUsoException {
        String sql = "INSERT INTO utenti (username, nome, cognome, password, anno_nascita) VALUES (?, ?, ?, ?, ?)";

        try{
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, nome);
            ps.setString(3, cognome);
            ps.setString(4, password);
            ps.setInt(5, annoNascita);

            ps.execute();

            return new Utente(username, nome, cognome, password, annoNascita);
        } catch (SQLException e){
            throw new UsernameGiaInUsoException(e.getMessage());
        }

    }

    public static boolean login(Utente utente) throws CredenzialiErrateException {
        String sql = "select nome, cognome from utenti where username = (?) and password = (?)";

        try{
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, utente.getUsername());
            ps.setString(2, utente.getPassword());
            return ps.executeUpdate() == 1;
        } catch (SQLException e){
            throw new CredenzialiErrateException(e.getMessage());
        }
    }

    public static boolean modificaPassword(Utente utente, String password){
        String sql = "update utenti set password = (?) where username = (?) and password = (?)";

        try{
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, utente.getUsername());
            ps.setString(3, utente.getPassword());
            utente.setPassword(password);
            return ps.executeUpdate() == 1;
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    public static boolean cancellaUtente(String username) throws UsernameErratoException {
        String sql = "delete from utenti where username = (?)";

        try{
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            return ps.executeUpdate() == 1;
        } catch (SQLException e){
            throw new UsernameErratoException(e.getMessage());
        }
    }

    public static HashMap<String, Utente> visualizzaUtenti(){
        String sql = "select * from utenti";

        HashMap<String, Utente> ut = new HashMap<>();

        try{
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ut.put(rs.getString("username"),
                        new Utente(
                                rs.getString("username"),
                                rs.getString("nome"),
                                rs.getString("cognome"),
                                rs.getString("password"),
                                rs.getInt("anno_nascita")));
            }
            return ut;

        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

}
