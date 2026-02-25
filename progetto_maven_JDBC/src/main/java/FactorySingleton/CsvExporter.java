package FactorySingleton;

import java.util.List;

public class CsvExporter implements DataExport{

    private static CsvExporter instance;

    private CsvExporter() {}

    public static CsvExporter getInstance() {
        if (instance == null) {
            instance = new CsvExporter();
        }
        return instance;
    }

    public String formatter(List<String> data) {
        String text = "";
        for(int i = 0; i < data.size(); i++){
            text += data.get(i);
            if(i < data.size() - 1){
                text += ", ";
            }
        }
        text += "\n";
        return text;

    }

    @Override
    public String getMime() {
        return "text/csv";
    }
}
