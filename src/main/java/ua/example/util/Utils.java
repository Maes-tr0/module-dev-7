package ua.example.util;

import lombok.experimental.UtilityClass;
import ua.example.app.DatabaseInitService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@UtilityClass
public class Utils {
    public static void executeSqlScript(Connection conn, String sqlScript) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            String[] sqlStatements = sqlScript.split(";");
            for (String sql : sqlStatements) {
                sql = sql.trim();
                if (!sql.isEmpty()) {
                    stmt.addBatch(sql);
                }
            }
            stmt.executeBatch();
        }
    }
    public static String loadSqlScript(String resourcePath) {
        StringBuilder result = new StringBuilder();

        try (InputStream inputStream = DatabaseInitService.class.getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                System.err.println("Ресурс не знайдено: " + resourcePath);
                return null;
            }
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line).append("\n");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return result.toString();
    }
}
