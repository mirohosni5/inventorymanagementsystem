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
        String[] tokens=line.split("[]" );

    }
    public void readFromFile(){
        try{
            BufferedReader br=new BufferedReader(new FileReader(filename));
            String line;

        }
    }


    

}
