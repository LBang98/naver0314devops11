package day0405;

import java.sql.*;
import java.util.Scanner;

public class Ex12_Student {

        static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
        static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
        static final String USERNAME ="root";
        static final String PASSWORD = "system";

        public Ex12_Student() {

            try {
                Class.forName(MYSQL_DRIVER);
                System.out.println("Mysql8 드라이버성공!");
            } catch (ClassNotFoundException e) {
                System.out.println("Mysql8 드라이버오류: " + e.getMessage());
            }
        }
        public void insertStudent(String name, int java, int html, int spring){
            Connection conn = null;
            PreparedStatement pstmt = null;

            String sql = "INSERT INTO student (name,java,html,spring) VALUE (?,?,?,?)";

            try {
                conn = DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,name);
                pstmt.setInt(2,java);
                pstmt.setInt(3,html);
                pstmt.setInt(4,spring);

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
        public void deleteStudent(String name){

            Connection conn = null;
            PreparedStatement pstmt = null;

            String sql = "delete from student where name = ?";

            try {
                conn = DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
                pstmt = conn.prepareStatement(sql);

                pstmt.setString(1,name);

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

        public void writeStudent(){
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            String sql = "SELECT num,name,java,html,spring,\n" +
                    "\tjava+html+spring tot, ROUND((java+html+spring)/3,1) avg,\n" +
                    "\tDATE_FORMAT(testday, '%Y-%M-%D %H:%i') testday\n" +
                    "from student;";

            try {
                conn = DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();

                System.out.println("*** 조회 ***");
                System.out.println("시퀀스\t이름\t자바\tHTML\t스프링\t총합\t평균\t날짜");
                System.out.println("=".repeat(40));

                while(rs.next()){

                    int num = rs.getInt("num");
                    String name = rs.getString("name");
                    int java = rs.getInt("java");
                    int html = rs.getInt("html");
                    int spring = rs.getInt("spring");
                    int tot = rs.getInt("tot");
                    int avg = rs.getInt("avg");
                    String testday = rs.getString("testday");

                    System.out.println(num + "\t" + name + "\t" + java + "\t" + html + "\t" + spring + "\t" +
                                        tot + "\t" + avg + "\t" + testday);

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

        public void updateStudent(){

            Scanner sc = new Scanner(System.in);
            Connection conn = null;
            PreparedStatement pstmt = null;

            String sql = "update student set java = ?, html = ?, spring = ? where name = ?";

            String name;
            int java,html,spring;

            System.out.println("수정할 이름은?");
            name = sc.nextLine();
            System.out.println("자바 점수는?");
            java = Integer.parseInt(sc.nextLine());
            System.out.println("HTML 점수는?");
            html = Integer.parseInt(sc.nextLine());
            System.out.println("Spring 점수는?");
            spring = Integer.parseInt(sc.nextLine());

            try {
                conn = DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
                pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1,java);
                pstmt.setInt(2,html);
                pstmt.setInt(3,spring);
                pstmt.setString(4,name);

                pstmt.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    pstmt.close();
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }


        }

    public static void main(String[] args) {
        Ex12_Student ex12 = new Ex12_Student();

        Scanner sc= new Scanner(System.in);

        int menu=0;
        String name;
        int java,html,spring;

        while (true){
            System.out.println("1.삽입    2.삭제    3.조회    4.수정    5.종료");
            menu = Integer.parseInt(sc.nextLine());

            if(menu == 1){
                System.out.println("추가할 이름은?");
                name = sc.nextLine();
                System.out.println("자바 점수는?");
                java = Integer.parseInt(sc.nextLine());
                System.out.println("HTML 점수는?");
                html = Integer.parseInt(sc.nextLine());
                System.out.println("Spring 점수는?");
                spring = Integer.parseInt(sc.nextLine());

                ex12.insertStudent(name,java,html,spring);
            }
            else if(menu == 2 ){
                System.out.println("삭제할 학생의 이름은?");
                name = sc.nextLine();
                ex12.deleteStudent(name);
            }
            else if(menu ==3) {
                ex12.writeStudent();
            }

            else if(menu ==4){
                ex12.updateStudent();
            }
            else {
                System.out.println("*** 프로그램을 종료합니다 ***");
                break;
            }
            System.out.println("-".repeat(30));


        }






    }
}
