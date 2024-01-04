package org.example;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {public static final Database INSTANCE = new Database();
    private Connection connection;
    public Database(){
        try {
            String connectionUrl = "jdbc:h2:./test";
            connection = DriverManager.getConnection(connectionUrl);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Database getInstance(){
        return INSTANCE;
    }
    public Connection getConnection(){
        return connection;
    }
    public int executeUpdate(String sql){
        try (Statement st = connection.createStatement()){
            return st.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}
