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
        clientService.create("masha"); //Work if Prim Key Correct
        clientService.getById(15); //Work
        clientService.setName(1, "Sasha"); //WORK
        clientService.deleteById(6); //Work
        clientService.listAll();
    }
}
