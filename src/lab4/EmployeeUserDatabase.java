package lab4;

   public class EmployeeUserDatabase extends databases{
    public EmployeeUserDatabase(String filename) {
        super(filename);
    }

    @Override
    public recordInterfaces createRecord(String line) {
        String[] parts = line.split(",");
        if (parts.length < 5) return null;

        String id = parts[0];
        String name = parts[1];
        String email = parts[2];
        String address = parts[3];
        String phone = parts[4];

        return new EmployeeUser(id, name, email, address, phone);
    }

    }





   


    


