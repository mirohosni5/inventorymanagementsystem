package lab4;

import java.util.ArrayList;

public class AdminRole implements roleinterface
{
     private EmployeeUserDatabase database;
    public AdminRole(){
        database = new EmployeeUserDatabase("Employees.txt");
        database.readFromFile();
    }
    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) {
        if (!database.contains(employeeId)) {
            EmployeeUser e= new EmployeeUser(employeeId, name, email, address, phoneNumber);
            database.insertRecord(e);
            System.out.println("Employee added successfully!");
        } else {
            System.out.println("Employee ID already exists!");
        }
    }

    public EmployeeUser[] getListOfEmployees() {
        ArrayList<Object> list=database.returnALLRecords()
        ArrayList<EmployeeUser> list = database.returnAllRecords();
        return list.toArray(new EmployeeUser[0]);
    }

    public void removeEmployee(String key) {
        if (database.contains(key)) {
            database.deleteRecord(key);
            System.out.println("Employee removed successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }
@Override
    public void logout() {
        database.saveToFile();
        System.out.println("Changes saved");
}
}

