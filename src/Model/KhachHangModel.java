
package Model;

import Libary.DataManager;
import static Model.Database.connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class KhachHangModel extends Model{

    @Override
    public void init() {
        setTable("khachhang");
    }

     @Override
    public ResultSet getData(){
        ResultSet data = null;
        data = getQuery("select * from "+table);
        return data;
    }
    
    

    @Override
    public boolean insert(DataManager data) {
       String query = "Insert into `"+table+"` values(?,?,?,?)";
        try {
            PreparedStatement prsm = connect.prepareStatement(query);
            prsm.setString(1, data.id.toString());
            prsm.setString(2, data.data[0].toString());
            prsm.setString(3, data.data[1].toString());
            prsm.setString(4, data.data[2].toString());
            return prsm.executeUpdate() != 0;
        } catch (SQLException ex) {
            System.out.println("loi: " + ex);
        }

        return false;
    }

    @Override
    public boolean update(DataManager data) {
        String query = "update  `"+table+"` set tenKhach = ? , diaChi = ?, soDienThoai=? where maKhach= ?";
        try {
            PreparedStatement prsm = connect.prepareStatement(query);
            prsm.setString(1, data.data[0].toString());
            prsm.setString(2, data.data[1].toString());
            prsm.setString(3, data.data[2].toString());
            prsm.setString(4,data.id.toString());
            return prsm.executeUpdate() != 0;
        } catch (SQLException ex) {
            System.out.println("loi: " + ex);
        }

        return false;
    }

    @Override
    public boolean delete(DataManager data) {
         String query = "delete from `"+table+"` where maKhach  = ?";
        try {
            PreparedStatement prsm = connect.prepareStatement(query);
            prsm.setString(1, (String) data.id);
            return prsm.executeUpdate() != 0;
        } catch (SQLException ex) {
            System.out.println("loi: " + ex);
        }

        return false;
    
    }
    
    @Override
    public ResultSet Search(String data)
    {
        ResultSet rows = null;
        String query = "Select * From `"+table+"` Where `Makhach` LIKE '%"+data+"%' OR `TenKhach` LIKE '%"+data+"%'";
        rows = getQuery(query);
        return rows;
    }


}
