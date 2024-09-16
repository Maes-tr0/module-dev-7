package ua.example.model;

import java.math.BigDecimal;

public class LongestProject {
    private Long id;
    private BigDecimal monthCount;

    public LongestProject(Long id, BigDecimal monthCount){
        this.id = id;
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker{" +
               "id='" + id + '\'' +
               ", monthCount=" + monthCount +
               '}';
    }
}
