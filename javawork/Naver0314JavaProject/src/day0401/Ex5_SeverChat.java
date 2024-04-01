package day0401;

import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Ex5_SeverChat extends JFrame implements Runnable {
    JTextArea area;
    Vector<ClientMember> list = new Vector<Ex5_SeverChat.ClientMember>();
    ServerSocket serverSocket;


    public Ex5_SeverChat(String title){
        super(title);
        this.setLocation(100,100);  //시작위치
        this.setSize(300,300); // 창크기
        this.getContentPane().setBackground(new Color(93,199,187)); //배경색 변경
        //this.getContentPane().setBackground(Color.yellow); //배경색 변경
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
        this.initDesign(); //각종 컴포넌트 생성
        this.setVisible(true);
    }
    //접속하는 클라이언트들을 허용하고 벡터에 저장하는 기능
    @Override
    public void run() {

    }

    //클라이언트 내부클래스
    class ClientMember extends Thread{
        Socket mySocket;
        String nickName;
        BufferedReader br;
        PrintWriter pw;
        //생성자
        public ClientMember(Socket socket){
            //외부의 run 메소드에서 생성 시 소켓을 받아서 생성할것임
            mySocket = socket;

            //네트워크를 통해서 메시지를 읽고 쓸수 있도록 io 클래스 생성
            try {
                br = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            }catch (IOException e){

            }

        }

        //각 클라이언트로부터 들어오는 메시지를 읽어서 모든 클라이언트들한테 보내주는 기능
        @Override
        public void run() {
            super.run();
        }
    }
    public void initDesign(){

    }


    public static void main(String[] args) {

        Ex5_SeverChat a = new Ex5_SeverChat("기본창");

    }
}
