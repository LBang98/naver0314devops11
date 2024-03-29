package day0329;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ex4_SwingTable extends JFrame {

    JTable table;
    JLabel lblMessage;


    public Ex4_SwingTable(String title){
        super(title);
        this.setLocation(100,100);  //시작위치
        this.setSize(400,300); // 창크기
        this.getContentPane().setBackground(new Color(93,199,187)); //배경색 변경
        //this.getContentPane().setBackground(Color.yellow); //배경색 변경
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
        this.initDesign(); //각종 컴포넌트 생성
        this.setVisible(true);
    }

    public void initDesign(){

        String[] title = {"이름","나이","혈액형","핸드폰","주소"};
        String[][] data = {
                {"이영자","32세","B","010-1234-1234","서울"},
                {"강호동","45세","A","010-9090-2929","부산"},
                {"유재석","49세","O","010-2323-1313","제주도"},
                {"제니","24세","AB","010-1212-2332","뉴욕"}
        };

        table = new JTable(data,title);
        //상단에 제목 출력
        this.add("North",new JLabel("701 멤버 현황",JLabel.CENTER));

        //프레임의 센터에 추가
        this.add("Center",new JScrollPane(table));  //테이블도 스크롤바가 생겨야 한다(제목포함)
        //메시지 라벨을 South 에 추가
        lblMessage = new JLabel("결과 나올 곳...",JLabel.CENTER);
        lblMessage.setFont(new Font("", Font.BOLD,15));
        this.add("South",lblMessage);

        //테이블 이벤트
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                //선택한 행번호
                int rowIndex = table.getSelectedRow();
                System.out.println(rowIndex);

                //클린한곳에서 이름,나이,주소정도만 얻어서 메시지에 출력해보자
                String name = table.getValueAt(rowIndex, 0).toString();
                String age = table.getValueAt(rowIndex, 1).toString();
                String addr = table.getValueAt(rowIndex, 4).toString();

                String m = name + "님은 " + age + "이며 " + addr + "에 살고있어요";
                lblMessage.setText(m);
            }
        });
    }


    public static void main(String[] args) {

        Ex4_SwingTable a = new Ex4_SwingTable("테이블");

    }
}
