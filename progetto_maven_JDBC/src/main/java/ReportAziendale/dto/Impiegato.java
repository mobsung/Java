package ReportAziendale.dto;

public class Impiegato {

    private final String matricola;
    private String nome;
    private int salarioMensile;
    private int bonusAnnuale;
    private Mansione mansione;

    public Impiegato(String matricola, String nome, int salarioMensile, int bonusAnnuale) {
        this.matricola = matricola;
        this.nome = nome;
        this.salarioMensile = salarioMensile;
        this.bonusAnnuale = bonusAnnuale;
    }

    public Impiegato(String matricola, String nome, int salarioMensile, int bonusAnnuale, Mansione mansione) {
        this.matricola = matricola;
        this.nome = nome;
        this.salarioMensile = salarioMensile;
        this.bonusAnnuale = bonusAnnuale;
        setMansione(mansione);
    }

    public String getMatricola() {
        return matricola;
    }

    public String getNome() {
        return nome;
    }

    public int getSalarioMensile() {
        return salarioMensile;
    }

    public int getBonusAnnuale() {
        return bonusAnnuale;
    }

    public Mansione getMansione() {
        return mansione;
    }

    public void setMansione(Mansione mansione) {
        this.mansione = mansione;
    }
}
