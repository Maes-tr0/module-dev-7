package ua.example.model;

public class MaxProjectCountClient {
    private String name;
    private Long projectCount;

    public MaxProjectCountClient(String name, Long projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "MaxProjectCountClient{" +
               "name='" + name + '\'' +
               ", projectCount=" + projectCount +
               '}';
    }
}
