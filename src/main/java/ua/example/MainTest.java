package ua.example;

import ua.example.service.DatabaseQueryService;

public class MainTest {
    public static void main(String[] args) {
        DatabaseQueryService service = new DatabaseQueryService();

        // Тест для findMaxSalaryWorker
        System.out.println("Max Salary Workers:");
        service.findMaxSalaryWorker().forEach(System.out::println);

        // Тест для findMaxProjectsClient
        System.out.println("\nMax Projects Clients:");
        service.findMaxProjectsClient().forEach(System.out::println);

        // Тест для findLongestProject
        System.out.println("\nLongest Projects:");
        service.findLongestProject().forEach(System.out::println);

        // Тест для findYoungestEldestWorkers
        System.out.println("\nYoungest and Eldest Workers:");
        service.findYoungestEldestWorkers().forEach(System.out::println);

        // Тест для getProjectPrices
        System.out.println("\nProject Prices:");
        service.getProjectPrices().forEach(System.out::println);
    }
}
