package ReportAziendale.dto;

public class Mansione {

    private final String mansione;
    private int stipendioMin;
    private int getStipendioMax;

    public Mansione(String mansione, int stipendioMin, int getStipendioMax) {
        this.mansione = mansione;
        this.stipendioMin = stipendioMin;
        this.getStipendioMax = getStipendioMax;
    }

    public String getMansione() {
        return mansione;
    }

    public int getStipendioMin() {
        return stipendioMin;
    }

    public int getGetStipendioMax() {
        return getStipendioMax;
    }
}
