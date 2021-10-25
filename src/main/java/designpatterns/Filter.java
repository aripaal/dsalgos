package designpatterns;

import lombok.*;

import java.util.*;
import java.util.stream.*;

public class Filter {
    public static void main(String... args) {
        List<Employee> employees = Arrays.asList(new Employee(22, "Swetha", Sex.F),
                new Employee(27, "Ravi", Sex.M),
                new Employee(27, "Hemanth", Sex.M),
                new Employee(32, "Jovi", Sex.M),
                new Employee(25, "Heena", Sex.F),
                new Employee(21, "Kranti", Sex.F),
                new Employee(20, "Aman", Sex.M));

        Females f = new Females();
        List<Employee> employeeList = f.criteria(employees);
        System.out.println(employeeList);
    }
}

@AllArgsConstructor
@ToString
class Employee {
    int age;
    String name;
    Sex sex;
}

enum Sex {M, F};

interface Criteria {
    List<Employee> criteria(List<Employee> employees);
}

class Females implements Criteria {
    @Override
    public List<Employee> criteria(List<Employee> employees) {
        return employees
                .stream()
                .filter(e -> e.sex == Sex.F)
                .collect(Collectors.toList());
    }
}