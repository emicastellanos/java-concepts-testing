package concepts.map;

import java.util.*;

public class ComputeIfAbsentTest {


    private static List<Employee> createSomeEmployees() {
        Employee.Builder builder = new Employee.Builder(1);
        builder.withSalary(1000);
        builder.withTaxes(0.1);
        Employee e1 = builder.build();

        Employee.Builder builder2 = new Employee.Builder(2);
        builder2.withSalary(2000);
        builder2.withTaxes(0.15);
        Employee e2 = builder2.build();

        Employee.Builder builder3 = new Employee.Builder(3);
        builder3.withSalary(1500);
        builder3.withTaxes(0.4);
        Employee e3 = builder3.build();

        return Arrays.asList(e1, e2, e3);
    }

    public static void main(String[] args) {
        List<Employee> employeeList = createSomeEmployees();
        Map<Employee, Double> allSalariesMap = new HashMap<>();

        employeeList.stream()
                .forEach(employee -> allSalariesMap.computeIfAbsent(employee, Employee::obtainSalaryWithTaxes));

        allSalariesMap.forEach((k, v) -> System.out.printf("%s - %s € %n", k, v));

        //add another employee with same id
        Employee.Builder builder4 = new Employee.Builder(3);
        builder4.withSalary(5000);
        builder4.withTaxes(0.25);
        Employee e4 = builder4.build();

        System.out.printf("added one existing id %n");
        allSalariesMap.computeIfAbsent(e4,Employee::obtainSalaryWithTaxes);

        allSalariesMap.forEach((k, v) -> System.out.printf("%s - %s € %n", k, v));

    }
}
