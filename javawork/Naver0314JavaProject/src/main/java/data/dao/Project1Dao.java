package data.dao;

import data.dto.MemoDto;
import data.dto.Project1Dto;
import data.dto.SawonDto;
import data.dto.ShopDto;
import db.common.MySqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;


public class Project1Dao {

    MySqlConnect db = new MySqlConnect();

    //장바구니
    public void addCart(Project1Dto dto) {

        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        String sql="INSERT INTO mycart (itemName, itemPrice) VALUES (?, ?)";

        try {
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getItemName());
            pstmt.setInt(2, dto.getItemPrice());
            //실행
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }
    }
    public void delCart(int num) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "delete from mycart where num=?";

        conn = db.getConnection();

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);

            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.dbClose(pstmt, conn);
        }
    }
    public void delAllCart() {

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "delete from mycart";

        conn = db.getConnection();

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.dbClose(pstmt, conn);
        }
    }

    public Project1Dto getOneCart(int num) {

        Project1Dto dto=new Project1Dto();

        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String sql="""
				select * from mycart where num=?
				""";

        try {
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1, num);
            //실행
            rs=pstmt.executeQuery();

            if(rs.next()) {
                dto.setNum(rs.getInt("num"));
                dto.setItemName(rs.getString("itemName"));
                dto.setItemPrice(rs.getInt("itemPrice"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }
        return dto;

    }


    public List<Project1Dto> getCart() {
        List<Project1Dto> list = new Vector<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from mycart order by num desc";

        conn = db.getConnection();

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Project1Dto dto = new Project1Dto();
                dto.setNum(rs.getInt("num"));
                dto.setItemName(rs.getString("itemName"));
                dto.setItemPrice(rs.getInt("itemPrice"));

                list.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("select 오류:" + e.getMessage());
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return list;
    }
    //리뷰
    public void insertMemo(Project1Dto dto)
    {
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        String sql="insert into review (uploadphoto,title,content,writeday,rating) values (?,?,?,now(),?)";

        try {
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getUploadPhoto());
            pstmt.setString(2, dto.getTitle());
            pstmt.setString(3, dto.getContent());
            pstmt.setInt(4, dto.getRating());
            //실행
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }
    }
    public void delReview(int num) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "delete from review where num=?";

        conn = db.getConnection();

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);

            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.dbClose(pstmt, conn);
        }
    }

    //출력
    public List<Project1Dto> getAllMemo()
    {
        List<Project1Dto> list=new Vector<Project1Dto>();
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from review order by num desc";

        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()) {
                Project1Dto dto=new Project1Dto();
                dto.setNum(rs.getInt("num"));
                dto.setUploadPhoto(rs.getString("uploadphoto"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriteday(rs.getTimestamp("writeday"));
                dto.setRating(rs.getInt("rating"));

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
    public Project1Dto getData(int num)
    {
        Project1Dto dto=new Project1Dto();
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from review where num=?";

        try {
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1,num);
            //실행
            rs=pstmt.executeQuery();
            if(rs.next()) {
                dto.setNum(rs.getInt("num"));
                dto.setUploadPhoto(rs.getString("uploadphoto"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriteday(rs.getTimestamp("writeday"));
                dto.setRating(rs.getInt("rating"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }
        return dto;
    }
    public int countItem(){

        int count=0;

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select count(*) AS num from mycart";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if(rs.next()){
                count = rs.getInt("num");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.dbClose(rs, pstmt, conn);
        }


        return count;
    }






}
