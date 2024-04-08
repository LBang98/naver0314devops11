package day0408;

import java.sql.*;

public class DbConnect {
    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
    static final String USERNAME ="root";
    static final String PASSWORD = "system";

    public DbConnect(){

        try {
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;

    }
    public void dbClose(PreparedStatement pstmt, Connection conn){
        try {
            pstmt.close();
            conn.close();
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
    public void dbClose(PreparedStatement pstmt, Connection conn, ResultSet rs){
        try {
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
}
