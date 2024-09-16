package ua.example.model;

import java.math.BigDecimal;

public class ProjectPrices {
    private Long id;
    private BigDecimal price;

    public ProjectPrices(Long id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
               "id=" + id +
               ", price=" + price +
               '}';
    }
}
