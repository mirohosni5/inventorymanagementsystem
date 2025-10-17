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
        records.clear(); //to clear anything inside record first
        try{ br=new BufferedReader(new FileReader(filename));
            String line=br.readLine();
            while (line!=null){
                T record= createObject(line.split(","));
                records.add(record);
                line=br.readLine();
            }
            br.close();
        }
    }

}
