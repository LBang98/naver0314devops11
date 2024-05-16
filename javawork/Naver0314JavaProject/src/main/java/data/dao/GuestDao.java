package data.dao;

import data.dto.GuestDto;
import db.common.MySqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class GuestDao {

    MySqlConnect db = new MySqlConnect();

    //추가
    public void insertGuest(GuestDto dto)
    {
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        String sql="insert into guest (nickname,avata,content,writeday) values (?,?,?,now())";

        try {
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getNickname());
            pstmt.setString(2, dto.getAvata());
            pstmt.setString(3, dto.getContent());
            //실행
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }
    }
    //출력
    public List<GuestDto> getAllGuest()
    {
        List<GuestDto> list=new Vector<GuestDto>();
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from guest order by num desc";

        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()) {
                GuestDto dto=new GuestDto();
                dto.setNum(rs.getInt("num"));
                dto.setNickname(rs.getString("nickname"));
                dto.setAvata(rs.getString("avata"));
                dto.setContent(rs.getString("content"));
                dto.setWriteday(rs.getTimestamp("writeday"));

                list.add(dto);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }
        return list;
    }

    //검색
    public List<GuestDto> getSearchGuest(String seachWord)
    {
        List<GuestDto> list=new Vector<GuestDto>();
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from guest where nickname like ? order by num desc";

        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, "%"+seachWord+"%");
            rs=pstmt.executeQuery();
            while(rs.next()) {
                GuestDto dto=new GuestDto();
                dto.setNum(rs.getInt("num"));
                dto.setNickname(rs.getString("nickname"));
                dto.setAvata(rs.getString("avata"));
                dto.setContent(rs.getString("content"));
                dto.setWriteday(rs.getTimestamp("writeday"));

                list.add(dto);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }
        return list;
    }

    //성세보기
    public GuestDto getData(int num)
    {
        GuestDto dto=new GuestDto();
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from guest where num=?";

        try {
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1,num);
            //실행
            rs=pstmt.executeQuery();
            if(rs.next()) {
                dto.setNum(rs.getInt("num"));
                dto.setNickname(rs.getString("nickname"));
                dto.setAvata(rs.getString("avata"));
                dto.setContent(rs.getString("content"));
                dto.setWriteday(rs.getTimestamp("writeday"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }
        return dto;
    }
    //삭제
    public void deleteGuest(int num){
        GuestDto dto = new GuestDto();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        String sql = "delete from guest where num=?";

        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,num);
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.dbClose(pstmt,conn);
        }
    }
    //수정
    public void updateGuest(GuestDto dto){
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        String sql = "update guest set nickname=?, avata=?, content=?, writeday=? where num=?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, dto.getNickname());
            pstmt.setString(2, dto.getAvata());
            pstmt.setString(3, dto.getContent());
            pstmt.setTimestamp(4, dto.getWriteday());
            pstmt.setInt(5, dto.getNum());

            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.dbClose(pstmt,conn);
        }


    }


}
