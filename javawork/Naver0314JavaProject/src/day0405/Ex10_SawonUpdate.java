package day0405;

import day0404db.Ex1_MysqlSawon;

import java.sql.*;
import java.util.Scanner;

public class Ex10_SawonUpdate {

    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
    static final String USERNAME ="root";
    static final String PASSWORD = "system";

    public Ex10_SawonUpdate(){

        try {
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql8 드라이버오류: " + e.getMessage());
        }
    }

    public void sawonUpdate(){

        Ex1_MysqlSawon ex = new Ex1_MysqlSawon();
        ex.writeSawon();


        Scanner sc = new Scanner(System.in);

        String updateName, updateBuseo;
        int updateScore;

        System.out.println("수정할 이름은?");
        updateName = sc.nextLine();

        System.out.println("수정할 점수는?");
        updateScore = Integer.parseInt(sc.nextLine());

        System.out.println("수정할 부서는?");
        updateBuseo = sc.nextLine();

        String sql = "update sawon set score = ?, buseo =  ? where name =  ?";


        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,updateScore);
            pstmt.setString(2,updateBuseo);
            pstmt.setString(3,updateName);

            int n = pstmt.executeUpdate();

            if(n == 0)
                System.out.println(updateName + "님은 없습니다");
            else {
                System.out.println(updateName + "님을 수정했습니다");
                ex.writeSawon();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }


    }


    public static void main(String[] args) {
        Ex10_SawonUpdate ex10 = new Ex10_SawonUpdate();
        ex10.sawonUpdate();
    }
}
