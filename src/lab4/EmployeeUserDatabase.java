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
        String[] data=line.split("[,\\s]+" );
        if (data.length!=5){
            System.out.println("Invalid data format");
            return null;
        }
        String employeeid=data[0].trim();
        String name=data[1].trim();
        String email=data[2].trim();
        String address=data[3].trim();
        String phonenumber=data[4].trim();

        }






    }
    public void readFromFile(){
        try{
            BufferedReader br=new BufferedReader(new FileReader(filename));
            String line;

        }
    }


    

}
