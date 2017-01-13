
package Model;
import Libary.AbtractModelManager;
import Libary.DataManager;
import java.sql.ResultSet;

public abstract class Model extends AbtractModelManager{
    public ResultSet Search(String data){
        return null;
    }
    
    public ResultSet Thongke(String data){
        return null;
    }
    
    public ResultSet getid(DataManager dataModel){
        return null;
    }
}
