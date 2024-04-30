package day0328;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class Ex8_ extends JFrame {

    JButton btnOpen;
    MyDraw draw = new MyDraw();
    String path;

    public Ex8_(String title){
        super(title);
        this.setLocation(100,100);  //시작위치
        this.setSize(500,500); // 창크기
        //this.getContentPane().setBackground(new Color(93,199,187)); //배경색 변경
        //this.getContentPane().setBackground(Color.yellow); //배경색 변경
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
        this.initDesign(); //각종 컴포넌트 생성
        this.setVisible(true);
    }

    class MyDraw extends Canvas{

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            Image image1 = new ImageIcon(path).getImage();
            g.drawImage(image1,0,0,getWidth(),getHeight(),this);

        }
    }


    public void initDesign(){
        JPanel p = new JPanel();

        btnOpen = new JButton("파일열기");
        p.add(btnOpen);

        this.add("North",btnOpen);
        this.add("Center",draw);

        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FileDialog dlg = new FileDialog(Ex8_.this,"파일열기", FileDialog.LOAD);
                dlg.setVisible(true);

                path = dlg.getDirectory() + dlg.getFile();
                draw.repaint();
            }
        });

    }


    public static void main(String[] args) {

        Ex8_ a = new Ex8_("문제");

    }
}
