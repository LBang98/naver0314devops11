package day0329;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.List;
import java.util.Vector;

public class Ex6_SwingTableShop extends JFrame {

    JTable table;
    DefaultTableModel tableModel;
    JButton btnAdd,btnDelete;
    JTextField tfSang,tfSu,tfDan;

    final static String FILENAME = "/Users/ibyeonghyeon/Desktop/naver0314/myshop.txt";


    public Ex6_SwingTableShop(String title){
        super(title);
        this.setLocation(100,100);  //시작위치
        this.setSize(400,400); // 창크기
        //this.getContentPane().setBackground(new Color(93,199,187)); //배경색 변경
        //this.getContentPane().setBackground(Color.yellow); //배경색 변경
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료

        //윈도우 종료 시 테이블의 내용읊 파일에 저장 후 종료하자
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);

                FileWriter fw = null;

                try {
                    fw = new FileWriter(FILENAME);
                    //테이블의 행 갯수만큼 반복해서 데이타를 읽는다
                    for (int i = 0; i < table.getRowCount(); i++) {

                        String sang = table.getValueAt(i,0).toString();
                        String su = table.getValueAt(i,1).toString();
                        String dan = table.getValueAt(i,2).toString();
                        String total = table.getValueAt(i,3).toString();

                        String s = sang+ "," + su + "," + dan + "," + total + "\n";
                        //파일에 저장
                        fw.write(s);


                    }


                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    try {
                        fw.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }


                System.exit(0);
            }
        });

        this.initDesign(); //각종 컴포넌트 생성
        //파일의 내용을 불러오려면 테이블이 생성이 된 후 해야한다
        this.shopFileRead();

        this.setVisible(true);
    }
    //파일 불러와서 테이블에 출력하는 메서드
    public void shopFileRead(){

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            while (true){

                String s = br.readLine();
                if(s == null)
                    break;
                // , 로 분리하여 배열로 만든다
                String [] data = s.split(",");
                //테이블에 추가
                tableModel.addRow(data);



            }

        } catch (FileNotFoundException e) {
            System.out.println("파일없음: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public void initDesign(){

        //상단에는 추가, 삭제 버튼
        JPanel pTop = new JPanel();

        btnAdd = new JButton("상품정보추가");
        btnDelete = new JButton("상품정보삭제");
        pTop.add(btnAdd);
        pTop.add(btnDelete);
        this.add("North",pTop);

        //중간에는 테이블 추가
        String [] title = {"상품명","수량","단가","총금액"};
        tableModel = new DefaultTableModel(title,0);
        table = new JTable(tableModel);
        this.add("Center",new JScrollPane(table));

        //하단에는 입력 컴포넌트들
        tfSang = new JTextField(7);
        tfSu = new JTextField(4);
        tfDan = new JTextField(7);

        JPanel pBottom = new JPanel();
        pBottom.add(new JLabel("상품명"));
        pBottom.add(tfSang);
        pBottom.add(new JLabel("수량"));
        pBottom.add(tfSu);
        pBottom.add(new JLabel("단가"));
        pBottom.add(tfDan);

        this.add("South",pBottom);

        //추가버튼 이벤트
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //입력 안했을경우 종료
                if(tfSang.getText().length() == 0){
                    JOptionPane.showMessageDialog(Ex6_SwingTableShop.this, "상품명을 입력해주세요");
                    return;
                }
                if(tfSu.getText().length() == 0){
                    JOptionPane.showMessageDialog(Ex6_SwingTableShop.this, "상품명을 입력해주세요");
                    return;
                }
                if(tfDan.getText().length() == 0){
                    JOptionPane.showMessageDialog(Ex6_SwingTableShop.this, "상품명을 입력해주세요");
                    return;
                }

                String sang = tfSang.getText();
                int su= 0;
                int dan = 0;
                try{
                    su = Integer.parseInt(tfSu.getText());
                    dan = Integer.parseInt(tfDan.getText());
                }catch (NumberFormatException ex){
                    System.out.println("수량, 단가, 문자 입력오류");
                    JOptionPane.showMessageDialog(Ex6_SwingTableShop.this,"수량, 단가는 숫자만 입력하세요");
                    return;
                }
                int total = su * dan;


                //Vector 로 데이타를 담는다(data)
                Vector<String> data = new Vector<>();

                data.add(sang);
                data.add(String.valueOf(su));
                data.add(String.valueOf(dan));
                data.add(String.valueOf(total));

                //tableModel 로 추가한다(addRow)
                tableModel.addRow(data);

                //입력박스의 데이타는 지운다(setText)
                tfSang.setText("");
                tfSu.setText("");
                tfDan.setText("");

            }
        });
        //삭제버튼 이벤트
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                String sang = tfSang.getText();

                if(row == -1){
                    JOptionPane.showMessageDialog(Ex6_SwingTableShop.this, "삭제할 행을 선택해주세요");
                }
                else
                    tableModel.removeRow(row);


            }
        });

    }



    public static void main(String[] args) {

        Ex6_SwingTableShop a = new Ex6_SwingTableShop("상품등록및삭제");

    }
}
