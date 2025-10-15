package lab4;
import java.util.*;
import java.io.*;

public class EmployeeUserDatabase {
    private ArrayList<EmployeeUser> records;
    private String filename;
    //constructor
    public EmployeeUserDatabase(String filename){
        this.filename=filename;
       this.records=new ArrayList<>();
    }
    public EmployeeUser createRecordFrom(String line){
        String[] data=line.split("," );

      assert  data.length==5; //this make sure the data will stay as five


        String employeeid=data[0].trim();
        String name=data[1].trim();
        String email=data[2].trim();
        String address=data[3].trim();
        String phonenumber=data[4].trim();
return new EmployeeUser(employeeid,name,email,address,phonenumber);
        }


    public void readFromFile(){
        records.clear();
        BufferedReader b= null;
        //let's see if file exists first
        try{
             b=new BufferedReader(new FileReader(filename));

        }
        catch (FileNotFoundException e){
            System.out.println("cannot find file");
            return;
        }
//le t's read the file
        String line;
        try{
            while ((line=b.readLine())!=null){
                EmployeeUser emp=createRecordFrom(line);
                if (emp!=null){
                    records.add(emp);
                }
            }
        }
        catch (IOException e){
            System.out.println("Error reading file");

        }



    }
    public boolean contains(String key){
        return EmployeeUser.isIDTaken(key,records);
    }
    public EmployeeUser getRecord(String key){
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





   


    


