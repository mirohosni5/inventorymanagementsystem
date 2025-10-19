package lab4;

import java.io.*;
import java.util.*;

/* i used casting here instead of generics i also removed the parent idtaken
 since it was just helper parent class when i used generics*/
public abstract class databases {

    public ArrayList<Object> records = new ArrayList<>();
    public String filename;

    public databases(String filename){
        this.filename = filename;
    }


    public abstract recordInterfaces createRecord(String line);


    public void saveToFile(){
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Object obj : records) {
                recordInterfaces rec = (recordInterfaces) obj;
                pw.println(rec.lineRepresentation());
            }
            System.out.println(filename + " is saved");
        } catch (IOException e) {
            System.out.println(filename + " couldn't save");
        }
    }


    public void readFromFile(){
        records.clear();
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(filename));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }

        try {
            String line;
            while ((line = br.readLine()) != null) {
                recordInterfaces rec = createRecord(line);
                if (rec != null) records.add(rec);
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file");
        }

        try {
            br.close();
        }
        catch (IOException e) {
            System.out.println("Error closing file");
        }
    }


    public ArrayList<Object> returnAllRecords(){
        return records;
    }

    // here i am checking if the id is the same
    public boolean contains(String key){
        for (Object recd : records) {
            recordInterfaces rec = (recordInterfaces) recd;
            if (rec.getSearchKey().equalsIgnoreCase(key)) {
                return true;
            }
        }
        return false;
    }

    public recordInterfaces getRecord(String key){ //i used casting here to return any type of objects
        for (Object recd : records) {
            recordInterfaces rec = (recordInterfaces) recd;
            if (rec.getSearchKey().equalsIgnoreCase(key)) {
                return rec;
            }
        }
        return null;
    }

    public void insertRecord(recordInterfaces record){
        if (record == null) return;

        if (contains(record.getSearchKey())) {
            System.out.println("id exists");
            return;
        }
        records.add(record);
        System.out.println("record added " + " "+record.getSearchKey());

    }

    public void deleteRecord(String key){
        recordInterfaces target = getRecord(key);
        if (target == null) {
            System.out.println("id isn't there");
            return;
        }
        records.remove(target);
        System.out.println("record deleted " + key);

    }
}
