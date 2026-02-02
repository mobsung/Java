package ReportAziendale.dao;

import GestioneUtenti.Exceptions.UsernameGiaInUsoException;
import GestioneUtenti.db.Database;
import GestioneUtenti.dto.Utente;
import ReportAziendale.dto.Impiegato;
import java.sql.*;


public class DAOImpiegato {

    public void inserisciImpiegatoConMansione(Impiegato impiegato){
        String sql = "insert into impiegato (matricola, nome, salarioMensile, bonusAnnuale, mansione) values (?, ?, ?, ?, ?)";

        try{
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, impiegato.getMatricola());
            ps.setString(2, impiegato.getNome());
            ps.setInt(3, impiegato.getSalarioMensile());
            ps.setInt(4, impiegato.getBonusAnnuale());
            ps.setObject(5, impiegato.getMansione());

            ps.execute();
            
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    public void inserisciImpiegatoSenzaMansione(Impiegato impiegato){
        String sql = "insert into impiegato (matricola, nome, salarioMensile, bonusAnnuale) values (?, ?, ?, ?)";

        try{
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, impiegato.getMatricola());
            ps.setString(2, impiegato.getNome());
            ps.setInt(3, impiegato.getSalarioMensile());
            ps.setInt(4, impiegato.getBonusAnnuale());

            ps.execute();

        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }



}
