
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class Database {

    public static Connection connect;

    String url;

    public Database() {
        url = "jdbc:mysql://localhost/quanlykho";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi load driver: " + ex);
        }
        try {
            connect = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            System.out.println("loi ket noi SQL: " + ex);
        }
    }

    public void setUrl(String url) {
        this.url = url;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi load driver: " + ex);
        }
        try {
            connect = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            System.out.println("loi ket noi SQL: " + ex);
        }
    }

    public ResultSet getQuery(String query) {
        ResultSet rs = null;
        try {
            Statement stmt = connect.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Loi truy van: " + ex);
        }
        return rs;
    }

    public Connection getConnect() {
        return connect;
    }

}
