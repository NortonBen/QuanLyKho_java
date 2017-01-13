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
public class ThongKeTonModel extends Model {
     @Override
    public void init() {
        setTable("thongketon");
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
    public ResultSet Thongke(String data) {
        ResultSet rs = null;
        String str = "select * from `thongketon` where DATE_SUB(NgayNhap,MONTH) = '"+data+"'";
        rs = getQuery(str);
        return rs;
    }

    
}
