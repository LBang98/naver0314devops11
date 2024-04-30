package day0329;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class Ex2_SwingDraw extends JFrame implements MouseMotionListener,MouseListener {

    //초기 선 색상
    Color color = Color.green;
    int x,y,prex,prey; //곡선을 그릴 현재 좌표 x,y 와 직전 좌표 prex,prey

    @Override
    public void mouseClicked(MouseEvent e) {
        //클릭 시 x,y 변경
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {

        x = e.getX();
        y = e.getY();

        //색상 변경
        Random ra = new Random();
        int r = ra.nextInt(255);
        int g = ra.nextInt(255);
        int b = ra.nextInt(255);

        color = new Color(r,g,b);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //현재 좌표를 직전좌표로 저장
        prex = x;
        prey = y;

        //현재 좌표는 마우스 위치로 저장
        x = e.getX();
        y = e.getY();

        //paint 다시 호출
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public Ex2_SwingDraw(String title){
        super(title);
        this.setLocation(100,100);  //시작위치
        this.setSize(500,500); // 창크기
        this.getContentPane().setBackground(new Color(0, 232, 255)); //배경색 변경
        //this.getContentPane().setBackground(Color.yellow); //배경색 변경
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
        //마우스 이벤트 추가
        this.addMouseMotionListener(this);
        this.addMouseListener(this);

        this.initDesign(); //각종 컴포넌트 생성
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);

        //선색상
        g.setColor(color);

        //선굵기 지정
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(5));

        //선 그리기
        //g.drawLine(10,100,400,100);

        //곡선은 마우스를 드래그 시 직전좌표부터 현재좌표까지 선을 그리면 곡선이 된다
        g.drawLine(prex,prey,x,y);



    }

    public void initDesign(){



    }


    public static void main(String[] args) {

        Ex2_SwingDraw a = new Ex2_SwingDraw("곡선그리기");

    }
}
