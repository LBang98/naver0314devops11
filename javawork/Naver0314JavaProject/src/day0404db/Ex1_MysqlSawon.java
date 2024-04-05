package day0404db;

import java.sql.*;

public class Ex1_MysqlSawon {

    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
    static final String USERNAME ="root";
    static final String PASSWORD = "system";


    static public void showTitle(){
        System.out.println("=".repeat(40));
        System.out.println("시퀀스\t이름\t성별\t부서\t점수");
        System.out.println("=".repeat(40));
    }

    public void writeSawon(){

        //URL이 맞으면 Connection 을 얻는다
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null; //select 문일경우에만 필요한 클래스
        String sql = "select * from sawon order by num";

        try {
            conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
            System.out.println("Mysql 서버에 연결 성공!");

            showTitle();

            stmt = conn.createStatement(); //sql을 실행하기 위한 statement 얻기
            rs = stmt.executeQuery(sql); //select 문일 경경우는 무조건 executeQuery 로 실행한다

            //rs.next()는 다음 레코드로 이동을 하면서 true 반환, 그런데 이동할 데이터가 더이상 없으면 false로 반환
            while (rs.next()){
                //데이타를 가져올때는 컬럼번호 또는 컬럼명으로 가져오면 된다
                int num = rs.getInt(1);
                String name = rs.getString(2);
                int score = rs.getInt(3);
                String gender = rs.getString(4);
                String buseo = rs.getString(5);

                System.out.println(num + "\t" + name + "\t" + gender + "\t" + buseo + "\t" + score);


            }


        } catch (SQLException e) {
            System.out.println("URL,USERNAME,PASSWORD 확인: " + e.getMessage());
        }

    }


    public Ex1_MysqlSawon(){

        try {
            Class.forName(MYSQL_DRIVER);
            System.out.println("Mysql8 드라이버 성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql8 드라이버 오류: " + e.getMessage());
        }


    }

    public static void main(String[] args) {

        Ex1_MysqlSawon ex1 = new Ex1_MysqlSawon();
        showTitle();
        ex1.writeSawon();

    }
}
