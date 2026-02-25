package FactorySingleton;

public class FactoryDataExport {

    public static DataExport getExporter(String className) {

        try {
            return (DataExport) Class.forName(className)
                    .getMethod("getInstance")
                    .invoke(null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
