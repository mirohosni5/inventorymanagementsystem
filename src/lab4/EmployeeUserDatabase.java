package lab4;
import java.util.*;
import java.io.*;

public class EmployeeUserDatabase extends databases{
    private ArrayList<EmployeeUser> records;
    private String filename;

    public EmployeeUserDatabase(String filename) {
        this.filename = filename;
        this.records = new ArrayList<>();



        public EmployeeUser createRecordFrom(String line) {
            String[] parts = line.split(",");
            String id = parts[0];
            String name = parts[1];
            String email = parts[2];
            String address = parts[3];
            String phone = parts[4];

            return new EmployeeUser(id, name, email, address, phone);
        }

    }

    }





   


    


