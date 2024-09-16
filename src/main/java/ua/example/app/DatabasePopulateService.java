package ua.example.app;

import ua.example.config.Database;

import java.sql.Connection;
import java.sql.SQLException;

import static ua.example.util.Utils.executeSqlScript;
import static ua.example.util.Utils.loadSqlScript;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database.getInstance();
        try (Connection conn = Database.getConnection()) {
            populateDatabase(conn);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void populateDatabase(Connection conn) throws SQLException {
        String loadScript = loadSqlScript("/sql/populate_db.sql");
        if(loadScript != null){
            executeSqlScript(conn, loadScript);
        }
    }
}
