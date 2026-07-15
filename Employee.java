/**
 * Represents an Employee with basic details.
 * This class only holds data and provides access to it (getters/setters).
 */
public class Employee {

    private String employeeId;
    private String name;
    private String email;
    private String department;
    private String designation;
    private String joiningDate;

    public Employee(String employeeId, String name, String email,
                     String department, String designation, String joiningDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.joiningDate = joiningDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "Employee ID   : " + employeeId + "\n" +
               "Name          : " + name + "\n" +
               "Email         : " + email + "\n" +
               "Department    : " + department + "\n" +
               "Designation   : " + designation + "\n" +
               "Joining Date  : " + joiningDate;
    }
}
