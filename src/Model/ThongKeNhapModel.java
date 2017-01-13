/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Libary.DataManager;
import java.sql.ResultSet;

/**
 *
 * @author Thanh Huyen
 */
public class ThongKeNhapModel extends Model {
    
    @Override
    public void init() {
        setTable("thongkenhap");
    }

     @Override
    public ResultSet getData() {
        ResultSet data = null;
        data = getQuery("select * from "+table);
        return data;
    }

    @Override
    public boolean insert(DataManager data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(DataManager data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(DataManager data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet Thongke(String data) { //To change body of generated methods, choose Tools | Templates.
        String sql = "select * from `thongkenhap` where DATE_SUB(NgayNhap,MONTH) = '"+data+"'";
        ResultSet data_ = null;
        data_ = getQuery(sql);
        return data_;
    }

    
   
}
    


