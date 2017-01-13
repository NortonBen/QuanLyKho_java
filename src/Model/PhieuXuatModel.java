/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Libary.DataManager;
import static Model.Database.connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PhieuXuatModel extends Model{

    @Override
    public void init() {
         setTable("phieuxuat");
    }

     @Override
    public ResultSet getData(){
        ResultSet data = null;
        String sql = "SELECT * FROM `phieuxuatview`";
        data = getQuery(sql);
        return data;
    }

    @Override
    public boolean insert(DataManager data) {
       String query = "INSERT INTO `phieuxuat`(`SoPhieuXuat`, `NgayXuat`, `MaKhach`) VALUES (?,?,?)";
        try {
            PreparedStatement prsm = connect.prepareStatement(query);
            prsm.setString(1, data.id.toString());
            prsm.setString(2, data.data[0].toString());
            prsm.setString(3,data.data[1].toString());
            return prsm.executeUpdate() != 0;
        } catch (SQLException ex) {
            System.out.println("loi: " + ex);
        }

        return false;
    }

    @Override
    public boolean update(DataManager data) {
        String query = "update  `"+table+"` set ngayXuat = ? , maKhach = ?  where soPhieuXuat= ?";
        try {
            PreparedStatement prsm = connect.prepareStatement(query);
            prsm.setString(1, data.data[0].toString());
            prsm.setString(2,data.data[1].toString());
            prsm.setString(3,data.id.toString());
            return prsm.executeUpdate() != 0;
        } catch (SQLException ex) {
            System.out.println("loi: " + ex);
        }

        return false;
    }

    @Override
    public boolean delete(DataManager data) {
         String query = "delete from `"+table+"` where soPhieuXuat = ?";
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
