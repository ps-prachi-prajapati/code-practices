import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Contains all the business logic for managing employees.
 * Employee data is stored in memory using an ArrayList.
 */
public class EmployeeService {

    private ArrayList<Employee> employeeList;

    // Basic pattern to validate a typical email format (e.g., name@example.com)
    private static final String EMAIL_REGEX = "^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$";

    public EmployeeService() {
        employeeList = new ArrayList<>();
    }

    /**
     * Adds a new employee after validating the input fields.
     * Returns a message describing the result.
     */
    public String addEmployee(Employee employee) {
        String validationError = validateEmployee(employee);
        if (validationError != null) {
            return validationError;
        }

        if (findEmployeeById(employee.getEmployeeId()) != null) {
            return "Error: An employee with ID '" + employee.getEmployeeId() + "' already exists.";
        }

        employeeList.add(employee);
        return "Employee added successfully.";
    }

    /**
     * Returns the list of all employees.
     */
    public ArrayList<Employee> viewEmployees() {
        return employeeList;
    }

    /**
     * Searches for an employee by ID and returns the matching employee, or null if not found.
     */
    public Employee searchEmployeeById(String employeeId) {
        return findEmployeeById(employeeId);
    }

    /**
     * Updates the details of an existing employee identified by employeeId.
     * Only fields with non-empty new values are updated.
     * Returns a message describing the result.
     */
    public String updateEmployee(String employeeId, String newName, String newEmail,
                                  String newDepartment, String newDesignation, String newJoiningDate) {
        Employee employee = findEmployeeById(employeeId);
        if (employee == null) {
            return "Error: Employee with ID '" + employeeId + "' not found.";
        }

        if (newName != null && !newName.trim().isEmpty()) {
            employee.setName(newName);
        }

        if (newEmail != null && !newEmail.trim().isEmpty()) {
            if (!isValidEmail(newEmail)) {
                return "Error: Invalid email format. Update cancelled.";
            }
            employee.setEmail(newEmail);
        }

        if (newDepartment != null && !newDepartment.trim().isEmpty()) {
            employee.setDepartment(newDepartment);
        }

        if (newDesignation != null && !newDesignation.trim().isEmpty()) {
            employee.setDesignation(newDesignation);
        }

        if (newJoiningDate != null && !newJoiningDate.trim().isEmpty()) {
            employee.setJoiningDate(newJoiningDate);
        }

        return "Employee updated successfully.";
    }

    /**
     * Deletes an employee by ID.
     * Returns a message describing the result.
     */
    public String deleteEmployee(String employeeId) {
        Employee employee = findEmployeeById(employeeId);
        if (employee == null) {
            return "Error: Employee with ID '" + employeeId + "' not found.";
        }

        employeeList.remove(employee);
        return "Employee deleted successfully.";
    }

    /**
     * Helper method to find an employee by ID within the list.
     */
    private Employee findEmployeeById(String employeeId) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId().equalsIgnoreCase(employeeId)) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Validates the required fields of an employee before adding.
     * Returns an error message if validation fails, or null if the data is valid.
     */
    private String validateEmployee(Employee employee) {
        if (employee.getEmployeeId() == null || employee.getEmployeeId().trim().isEmpty()) {
            return "Error: Employee ID cannot be empty.";
        }

        if (employee.getName() == null || employee.getName().trim().isEmpty()) {
            return "Error: Employee Name cannot be empty.";
        }

        if (!isValidEmail(employee.getEmail())) {
            return "Error: Invalid email format.";
        }

        return null;
    }

    /**
     * Checks whether the given email matches a valid email format.
     */
    private boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return Pattern.matches(EMAIL_REGEX, email);
    }
}
