package data.dto;

import data.dao.SawonDto;
import db.common.MySqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class SawonDao {

    MySqlConnect db = new MySqlConnect();

    //추가
    public void insertSawon(SawonDto dto){

        String sql = """
                insert into mysawon (name,buseo,age,addr,photo,gender,birthday)
                values (?,?,?,?,?,?,?)
                """;
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = db.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, dto.getName());
            pstmt.setString(2,dto.getBuseo());
            pstmt.setInt(3,dto.getAge());
            pstmt.setString(4,dto.getAddr());
            pstmt.setString(5,dto.getPhoto());
            pstmt.setString(6, dto.getGender());
            pstmt.setString(7,dto.getBirthday());

            //실행
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.dbClose(pstmt,conn);
        }
    }
    //전체출력
    public List<SawonDto> getAllSawons(){

        List<SawonDto> list = new Vector<>();
        String sql = """
                select * from mysawon order by name asc
                """;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = db.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()){

                SawonDto dto = new SawonDto();

                dto.setNum(rs.getInt("num"));
                dto.setName(rs.getString("name"));
                dto.setBuseo(rs.getString("buseo"));
                dto.setAge(rs.getInt("age"));
                dto.setAddr(rs.getString("addr"));
                dto.setPhoto(rs.getString("photo"));
                dto.setGender(rs.getString("gender"));
                dto.setBirthday(rs.getString("birthday"));

                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.dbClose(rs,pstmt,conn);
        }
        return list;
    }
    //한개반환
    public SawonDto getData(int num){

        SawonDto dto = new SawonDto();
        String sql = """
                select * from mysawon where num=?
                """;
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = db.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,dto.getNum());

            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dto;

    }

}
