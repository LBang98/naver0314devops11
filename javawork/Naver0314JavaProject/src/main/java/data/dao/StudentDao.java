package data.dao;

import data.dto.StudentDto;
import db.common.MySqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class StudentDao {

    MySqlConnect db = new MySqlConnect();

    //추가
    public void insertStudent(StudentDto dto){

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into mystudent(name, blood, license, java, spring, html, writeday) values(?,?,?,?,?,?,now())";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getBlood());
            pstmt.setString(3, String.valueOf(dto.getLicense()));
            pstmt.setInt(4,dto.getJava());
            pstmt.setInt(5,dto.getSpring());
            pstmt.setInt(6,dto.getHtml());

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt,conn);
        }


    }

    //목록출력
    public List<StudentDto> getAllStudent(){

        List<StudentDto> list = new Vector<>();

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from mystudent order by num";


        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()){

                StudentDto dto = new StudentDto();

                dto.setNum(rs.getInt("num"));
                dto.setName(rs.getString("name"));
                dto.setBlood(rs.getString("blood"));
                dto.setLicense(rs.getString("license").charAt(0));
                dto.setJava(rs.getInt("java"));
                dto.setSpring(rs.getInt("spring"));
                dto.setHtml(rs.getInt("html"));
                dto.setWriteday(rs.getTimestamp("writeday"));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }
        return list;
    }
    //디테일
    public StudentDto getData(int num){

        StudentDto dto = new StudentDto();

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from mystudent where num=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
            if(rs.next()){

                dto.setNum(rs.getInt("num"));
                dto.setName(rs.getString("name"));
                dto.setBlood(rs.getString("blood"));
                dto.setLicense(rs.getString("license").charAt(0));
                dto.setJava(rs.getInt("java"));
                dto.setSpring(rs.getInt("spring"));
                dto.setHtml(rs.getInt("html"));
                dto.setWriteday(rs.getTimestamp("writeday"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.dbClose(rs, pstmt, conn);
        }
        return dto;
    }
    public void deleteStudent(int num) {

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "delete from mystudent where num=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);

            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    public void updateStudent(StudentDto dto){

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "update mystudent set name=?,blood=?,license=?,java=?,spring=?,html=?";

        try {
            pstmt=conn.prepareStatement(sql);

            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getBlood());
            pstmt.setString(3,String.valueOf(dto.getLicense()));
            pstmt.setInt(4,dto.getJava());
            pstmt.setInt(5,dto.getSpring());
            pstmt.setInt(6,dto.getHtml());

            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.dbClose(rs,pstmt,conn);
        }

    }

}