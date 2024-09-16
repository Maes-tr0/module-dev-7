package ua.example.model;

import java.time.LocalDate;
import java.util.Date;

public class YoungestEldestWorker {
    private String type;
    private String name;
    private LocalDate date;

    public YoungestEldestWorker(String type, String name, LocalDate date) {
        this.type = type;
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "YoungestEldestWorker{" +
               "type=" + type +
               ", name='" + name + '\'' +
               ", date=" + date +
               '}';
    }
}

