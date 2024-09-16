package ua.example.service;

import ua.example.config.Database;
import ua.example.model.MaxSalaryWorker;
import ua.example.model.MaxProjectCountClient;
import ua.example.model.LongestProject;
import ua.example.model.YoungestEldestWorker;
import ua.example.model.ProjectPrices;
import ua.example.util.ResultSetMapper;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static ua.example.util.Utils.loadSqlScript;

public class DatabaseQueryService {

    public <T> List<T> executeQuery(String sqlFilePath, ResultSetMapper<T> mapper) {
        List<T> result = new ArrayList<>();
        String sqlScript = loadSqlScript(sqlFilePath);
        if (sqlScript == null || sqlScript.isEmpty()) {
            return result;
        }
        try (Statement statement = Database.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sqlScript)) {

            while (resultSet.next()) {
                T item = mapper.map(resultSet);
                result.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        return executeQuery("/sql/find_max_salary_worker.sql", resultSet -> {
            String name = resultSet.getObject("name", String.class);
            int salary = resultSet.getObject("salary", Integer.class);
            return new MaxSalaryWorker(name, salary);
        });
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        return executeQuery("/sql/find_max_projects_client.sql", resultSet -> {
            String name = resultSet.getObject("name", String.class);
            Long projectCount = resultSet.getObject("project_count", Long.class);
            return new MaxProjectCountClient(name, projectCount);
        });
    }

    public List<LongestProject> findLongestProject() {
        return executeQuery("/sql/find_longest_project.sql", resultSet -> {
            Long name = resultSet.getObject("name", Long.class);
            BigDecimal monthCountDecimal = resultSet.getObject("month_count", BigDecimal.class);
            return new LongestProject(name, monthCountDecimal);
        });
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() {
        return executeQuery("/sql/find_youngest_eldest_workers.sql", resultSet -> {
            String type = resultSet.getString("type");
            String name = resultSet.getString("name");
            LocalDate birthday = resultSet.getDate("birthday").toLocalDate();
            return new YoungestEldestWorker(type, name, birthday);
        });
    }

    public List<ProjectPrices> getProjectPrices() {
        return executeQuery("/sql/print_project_prices.sql", resultSet -> {
            Long name = resultSet.getObject("name", Long.class);
            BigDecimal priceDecimal = resultSet.getObject("price", BigDecimal.class);
            return new ProjectPrices(name, priceDecimal);
        });
    }
}
