package lab4;
import java.util.*;
//this will be the parent class that the rest of the c
public abstract class IDtkenRecord  implements recordInterfaces{
    //to check for same ids
    public static boolean isIDtaken(String key, List<recordInterfaces>list){
               for(recordInterfaces s:list){
                   if(s.getSearchKey().equalsIgnoreCase(key)){
                       return true;}

                   }
               return false;
               }
@Override
    public abstract String lineRepresentation();
    @Override
    public abstract String getSearchKey();
    }


