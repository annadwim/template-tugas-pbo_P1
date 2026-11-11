/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook;
import java.sql.*;
/**
 *
 * @author Asus
 */
public class DBConnector {
    private Connection Connect;
    private Statement Sttment;

    public DBConnector() { 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost/praktikum_pbo","root","");
            Sttment = Connect.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Connection Failed : " + ex.getMessage());
        }
    }
    
    public boolean InsertSQL(String SQLStatement){
        boolean Success;
        try {
            Success = Sttment.execute(SQLStatement);
        } catch (SQLException ex) {
            System.out.println("Insert Failed : " + ex.getMessage());
            return false;
        }
        return Success;
    }
    
    public boolean DeleteSQL(String SQLStatement){
        boolean Success;
        try {
            Success = Sttment.execute(SQLStatement);
        } catch (SQLException ex) {
            System.out.println("Delete Failed : " + ex.getMessage());
            return false;
        }
        return Success;
    }
    
    public ResultSet SelectSQL(String SQLStatement){
        ResultSet RS = null;
        try {
            RS = Sttment.executeQuery(SQLStatement);
        } catch (SQLException ex) {
            System.out.println("Select Failed : " + ex.getMessage());
        }
        return RS;        
    }
}
