package day0328;

import javax.swing.*;
import java.awt.*;

public class SwingGibon extends JFrame {

    public SwingGibon(String title){
        super(title);
        this.setLocation(100,100);  //시작위치
        this.setSize(300,300); // 창크기
        this.getContentPane().setBackground(new Color(93,199,187)); //배경색 변경
        //this.getContentPane().setBackground(Color.yellow); //배경색 변경
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
        this.initDesign(); //각종 컴포넌트 생성
        this.setVisible(true);
    }

    public void initDesign(){

    }


    public static void main(String[] args) {

        SwingGibon a = new SwingGibon("기본창");

    }
}
