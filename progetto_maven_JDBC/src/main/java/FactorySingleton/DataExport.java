package FactorySingleton;

import java.util.List;

public interface DataExport {

    void export(List<String> data, String filename);

    String getMime();

}
