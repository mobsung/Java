package FactorySingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Statistiche {

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

}
