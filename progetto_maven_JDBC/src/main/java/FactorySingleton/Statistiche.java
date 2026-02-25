package FactorySingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Statistiche {

    private DataExport exporter;

    public void setExporter(DataExport exporter){
        this.exporter = exporter;
    }

    public List<String> getExportType(){
        String query = "select exptype from exporttype";

        List<String> exportTypes = new ArrayList<>();

        try{
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                exportTypes.add(rs.getString("exptype"));
            }
            return exportTypes;
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void exportCategory(){
        String query = "select idCategory, description from category";
        List<String> categories = new ArrayList<>();
        try{
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                categories.add(rs.getInt("idCategory") + ":" + rs.getString("description"));
            }
            exporter.export(categories, "categories");
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void exportCity(){
        String query = "select cityName, region from city";
        List<String> categories = new ArrayList<>();
        try{
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                categories.add(rs.getString("cityName") + ":" + rs.getString("region"));
            }
            exporter.export(categories, "cities");
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
