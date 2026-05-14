import java.math.BigDecimal;
import java.util.Objects;

public static class Employee {

    private String name;
    private int id;
    private BigDecimal salary;

    public Employee(String name, int id, BigDecimal salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return getId() == employee.getId() && Objects.equals(getName(), employee.getName()) && Objects.equals(getSalary(), employee.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}

public static void main(String[] args){
    Employee employee = new Employee("Sherry", 25, new BigDecimal("85000.00"));
    System.out.println(employee);
}

