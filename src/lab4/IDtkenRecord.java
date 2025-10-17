package lab4;
import java.util.*;
/*this will be the parent class that the rest of the classes (that will need unique id) will inherit from it also has the implementation so u dont need to o implement too
  any other class that has search key and line representation use the interface class 3ad
     */
public abstract class IDtkenRecord  implements recordInterfaces{ /*this means list of any clas  that implements the parent class will work
    to check for same ids iwill use genric here for it to work with any type of object*/
    public static boolean isIDtaken(String key, List<?  extends recordInterfaces>list){

               for(recordInterfaces s:list){
                   if( s!=null && s.getSearchKey().equalsIgnoreCase(key)){
                       return true;}

                   }
               return false;
               }
@Override
    public abstract String lineRepresentation();
    @Override
    public abstract String getSearchKey();
    }


