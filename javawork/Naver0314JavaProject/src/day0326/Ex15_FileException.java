package day0326;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex15_FileException {

    static final String FILENAME ="/Users/ibyeonghyeon/Desktop/naver0314/memo1.txt";
    static final String FILENAME2 ="/Users/ibyeonghyeon/Desktop/naver0314/memo2.txt";

    static public void fileSave(){

        FileWriter fw = null;
        try {
            fw = new FileWriter(FILENAME);
            fw.write("이름: 홍길동\n");
            fw.write("나이: 20세\n");
            fw.write("주소: 강남구\n");
            System.out.println("파일을 확인하세요");
        }catch (IOException e){
           e.printStackTrace();
        }finally {
            try{
                fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    static public void filesave2() throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String name, hp, addr;
        while (true){
            FileWriter fw =null;
            fw = new FileWriter(FILENAME2, true); //추가모드로 생성
            System.out.println("이름은 입력하세요 (종료시 x)");
            name = sc.nextLine();
            if (name.equals("x")){
                System.out.println("종료합니다");
                System.exit(0);
            }
            System.out.println("핸드폰은?");
            hp = sc.nextLine();
            System.out.println("주소는?");
            addr = sc.nextLine();

            System.out.println("입력한 정보를 파일에 저장합니다");
            fw.write("이름: " + name +"'\n");
            fw.write("핸드폰: " + hp +"'\n");
            fw.write("주소: " + addr +"'\n");
            fw.write("=".repeat(15) + "\n");
            System.out.println();
            fw.close(); //매번 닫은 후 다시 생성해서 데이타를 추가


        }

    }

    public static void main(String[] args) {
        //fileSave();
        try {
            filesave2();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
