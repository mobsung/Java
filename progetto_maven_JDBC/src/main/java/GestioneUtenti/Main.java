package GestioneUtenti;

import GestioneUtenti.dao.DAOUtenti;
import GestioneUtenti.dto.Utente;

import java.util.HashMap;

public class Main {
    static void main() {

        HashMap<String, Utente> utentiRegistrati = new HashMap<>();

        Utente ut  = DAOUtenti.registrazione("MATTEW" , "Matteo", "Fabbrizio", "MattPass", 1500);
        utentiRegistrati.put(ut.getUsername(), ut);

        utentiRegistrati.putAll(DAOUtenti.visualizzaUtenti());

        utentiRegistrati.forEach((us, u) -> System.out.println(u));

        boolean utCanc = DAOUtenti.cancellaUtente("CRISCOCCIA");
        utentiRegistrati.remove("CRISCOCCIA");

        System.out.println(" ");
        utentiRegistrati.forEach((us, u) -> System.out.println(u));


    }
}
