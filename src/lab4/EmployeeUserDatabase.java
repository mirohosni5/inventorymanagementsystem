package lab4;
import java.util.*;
import java.io.*;

public class EmployeeUserDatabase {
    private ArrayList<EmployeeUser> records;
    private  String filename;
    //constructor
    public EmployeeUserDatabase(String filename){
        this.filename=filename;
       this.records=new ArrayList<>();
    }


     contains(String key){
        return EmployeeUser.isIDTaken(key,records);
    }
    public EmployeeUser getRecord(String key){//searching for the record using the contain method we made
         if (contains(key)){
             for (EmployeeUser emp:records){
                 if (emp.getEmployeeId().equalsIgnoreCase(key)){
                     return emp;
                 }
             }
         }
         else{
             System.out.println("id doesnt exist");
             return null;
         }

        return null;
    }

    }





   


    


