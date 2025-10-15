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
        String[] tokens=line.split("[,\\s]+" );
        EmployeeUser e=new EmployeeUser(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],tokens[8],tokens[9],tokens[10]);




    }
    public void readFromFile(){
        try{
            BufferedReader br=new BufferedReader(new FileReader(filename));
            String line;

        }
    }


    

}
