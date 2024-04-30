package day0328;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Ex4_SwingButton extends JFrame {
    JButton btn1, btn2;
    JButton [] btnArray = new JButton[6];   //각 배열의 값 null
    String[] btnLabel = {"초록색", "빨간색","분홍색","오렌지색","노란색","랜덤색"};

public Ex4_SwingButton(String title){
        super(title);
        this.setLocation(100,100);  //시작위치
        this.setSize(300,300); // 창크기
        this.getContentPane().setBackground(new Color(93,199,187)); //배경색 변경
        //this.getContentPane().setBackground(Color.yellow); //배경색 변경
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
        this.initDesign(); //각종 컴포넌트 생성
        this.setVisible(true);
    }

    public void initDesign() {
        this.setLayout(null); //기본 레이아웃 없애기
        //버튼 1 생성
        btn1 = new JButton("Hello!!!");
        //프레임에 추가
        btn1.setBounds(10, 10, 100, 30);
        this.add(btn1);
        //btn1 에 이벤트 추가 - 익명 내부 클래스 형태로 이벤트 구현
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Ex4_SwingButton.this, "버튼 1 을 눌렀어요");
            }
        });


        //버튼 2 생성 후  프레임에 추가해보세요
        btn2 = new JButton("Nice!!!");
        btn2.setBounds(130, 10, 100, 30);
        this.add(btn2);

        //btnArray 배열 변수를 생성 후 프레임에 추가
        int yPos = 50;
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i] = new JButton(btnLabel[i]);
            btnArray[i].setBounds(10, yPos, 100, 30);
            this.add(btnArray[i]);
            yPos += 35;

            //익명 내부 클래스 형태로 이벤트 구현
            btnArray[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Object ob = e.getSource(); //이벤트가 발생한 오브젝트
                    JButton ob = (JButton) e.getSource();
                    System.out.println(ob.getText()); //초록색
                    //System.out.println(ob.getLabel()); //초록색

                    switch (ob.getText()){
                        case "빨간색":
                            //부모컴포넌트의 인스턴스 변수인 this 를 통해서 배경색 변경
                            Ex4_SwingButton.this.getContentPane().setBackground(Color.red);
                            break;
                        case "초록색":
                            Ex4_SwingButton.this.getContentPane().setBackground(Color.green);
                            break;
                        case "분홍색":
                            Ex4_SwingButton.this.getContentPane().setBackground(Color.pink);
                            break;
                        case "오렌지색":
                            Ex4_SwingButton.this.getContentPane().setBackground(Color.orange);
                            break;
                        case "노란색":
                            Ex4_SwingButton.this.getContentPane().setBackground(Color.yellow);
                            break;
                        case "랜덤색":
                            //0~255 의 임의의 숫자
                            Random ra = new Random();
                            int r = ra.nextInt(255);
                            int g = ra.nextInt(255);
                            int b = ra.nextInt(255);

                            Ex4_SwingButton.this.getContentPane().setBackground(new Color(r,g,b));



                    }
                }
            });
        }

        //버튼 2 이벤트
        class Button2Event implements ActionListener {

                public void actionPerformed (ActionEvent e){
                    JOptionPane.showMessageDialog(Ex4_SwingButton.this, "버튼 2 를 눌렀어요");
                }
            }
        }

    public static void main(String[] args) {

        Ex4_SwingButton a = new Ex4_SwingButton("스윙버튼");

    }
}
