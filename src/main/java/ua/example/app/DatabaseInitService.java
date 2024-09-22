package ua.example.app;

import ua.example.config.Database;

import java.sql.*;

import static ua.example.util.Utils.executeSqlScript;
import static ua.example.util.Utils.loadSqlScript;

public class DatabaseInitService {
    public static void main(String[] args) {
        Database.getInstance();
        try (Connection conn = Database.getConnection()) {
            initializeDatabase(conn);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void initializeDatabase(Connection conn) throws SQLException {
        deleteDatabaseStructure(conn);
        String sqlScript = loadSqlScript("/sql/init_db.sql");
        if (sqlScript != null) {
            executeSqlScript(conn, sqlScript);
        }
    }

    private static void deleteDatabaseStructure(Connection conn) throws SQLException {
        final String SCRIPT = "DROP TABLE IF EXISTS ? CASCADE";
        DatabaseMetaData metaData = conn.getMetaData();
        String catalog = conn.getCatalog();
        String schemaPattern = conn.getSchema();
        String tableNamePattern = "%";
        String[] types = {"TABLE"};

        ResultSet resultSet = metaData.getTables(catalog, schemaPattern, tableNamePattern, types);

        while (resultSet.next()) {
            String tableName = resultSet.getString("TABLE_NAME");

            try (PreparedStatement stmt = conn.prepareStatement(SCRIPT)) {
                stmt.setString(1, tableName);
                stmt.executeUpdate();
            }
        }
    }

}
