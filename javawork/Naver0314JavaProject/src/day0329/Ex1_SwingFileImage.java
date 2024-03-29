package day0329;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex1_SwingFileImage extends JFrame {

    String photo;

    JButton btnImageOpen;
    MyPhoto myPhoto = new MyPhoto(); //캔바스 내부 클래스


    public Ex1_SwingFileImage(String title){
        super(title);
        this.setLocation(100,100);  //시작위치
        this.setSize(300,300); // 창크기
        this.getContentPane().setBackground(new Color(93,199,187)); //배경색 변경
        //this.getContentPane().setBackground(Color.yellow); //배경색 변경
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
        this.initDesign(); //각종 컴포넌트 생성
        this.setVisible(true);
    }

    //캠바스를 상속받는 내부클래스
    class MyPhoto extends Canvas{

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            Image image = new ImageIcon(photo).getImage();
            g.drawImage(image,0,0,this.getWidth(),getHeight(),this);


        }
    }


    public void initDesign(){
        //패널에 버튼을 생성 후 패널을 North 에 추가
        JPanel p = new JPanel();
        btnImageOpen = new JButton("이미지 불러오기");
        p.add(btnImageOpen);
        this.add("North", p);

        //캔버스는 Center 에 배치
        this.add("Center", myPhoto);

        //버튼 이벤트
        btnImageOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FileDialog dlg = new FileDialog(Ex1_SwingFileImage.this,"이미지 불러오기", FileDialog.LOAD);
                dlg.setVisible(true);
                if(dlg.getFile() == null)
                    return; //취소를 클릭 시 메서드종료
                //불러올 경로와 파일명
                photo = dlg.getDirectory() + dlg.getFile();
                //캔바스의 paint 메서드 다시 호출
                myPhoto.repaint();

            }
        });

    }


    public static void main(String[] args) {

        Ex1_SwingFileImage a = new Ex1_SwingFileImage("사진불러오기");

    }
}
