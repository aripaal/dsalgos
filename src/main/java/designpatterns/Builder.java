package designpatterns;

import lombok.*;

public class Builder {
    @AllArgsConstructor
    @Setter
    @ToString
    static class Employee {
        private String name;
        private String age;
        private String role;
        private int id;
    }

    @NoArgsConstructor
    static class BuilderHelper {
        private String name;
        private String age;
        private String role;
        private int id;

        BuilderHelper setName(String name) {
            this.name = name;
            return this;
        }

        BuilderHelper setAge(String age) {
            this.age = age;
            return this;
        }

        BuilderHelper setRole(String role) {
            this.role = role;
            return this;
        }

        BuilderHelper setId(int id) {
            this.id = id;
            return this;
        }

        Employee build() {
            return new Employee(name, age, role, id);
        }
    }

    public static void main(String... args) {
        BuilderHelper helper = new BuilderHelper();
        Employee e = helper.setAge("23").setName("John").setRole("Employee").setId(1).build();
        System.out.println(e);
    }
}
