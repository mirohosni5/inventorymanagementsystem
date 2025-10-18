package lab4;
import java.util.*;
/*this will be the parent class that the rest of the classes (that will need unique id) will inherit from it also has the implementation so u dont need to o implement too
  just inherit this class and it will do the interface too in the child classes
     */
public abstract class IDtkenRecord  implements recordInterfaces{ /*this means list of any clas  that implements the parent class will work
    to check for same ids*/
    public static boolean isIDtaken(String key, List<Object>list){ //iwill use genric here for it to work with any type of object

               for(Object s:list){
                   recordInterfaces 
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


