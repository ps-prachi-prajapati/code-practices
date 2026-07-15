import java.util.ArrayList;
import java.util.Scanner;

/**
 * Entry point of the Employee Management System.
 * Handles the console menu and user interaction only.
 * All business logic is delegated to EmployeeService.
 */
public class Program {

    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            displayMenu();
            int choice = readMenuChoice();

            switch (choice) {
                case 1:
                    handleAddEmployee();
                    break;
                case 2:
                    handleViewEmployees();
                    break;
                case 3:
                    handleSearchEmployee();
                    break;
                case 4:
                    handleUpdateEmployee();
                    break;
                case 5:
                    handleDeleteEmployee();
                    break;
                case 6:
                    isRunning = false;
                    System.out.println("Exiting Employee Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n===== Employee Management System =====");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Search Employee by ID");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Reads the menu choice and handles non-numeric input gracefully.
     */
    private static int readMenuChoice() {
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void handleAddEmployee() {
        System.out.println("\n--- Add Employee ---");

        System.out.print("Enter Employee ID: ");
        String employeeId = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();

        System.out.print("Enter Joining Date (e.g., 2024-01-15): ");
        String joiningDate = scanner.nextLine();

        Employee employee = new Employee(employeeId, name, email, department, designation, joiningDate);
        String result = employeeService.addEmployee(employee);
        System.out.println(result);
    }

    private static void handleViewEmployees() {
        System.out.println("\n--- Employee List ---");
        ArrayList<Employee> employees = employeeService.viewEmployees();

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println("----------------------------------");
            System.out.println(employee);
        }
        System.out.println("----------------------------------");
    }

    private static void handleSearchEmployee() {
        System.out.println("\n--- Search Employee ---");
        System.out.print("Enter Employee ID to search: ");
        String employeeId = scanner.nextLine();

        Employee employee = employeeService.searchEmployeeById(employeeId);
        if (employee == null) {
            System.out.println("Employee with ID '" + employeeId + "' not found.");
        } else {
            System.out.println("----------------------------------");
            System.out.println(employee);
            System.out.println("----------------------------------");
        }
    }

    private static void handleUpdateEmployee() {
        System.out.println("\n--- Update Employee ---");
        System.out.print("Enter Employee ID to update: ");
        String employeeId = scanner.nextLine();

        Employee existingEmployee = employeeService.searchEmployeeById(employeeId);
        if (existingEmployee == null) {
            System.out.println("Employee with ID '" + employeeId + "' not found.");
            return;
        }

        System.out.println("Leave a field blank to keep its current value.");

        System.out.print("Enter new Name [" + existingEmployee.getName() + "]: ");
        String name = scanner.nextLine();

        System.out.print("Enter new Email [" + existingEmployee.getEmail() + "]: ");
        String email = scanner.nextLine();

        System.out.print("Enter new Department [" + existingEmployee.getDepartment() + "]: ");
        String department = scanner.nextLine();

        System.out.print("Enter new Designation [" + existingEmployee.getDesignation() + "]: ");
        String designation = scanner.nextLine();

        System.out.print("Enter new Joining Date [" + existingEmployee.getJoiningDate() + "]: ");
        String joiningDate = scanner.nextLine();

        String result = employeeService.updateEmployee(employeeId, name, email, department, designation, joiningDate);
        System.out.println(result);
    }

    private static void handleDeleteEmployee() {
        System.out.println("\n--- Delete Employee ---");
        System.out.print("Enter Employee ID to delete: ");
        String employeeId = scanner.nextLine();

        String result = employeeService.deleteEmployee(employeeId);
        System.out.println(result);
    }
}
