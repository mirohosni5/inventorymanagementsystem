package lab4;
import java.util.*;
import java.io.*;

public class EmployeeUserDatabase {
    private ArrayList<EmployeeUser> records;
    private String filename;

    public EmployeeUserDatabase(String filename) {
        this.filename = filename;
        this.records = new ArrayList<>();

        public void readFromFile() {
            records.clear();   //clear el array 2bl kol mara han_read from file
            try (Scanner file = new Scanner(new File(filename))) {
                while (file.hasNextLine()) {
                    String line = file.nextLine();
                    if (!line.isEmpty()) {
                        EmployeeUser em = createRecordFrom(line);
                        records.add(em);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filename);
            }
        }

        public EmployeeUser createRecordFrom(String line) {
            String[] parts = line.split(",");
            String id = parts[0];
            String name = parts[1];
            String email = parts[2];
            String address = parts[3];
            String phone = parts[4];

            return new EmployeeUser(id, name, email, address, phone);
        }

    }

    }





   


    


