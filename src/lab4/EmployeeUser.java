package lab4;
import java.util.*;
public class EmployeeUser {
    private String employeeId;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;


    //constructor
    public EmployeeUser(String employeeId, String name, String email, String address, String phoneNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    //getters
    public String getEmployeeId() {

        return employeeId;
    }

    public String getName() {
        return employeeId;
    }

    public String getEmail() {
        return employeeId;
    }

    public String getAddress() {
        return employeeId;
    }

    public String getPhoneNumber() {
        return employeeId;
    }

    //setters
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //methods
    public static   boolean isIDTaken(String key,List<EmployeeUser> emp){
        for (EmployeeUser e:emp){
            if (e.getEmployeeId().equalsIgnoreCase(key)){
                return true;
            }
        }
        return false;

        


    }
    public String lineRepresentation() {
        return String.join(",",employeeId,name,email,address,phoneNumber);
    }

    public String getSearchKey(List<EmployeeUser>employees) {
       if (EmployeeUser.isIDTaken(employeeId, employees)){
           System.out.println("Employee ID exists");
           return null;
       }
else{
        return employeeId;
    }


}}




