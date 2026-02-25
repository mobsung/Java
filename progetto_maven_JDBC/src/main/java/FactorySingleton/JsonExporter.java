package FactorySingleton;

import java.util.List;

public class JsonExporter implements DataExport{

    private static JsonExporter instance;

    private JsonExporter() {}

    public static JsonExporter getInstance() {
        if (instance == null) {
            instance = new JsonExporter();
        }
        return instance;
    }

    @Override
    public String formatter(List<String> data) {
        String text = "{\n";
        for(int i = 0; i < data.size(); i++){
            String [] array = data.get(i).split(":");
            text += "    \"" + array[0] + "\"" + ": " + "\"" + array[1] + "\"";
            if(i < data.size() - 1){
                text += ",\n";
            }
        }
        text += "\n}\n";
        return text;
    }

    @Override
    public String getMime() {
        return "application/json";
    }
}
