
package Libary;

import java.sql.ResultSet;


public interface InterfaceModelManager {
    public void setTable(String table);
    public void init();
    public ResultSet getData();
    public boolean insert(DataManager data);
    public boolean update(DataManager data);
    public boolean delete(DataManager data);
    public ResultSet Search(String data);
    public void viewMesenger(boolean is);
    public void viewMesenger(boolean is,String msg);
}
