package app2.dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import app2.db.Database;
import app2.dto.Todo;

public class TodoDao {

    public static boolean inserisciTask(String task){
        String sql = "insert into TodoList (task) values (?)";

        try{
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, task);
            return ps.executeUpdate() == 1;
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    public static boolean rimuoviRisorsa(int id){
        String sql = "delete from TodoList where id = ?";

        try{
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<Todo> findAll(){
        String sql = "select * from todoList";

        List<Todo> todos = new LinkedList<>();

        try{
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                todos.add(new Todo(rs.getInt("id"), rs.getString("task"), rs.getBoolean("done")));
            }
            return todos;

        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
