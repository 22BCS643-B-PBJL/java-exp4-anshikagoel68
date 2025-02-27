import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeModification {
    private ArrayList<Employee> employees;

    public EmployeeModification() {
        employees = new ArrayList<>();
    }

    public void addEmployee(int id, String name, double salary) {
        Employee employee = new Employee(id, name, salary);
        employees.add(employee);
        System.out.println("Employee added: " + employee);
    }

    public void updateEmployee(int id, String name, double salary) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(name);
                employee.setSalary(salary);
                System.out.println("Employee updated: " + employee);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void removeEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                System.out.println("Employee removed: " + employee);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void searchEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("Employee found: " + employee);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public static void main(String[] args) {
        EmployeeModification emp = new EmployeeModification();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 6) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. List Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int add_id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Employee Name: ");
                    String add_name = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double add_salary = scanner.nextDouble();
                    emp.addEmployee(add_id, add_name, add_salary);
                    break;

                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int update_id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Employee Name: ");
                    String update_name = scanner.nextLine();
                    System.out.print("Enter new Employee Salary: ");
                    double update_salary = scanner.nextDouble();
                    emp.updateEmployee(update_id, update_name, update_salary);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int remove_id = scanner.nextInt();
                    emp.removeEmployee(remove_id);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to search: ");
                    int search_id = scanner.nextInt();
                    emp.searchEmployee(search_id);
                    break;

                case 5:
                    emp.listEmployees();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
