/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanLy.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ASUS
 */
public class ConnectionJDBC {
      public static Connection Connect_JDBC(){
        final String Url = "jdbc:sqlserver://DESKTOP-MU64O7N\\SQLEXPRESS:1433;database=QuanLiKhachSan";
        final String user = "sa";
        final String pass = "123456";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(Url, user, pass);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
