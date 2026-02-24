package FactorySingleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CvsExporter implements DataExport{

    @Override
    public void export(List<String> data, String filename) {
        String text = "";
        for(int i = 0; i < data.size(); i++){
            text += data.get(i);
            if(i < data.size() - 1){
                text += ", ";
            }
        }
        text += "\n";

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
        return "text/cvs";
    }
}
