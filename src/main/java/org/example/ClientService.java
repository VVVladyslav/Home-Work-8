package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    public long create(String name){
        long genId = -1;
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlQuery = "INSERT INTO PUBLIC.CLIENT (NAME) VALUES (?);";
            PreparedStatement queryStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            queryStatement.setString(1, name);
            int rowLong = queryStatement.executeUpdate();
            if (rowLong > 0) {
                ResultSet resultSet = queryStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    genId = resultSet.getLong(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genId;
        }//додає нового клієнта з іменем name. Повертає ідентифікатор щойно створеного клієнта.
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public String getById(long id){
        String clientName = "";
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlQuery = "SELECT name FROM PUBLIC.CLIENT WHERE ID = (?);";
            PreparedStatement queryStatement = connection.prepareStatement(sqlQuery);
            queryStatement.setLong(1, id);
            ResultSet resultSet = queryStatement.executeQuery();

            while (resultSet.next()) {
                clientName = resultSet.getString("name");
            }
            queryStatement.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return clientName;
    }//повертає назву клієнта з ідентифікатором id
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void setName(long id, String name){
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlQuery = "UPDATE PUBLIC.CLIENT SET NAME = ? WHERE ID = ?";
            PreparedStatement queryStatement = connection.prepareStatement(sqlQuery);
            queryStatement.setString(1, name);
            queryStatement.setLong(2, id);
            queryStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }// встановлює нове ім'я name для клієнта з ідентифікатором id
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void deleteById(long id){
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlQuery = "DELETE FROM PUBLIC.CLIENT WHERE ID = (?)";
            PreparedStatement queryStatement = connection.prepareStatement(sqlQuery);
            queryStatement.setLong(1, id);
            queryStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }//видаляє клієнта з ідентифікатором id

    public List<Client> listAll(){
        List<Client> result = new ArrayList<>();
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlQuery = "SELECT * FROM PUBLIC.CLIENT";
            PreparedStatement queryStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = queryStatement.executeQuery();

            while (resultSet.next()) {
                Client client = new Client();
                client.setName(resultSet.getString("name"));
                client.setId(resultSet.getInt("id"));
                result.add(client);
            }
            queryStatement.executeQuery();

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    } //- повертає всіх клієнтів з БД у вигляді колекції об'єктів типу Client (цей клас створи сам, у ньому має бути 2 поля - id та name)
}
