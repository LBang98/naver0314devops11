package day0405;

import day0404db.Ex1_MysqlSawon;

import java.sql.*;
import java.util.Scanner;

public class Ex8_SawonDelete {

    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
    static final String USERNAME ="root";
    static final String PASSWORD = "system";

    public Ex8_SawonDelete(){

        try {
            Class.forName(MYSQL_DRIVER);
            System.out.println("Mysql8 드라이버성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql8 드라이버오류: " + e.getMessage());
        }
    }
    public void deleteSawon(){

        Scanner sc = new Scanner(System.in);
        String delName = "";
        System.out.println("삭제할 이름을 입력하세요");
        delName = sc.nextLine();

        String sql = "delete from sawon where name = ? ";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,delName);

            //executeUpdate : sql 문을 실행 후 실행한 레코드의 갯수를 반환
            //n이 0이면 삭제할 데이타가 없다는 의미
            int n = pstmt.executeUpdate();
            if(n==0)
                System.out.println(delName + "님은 명단에 없습니다");
            else
                System.out.println(n + "명의 " + delName + " 님을 삭제했습니다");


            //매번 원크벤치가서 확인하기 싫으면
            Ex1_MysqlSawon sawon = new Ex1_MysqlSawon();
            sawon.writeSawon();



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

        Ex8_SawonDelete ex7 = new Ex8_SawonDelete();
        ex7.deleteSawon();
    }
}
