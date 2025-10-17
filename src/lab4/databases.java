package lab4;
import java.io.*;
import java.util.*;

public abstract class databases<T> {
    public ArrayList<T> records= new ArrayList<>();
    public String filename;
    public databases(String filename){
        this.filename=filename;
    }
    public void readFromFile(){
        records.clear();//to clear anything inside record first
        BufferedReader br=null;
        // we are trying to find the file first
        try{ br=new BufferedReader(new FileReader(filename));

    }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            return; //stop if file not found
        }
        }
        //


}
