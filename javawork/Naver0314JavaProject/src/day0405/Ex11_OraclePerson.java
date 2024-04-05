package day0405;

import java.sql.*;
import java.util.Scanner;

// 오라클 JDBC 설치안함..

public class Ex11_OraclePerson {

    static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
    static final String ORACLE_URL = "jdbc:oracle:thin:@192.168.0.59:1521/xe";
    static final String USERNAME = "angel";
    static final String PASSWORD = "a1234";

    public void Ex11OraclePerson(){

        try {
            Class.forName(ORACLE_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql8 드라이버오류: " + e.getMessage());
        }
    }

    public void insertPerson(String name, String blood, int age){

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "";

        sql = "INSERT into person values (seq_test.nextval,?,?,?,sysdate)";

        try {
            conn = DriverManager.getConnection(ORACLE_URL,USERNAME,PASSWORD);
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,name);
            pstmt.setString(2,blood);
            pstmt.setInt(3,age);

            pstmt.execute();

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

    public void writePerson(){

        String sql = "";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;

        sql = "select * from person";

        try {
            conn = DriverManager.getConnection(ORACLE_URL,USERNAME,PASSWORD);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            System.out.println("\t** Person Table **\t");
            System.out.println("시퀀스\t이름\t혈액형\t나이\t입사일");
            System.out.println("=".repeat(40));

            while (rs.next()){

                int num = rs.getInt("num");
                String name = rs.getString("name");
                String blood = rs.getString("blood");
                String age = rs.getString("age");
                String ipsa = rs.getString("ipsa");

                System.out.println(num + "\t" + name + "\t" + blood + "\t" + age + "\t" + ipsa);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {
        Ex11_OraclePerson ex11 = new Ex11_OraclePerson();

        ex11.Ex11OraclePerson();

        Scanner sc = new Scanner(System.in);

        int menu = 0;
        String name, blood;
        int age;

        while(true){
            System.out.println("1.데이타 추가    2.전체출력    3.종료");
            menu = Integer.parseInt(sc.nextLine());

            switch (menu){
                case 1:
                    System.out.println("이름입력");
                    name = sc.nextLine();
                    System.out.println("혈액형은?");
                    blood = sc.nextLine();
                    System.out.println("나이는?");
                    age = Integer.parseInt(sc.nextLine());

                    ex11.insertPerson(name,blood,age);
                    break;

                case 2:
                    ex11.Ex11OraclePerson();
                    break;
                default:
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
            }
            System.out.println();
        }
    }
}
