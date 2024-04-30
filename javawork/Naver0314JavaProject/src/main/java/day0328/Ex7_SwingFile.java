package day0328;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;

public class Ex7_SwingFile extends JFrame {

    JButton btnOpen, btnSave;
    JTextArea memoArea;

    public Ex7_SwingFile(String title){
        super(title);
        this.setLocation(100,100);  //시작위치
        this.setSize(500,500); // 창크기
        this.getContentPane().setBackground(new Color(93,199,187)); //배경색 변경
        //this.getContentPane().setBackground(Color.yellow); //배경색 변경
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
        this.initDesign(); //각종 컴포넌트 생성
        this.setVisible(true);
    }

    public void initDesign(){

        JPanel p = new JPanel();
        btnOpen = new JButton("파일열기");
        btnSave = new JButton("파일저장");
        p.add(btnOpen);
        p.add(btnSave);

        //프레임의 상단에 추가
        this.add("North",p);
        //메모장은 가운데 추가
        memoArea = new JTextArea();
        //this.add("Center",memoArea); //메모장크기보다 큰 내용을 불러올 경우 안보인다
        this.add("Center", new JScrollPane(memoArea)); //메모장크기보다 큰 내용을 불러올 경우 스크롤이 생긴다

        //파일열기 이벤트
        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //파일 다이얼로그(열기모드)
                FileDialog dlg = new FileDialog(Ex7_SwingFile.this,"파일열기", FileDialog.LOAD);
                dlg.setVisible(true); //다이얼로그 보이게하기

                if(dlg.getDirectory() == null)
                    return; //취소 클릭시 이벤트 종료
                String path = dlg.getDirectory() + dlg.getFile();

                FileReader fr = null;
                BufferedReader br = null;

                try {
                    fr = new FileReader(path);
                    br = new BufferedReader(fr);

                    //기존의 메모장 내용 모두 지우기
                    memoArea.setText("");

                    while (true){
                        //파일의 내용을 한 줄씩 읽는다
                        String line = br.readLine();
                        if(line == null)
                            break;
                        //메모장에 추가
                        memoArea.append(line + "\n");

                    }



                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    try {
                        br.close();
                        fr.close();
                    }catch (IOException | NullPointerException ex){

                    }
                }
            }
        });

        //파일 저장 이벤트
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog dlg = new FileDialog(Ex7_SwingFile.this,"파일저장", FileDialog.SAVE);
                dlg.setVisible(true); //다이얼로그 보이게하기

                if(dlg.getDirectory() == null)
                    return; //취소 클릭시 이벤트 종료
                String path = dlg.getDirectory() + dlg.getFile();

                FileWriter fw = null;
                try {
                    fw = new FileWriter(path);
                    //메모장의 내용을 파일에 저장하기
                    fw.write(memoArea.getText()); //한번에 저장됌
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }finally {
                    try {
                        fw.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }


            }
        });



    }


    public static void main(String[] args) {

        Ex7_SwingFile a = new Ex7_SwingFile("간단메모");

    }
}
