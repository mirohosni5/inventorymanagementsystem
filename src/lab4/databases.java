package lab4;
import java.io.*;
import java.util.*;

public abstract class databases<T> {
    public ArrayList<T> records= new ArrayList<>();
    public String filename;
    public databases(String filename){
        this.filename=filename;
    }
    public abstract T createRecord(String line);
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

        //reading the file
    try{
        String line;
        while ((line=br.readLine())!=null){
            T record= createRecord(line);
            if (record!=null){
                records.add(record);

            }
        }
    }
    catch (IOException e){
        System.out.println("Error reading file");
    }
    try{
        if(br!=null){
            br.close();
        }
    }
    catch (IOException e){
        System.out.println("Error closing file");
    }
    //lets return the lists
        public ArrayList<T>


}




}
