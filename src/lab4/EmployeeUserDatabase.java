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
        String id=data[0].trim();
        String email=tokens[1];
        String employeeId=tokens[2];

        }






    }
    public void readFromFile(){
        try{
            BufferedReader br=new BufferedReader(new FileReader(filename));
            String line;

        }
    }


    

}
