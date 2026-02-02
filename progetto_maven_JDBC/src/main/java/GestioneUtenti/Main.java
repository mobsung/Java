package GestioneUtenti;

import GestioneUtenti.Exceptions.UsernameGiaInUsoException;
import GestioneUtenti.dao.DAOUtenti;
import GestioneUtenti.dto.Utente;

import java.util.HashMap;

public class Main {
    static void main() {

        HashMap<String, Utente> utentiRegistrati = new HashMap<>();

        try{
            Utente ut  = DAOUtenti.registrazione("MATTEW" , "Matteo", "Fabbrizio", "MattPass", 1500);
            utentiRegistrati.put(ut.getUsername(), ut);
        } catch(UsernameGiaInUsoException e){
            System.out.println(e.getMessage());
        }

        utentiRegistrati.putAll(DAOUtenti.visualizzaUtenti());

        System.out.println("\ntest aggiunta oggetto");
        utentiRegistrati.forEach((us, u) -> System.out.println(u));

        boolean utCanc = DAOUtenti.cancellaUtente("CRISCOCCIA");
        utentiRegistrati.remove("CRISCOCCIA");

        System.out.println("\ntest rimozione oggetto");
        utentiRegistrati.forEach((us, u) -> System.out.println(u));

        System.out.println("\nTest modifica password");
        DAOUtenti.modificaPassword(utentiRegistrati.get("MATTEW"), "MatPassModificata");
        utentiRegistrati.forEach((us, u) -> System.out.println(u));



    }
}
