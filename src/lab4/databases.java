package lab4;
import java.io.*;
import java.util.*;

public abstract class databases<T extends IDtkenRecord> {
    public ArrayList<T> records= new ArrayList<>();
    public String filename;
    public databases(String filename){
        this.filename=filename;
    }
    public void saveToFile(){
        try(PrintWriter pw=new PrintWriter(new FileWriter(filename))){
            for(T record:records){
                pw.println(record.lineRepresentation());
            }
            
        }
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
    //did the try and catch in closing for safety
    try{
        if(br!=null){
            br.close();
        }
    }
    catch (IOException e){
        System.out.println("Error closing file");
    }


}
    public abstract T createRecord(String line);
//lets return the lists
    public ArrayList<T> returnAllRecords(){

        return records;
    }

    public boolean contains(String key){
        return IDtkenRecord.isIDtaken(key,records);
    }
    public T getRecord(String key){
        if(!contains(key)){

            return null;
        }
        for(T recd: records){
            if(recd.getSearchKey().equalsIgnoreCase(key)){
                return recd;
            }
        }  return null;
        }
        public void insertRecord(T record){
        if(record==null){
            return;

        }
        if(contains(record.getSearchKey())){
            System.out.println("id exists");
            return;
        }
        records.add(record);
        System.out.println("record added"+ record.getSearchKey());
        saveToFile();
        }
        public void deleteRecord(String key){
        T itemDeleted=getRecord(key);
        if(!contains(key)){
            System.out.println("id isnt there");
        }
        else{
            if(itemDeleted!=null){
            records.remove(itemDeleted);}
        }
        saveToFile();
        }

    }


