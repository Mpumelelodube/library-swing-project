package model;

import java.sql.*;


public class DatabaseConnection {
    private static final String USERNAME = "mpume";
    private static final String PASSWORD = "12566521#";
    private static final String CONN = "jdbc:mysql://localhost:3306/reaper";


    public static void main(String[] args) throws SQLDataException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student2");
            System.out.println("conected");
            resultSet.first();
            System.out.println("student id: "+resultSet.getInt(1)+" first name: "+resultSet.getString(2)+" last name: "+resultSet.getString(3)
                    +" programme is: "+resultSet.getString(4)+" gender: "+resultSet.getString(5));
        } catch (SQLException e) {
            System.out.println("conn failed");
        }
        finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
