package GestioneUtenti.dto;

import java.util.Objects;

public class Utente {

    private final String username;
    private final String nome;
    private final String cognome;
    private String password;
    private final int annoNascita;

    public Utente(String username, String nome, String cognome, String password, int annoNascita) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.annoNascita = annoNascita;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAnnoNascita() {
        return annoNascita;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", annoNascita=" + annoNascita +
                '}';
    }
}
