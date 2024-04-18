import employee.Employee;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
//        Employee employee = new Employee()
//                .setFirstName("Mohammad")
//                .setLastName("Amin Jarayya Salihović Amin Jarayya Salihović Salihović Salihović Amin Jarayya Salihović Amin Jarayya Salihović Salihović Salihović Amin Jarayya Salihović Amin Jarayya Salihović Salihović Salihović Amin Jarayya Salihović Amin Jarayya Salihović Salihović Salihović")
//                .setCreatedAt(LocalDateTime.now())
//                .setEmployed(true)
//                .save();
//        System.out.printf("ID: " + employee.getId());

//        Employee employee = Employee.getById(1L);
//        System.out.println("Mile prije brisanja: " + employee);
//        if (employee != null) employee.delete();
//        System.out.println("Mile poslije brisanja: " + employee);

//        List<Employee> employees = Employee.loadAll();
//        employees.forEach(Employee::sendMeToEmploymentChamber);
//        System.out.println("Nezaposlenost velika");
//        employees.forEach(System.out::println);
//        employees.forEach(Employee::employMe);
//        System.out.println("Uposlenost velika");
//        employees.forEach(System.out::println);

//        Employee employee = Employee.getById(11L);
//        Employee employee2 = Employee.getById(9L);
//        Employee.sendEmployeesToEmploymentChamber(employee, employee2);
        for (Employee employee : Employee.loadAll()) {
            System.out.println(employee);
        }
    }

//    private static void employEmployee(Employee employee){
//        employee.setEmployed(true).update();
//    }
}
