package FactorySingleton;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Statistiche s = new Statistiche();

        List<String> exportTypes = s.getExportType();
        System.out.println(exportTypes);
    }
}
