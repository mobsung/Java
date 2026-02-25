package FactorySingleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public interface DataExport {

    String formatter(List<String> data);

    default void export(List<String> data, String filename){
        try{
            BufferedWriter bf = new BufferedWriter(new FileWriter(filename, true));
            bf.write(formatter(data));
            bf.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    String getMime();


}
