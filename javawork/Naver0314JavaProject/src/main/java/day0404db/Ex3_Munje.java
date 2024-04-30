package day0404db;

import java.sql.*;

public class Ex3_Munje {
    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
    static final String USERNAME ="root";
    static final String PASSWORD = "system";

    static public void showTitle(){

        System.out.println("=".repeat(25));
        System.out.println("부서" + "\t\t" + "인원" + "\t" + "최댓값" + "\t" + "평균");
        System.out.println("=".repeat(25));
    }
    public void write(){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select buseo, count(*) inwon, max(score) max, ceiling(avg(score)) avg from sawon group by buseo";


        try {
            conn = DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()){

                String buseo = rs.getString(1);
                int inwon = rs.getInt(2);
                int max = rs.getInt(3);
                int avg = rs.getInt(4);

                System.out.println(buseo + "\t" + inwon + "\t" + max + "\t\t" + avg);

            }


        } catch (SQLException e) {
            System.out.println("URL, NAME, PW 확인: " + e.getMessage());
        }


    }


    public static void main(String[] args) {

        Ex3_Munje ex3 = new Ex3_Munje();
        showTitle();
        ex3.write();
    }
}
