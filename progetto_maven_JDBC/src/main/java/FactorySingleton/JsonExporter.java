package FactorySingleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonExporter implements DataExport{

    @Override
    public void export(List<String> data, String filename) {
        String text = "{\n";
        for(int i = 0; i < data.size(); i++){
            String [] array = data.get(i).split(":");
            text += "    \"" + array[0] + "\"" + ": " + "\"" + array[1] + "\"";
            if(i < data.size() - 1){
                text += ",\n";
            }
        }
        text += "\n}\n";

        try{
            BufferedWriter bf = new BufferedWriter(new FileWriter(filename, true));
            bf.write(text);
            bf.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getMime() {
        return "application/json";
    }
}
