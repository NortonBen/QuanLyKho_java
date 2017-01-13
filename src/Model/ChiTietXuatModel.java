
package Model;

import Libary.DataManager;
import static Model.Database.connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ChiTietXuatModel extends Model {
    

    @Override
    public void init() {
        setTable("chitietxuat");
    }

    @Override
    public ResultSet getData() {
        ResultSet data = null;
        data = getQuery("select * from "+table);
        return data;
    }
    
    @Override
    public ResultSet getid(DataManager dataModel) {
        ResultSet data = null;
        String str = "select * from "+table+" where SoPhieuXuat = '"+dataModel.id.toString()+"'";
        data = getQuery(str);
        return data;
    }

    @Override
    public boolean insert(DataManager data) {
         String query = "INSERT INTO `chitietxuat`(`SoPhieuXuat`, 'MaHang', `SoLuongXuat`, `DonGia`) values(?,?,?,?)";
        try {
            PreparedStatement prsm = connect.prepareStatement(query);
            prsm.setString(1,data.data[0] .toString());
            prsm.setString(2, data.data[1].toString());
            prsm.setInt(3, (int)data.data[2]);
            prsm.setInt(4,(int)data.data[3]);
            return prsm.executeUpdate() != 0;
        } catch (SQLException ex) {
            System.out.println("loi: " + ex);
        }

        return false;
    }

    @Override
    public boolean update(DataManager data) {
         String query = "update  `"+table+"` set soLuongXuat= ? , donGia = ?  where soPhieuXuat=? and maHang= ?";
        try {
            PreparedStatement prsm = connect.prepareStatement(query);
            prsm.setInt(1, (int)data.data[2]);
            prsm.setInt(2,(int)data.data[3]);
              prsm.setString(3,data.data[0] .toString());
            prsm.setString(4, data.data[1].toString());
            return prsm.executeUpdate() != 0;
        } catch (SQLException ex) {
            System.out.println("loi: " + ex);
        }

        return false;
    }

    @Override
    public boolean delete(DataManager data) {
         String query = "delete from `"+table+"` where soPhieuXuat=? and maHang  = ?";
        try {
            PreparedStatement prsm = connect.prepareStatement(query);
            prsm.setString(1, (String) data.id);
            return prsm.executeUpdate() != 0;
        } catch (SQLException ex) {
            System.out.println("loi: " + ex);
        }

        return false;
        
    }
    
    
}
