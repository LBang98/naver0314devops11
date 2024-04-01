package day0329;

import day0328.Ex7_SwingFile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;

public class Ex7_SwingFileMunje extends JFrame {
    JButton btnAdd, btnDelete;
    JTextField text;
    JComboBox combo1,combo2,combo3;
    int selectCombo1=0, selectCombo2=0, selectCombo3=0;
    final static String FILENAME = "/Users/ibyeonghyeon/Desktop/naver0314/sawon.txt";

    JTable table;
    DefaultTableModel tableModel;

    String [] combolabel1 ={"A","B","O","AB"}; //혈액형
    String [] combolabel2 = {"강동","강서","강남","강북"}; //지역
    String [] combolabel3 = {"사원","대리","과장","부장"}; //직급




    public Ex7_SwingFileMunje(String title){
        super(title);
        this.setLocation(100,100);  //시작위치
        this.setSize(500,500); // 창크기
        //this.getContentPane().setBackground(new Color(93,199,187)); //배경색 변경
        //this.getContentPane().setBackground(Color.yellow); //배경색 변경
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);

                FileWriter fw = null;

                try {
                    fw = new FileWriter(FILENAME);

                    for (int i=0; i<table.getRowCount(); i++){

                        String name = table.getValueAt(i,0).toString();
                        String blood = table.getValueAt(i,1).toString();
                        String addr = table.getValueAt(i,2).toString();
                        String position = table.getValueAt(i,3).toString();

                        String s = name+ "," + blood + "," + addr + "," + position + "\n";
                        fw.write(s);
                    }


                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }finally {
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
        this.readFile();
        this.setVisible(true);
    }
    public void readFile(){

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            while (true){

                String s = br.readLine();

                if(s == null)
                    break;

                String [] data = s.split(",");
                tableModel.addRow(data);


            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this,"파일을 찾을수 없다");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void initDesign(){

        //맨위 버튼
        JPanel pTop = new JPanel();
        btnAdd = new JButton("추가");
        btnDelete = new JButton("삭제");

        pTop.add(btnAdd);
        pTop.add(btnDelete);
        this.add("North",pTop);

        //중간 테이블
        String[] s = {"이름","혈액형","주소","직급"};
        tableModel = new DefaultTableModel(s,0);
        table = new JTable(tableModel);
        this.add("Center",new JScrollPane(table));

        //아래 콤보박스
        text = new JTextField("",4);
        combo1 = new JComboBox<>(combolabel1);
        combo2 = new JComboBox<>(combolabel2);
        combo3 = new JComboBox<>(combolabel3);

        JPanel pBottom = new JPanel();

        pBottom.add(new JLabel("이름"));
        pBottom.add(text);
        pBottom.add(combo1);
        pBottom.add(combo2);
        pBottom.add(combo3);
        this.add("South",pBottom);


        combo1.setSelectedIndex(selectCombo1 - 1);
        combo2.setSelectedIndex(selectCombo2 - 1);
        combo3.setSelectedIndex(selectCombo3 - 1);

        //콤보 이벤트
        combo1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selectCombo1 = combo1.getSelectedIndex() + 1;
                selectCombo2 = combo2.getSelectedIndex() + 1;
                selectCombo3 = combo3.getSelectedIndex() + 1;

            }
        });



        //추가 이벤트
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAdd = new JButton();

                String name = text.getText();
                String blood = combo1.getSelectedItem().toString();
                String addr = combo2.getSelectedItem().toString();
                String position = combo3.getSelectedItem().toString();

                Vector<String> data = new Vector<>();

                data.add(name);
                data.add(blood);
                data.add(addr);
                data.add(position);

                tableModel.addRow(data);

                text.setText("");



            }
        });


        //삭제 이벤트
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                String name = text.getText();

                if(row == -1)
                    JOptionPane.showMessageDialog(Ex7_SwingFileMunje.this,"삭제할 행을 선택해주세요");
                else
                    tableModel.removeRow(row);
            }
        });





    }


    public static void main(String[] args) {

        Ex7_SwingFileMunje a = new Ex7_SwingFileMunje("기본창");

    }
}
