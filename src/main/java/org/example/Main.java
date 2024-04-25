package org.example;

import org.flywaydb.core.Flyway;

import java.sql.SQLException;

public class Main {
    
    public static void main(String[] args) throws SQLException {
        
        try {
            Flyway flyway = Flyway.configure()
                    .dataSource("jdbc:h2:./test", "", null)
                    .baselineOnMigrate(true)
                    .locations("classpath:db.migration")
                    .load();
            flyway.migrate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        ClientService clientService = new ClientService();
        clientService.create("masha");
        clientService.getById(15);
        clientService.setName(1, "Sasha");
        clientService.deleteById(6);
        clientService.listAll();
    }
}
