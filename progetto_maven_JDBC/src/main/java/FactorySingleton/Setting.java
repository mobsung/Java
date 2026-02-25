package FactorySingleton;

import java.util.List;
import java.util.Scanner;

public class Setting {

    public static void main(String[] args) {

        Statistiche statistiche = new Statistiche();

        System.out.println("Scegli formato export:");
        System.out.println("1 - JSON");
        System.out.println("2 - CVS");

        Scanner sc = new Scanner(System.in);
        int scelta = sc.nextInt();

        String className = "";

        List<String> exportTypes = statistiche.getExportType();

        switch (scelta) {
            case 1:
                className = "FactorySingleton." + exportTypes.get(0);
                break;
            case 2:
                className = "FactorySingleton." + exportTypes.get(1);
                break;
            default:
                System.out.println("Scelta non valida");
                System.exit(0);
        }

        DataExport exporter = FactoryDataExport.getExporter(className);

        statistiche.setExporter(exporter);

        statistiche.exportCategory();
        statistiche.exportCity();

        System.out.println("Export completato in formato: " + exporter.getMime());
    }
}
