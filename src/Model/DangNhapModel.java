
package Model;


import java.sql.SQLException;
import java.sql.ResultSet;


public class DangNhapModel extends Database {

    public boolean CheckDangNhap(String username, String PassWord) {
        String query = "Select * from `userlogin` where username = '"+username+"' and password = '"+PassWord+"'";
        try {
            ResultSet rs = getQuery(query);
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Loi truy van dang nhap: " + ex);
        }

        return false;
    }

}
