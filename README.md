#  Employee Management System

A simple, console-based **Employee Management System** built in Java. This application allows users to manage employee records entirely through a text menu  no database required. Data is stored in memory using an `ArrayList`.

---

## 📋 Features

| Feature | Description |
|---|---|
| ➕ **Add Employee** | Add a new employee with ID, name, email, department, designation, and joining date |
| 📋 **View Employees** | Display a list of all employees |
| 🔍 **Search by ID** | Find a specific employee using their unique employee ID |
| ✏️ **Update Employee** | Update one or more fields for an existing employee |
| 🗑️ **Delete Employee** | Remove an employee record by ID |
| ✅ **Input Validation** | Validates email format and ensures required fields are not empty |

---

## 🖥️ Application Screenshot

<img width="964" height="750" alt="Screenshot 2026-07-15 113028" src="https://github.com/user-attachments/assets/1555941b-3b7d-48b4-94a2-b274de105dc8" />


---

## 🗂️ Project Structure

```
assignment/
│
├── Employee.java          # Data model - holds employee fields (ID, name, email, etc.)
├── EmployeeService.java   # Business logic - add, view, search, update, delete
├── Program.java           # Entry point - console menu and user interaction
└── README.md              # Project documentation
```

---

## ⚙️ How It Works

### Architecture

The project follows a **separation of concerns** design:

- **`Employee.java`** — A plain Java class (POJO) representing a single employee. Contains private fields with getters/setters and a `toString()` method for display.
- **`EmployeeService.java`** — Contains all business logic. Manages an in-memory `ArrayList<Employee>` and exposes methods for each CRUD operation. Also handles validation (email format, required fields, duplicate IDs).
- **`Program.java`** — The entry point. Handles the console menu loop and delegates every action to `EmployeeService`. No business logic lives here.

---

## 🚀 How to Run

### Prerequisites
- Java JDK 8 or higher installed
- A terminal / command prompt

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/ps-prachi-prajapati/code-practices.git
cd code-practices/assignment
```

**2. Compile all Java files**
```bash
javac Employee.java EmployeeService.java Program.java
```

**3. Run the program**
```bash
java Program
```

---

## 🧭 Usage Walkthrough

Once the program starts, you'll see the main menu:

```
===== Employee Management System =====
1. Add Employee
2. View Employees
3. Search Employee by ID
4. Update Employee
5. Delete Employee
6. Exit
Enter your choice:
```

### ➕ Adding an Employee
Select option `1` and fill in the details:
```
--- Add Employee ---
Enter Employee ID: EMP001
Enter Name: Prachi Prajapati
Enter Email: prachi@example.com
Enter Department: Engineering
Enter Designation: Software Engineer
Enter Joining Date (e.g., 2024-01-15): 2026-07-15
Employee added successfully.
```

### 📋 Viewing All Employees
Select option `2`:
```
--- Employee List ---
----------------------------------
Employee ID   : EMP001
Name          : Prachi Prajapati
Email         : prachi@example.com
Department    : Engineering
Designation   : Software Engineer
Joining Date  : 2026-07-15
----------------------------------
```

### 🔍 Searching an Employee
Select option `3` and enter an Employee ID:
```
--- Search Employee ---
Enter Employee ID to search: EMP001
```

### ✏️ Updating an Employee
Select option `4`, enter the Employee ID, then provide new values (leave blank to keep current value):
```
--- Update Employee ---
Enter Employee ID to update: EMP001
Leave a field blank to keep its current value.
Enter new Name [Prachi Prajapati]:
Enter new Email [prachi@example.com]: prachi.new@example.com
...
Employee updated successfully.
```

### 🗑️ Deleting an Employee
Select option `5` and enter the Employee ID to remove:
```
--- Delete Employee ---
Enter Employee ID to delete: EMP001
Employee deleted successfully.
```

### 🚪 Exiting
Select option `6`:
```
Exiting Employee Management System. Goodbye!
```

---

## ✅ Input Validation Rules

- **Employee ID** — Cannot be empty; must be unique
- **Name** — Cannot be empty
- **Email** — Must match valid format (e.g., `name@example.com`)
- **Update** — Fields left blank are kept as-is; email is re-validated if changed

---

## 📌 Notes

- Employee data is **not persisted** — all records are lost when the program exits (in-memory only)
- Employee ID lookups are **case-insensitive**

---

