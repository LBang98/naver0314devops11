package day0326;
/*
* score.txt 를 읽어서 총 갯수와 총점, 평균을 구하시오
* 단, 점수에 문자가 있는 경우 갯수에서 제외하고 총점에서도 제외하고 출력하시오
*
* 갯수 : 13개
* 총점 : 990
* 평균 : 78.44
* */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

public class Ex17_ExceptionMunje {

    static final String FILENAME2 = "/Users/ibyeonghyeon/Desktop/naver0314/score.txt";
    static public void scoreRead() throws IOException {
        int score, sum=0, count=0;
        double avg=0;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(FILENAME2);
            br = new BufferedReader(fr);

            while (true){
                String s = br.readLine();
                if(s == null) //읽을 데이타가 더이상 없을 경우 while 종료
                    break;
                try{
                    score = Integer.parseInt(s); //문자일 경우 바로 catch 이동
                    count++;
                    sum+=score;

                }catch (NumberFormatException e){

                }
            }
            avg = (double)sum / count;

            System.out.println("점수 갯수: " + count);
            System.out.println("총   점: " + sum);
            //소수점 이하 2자리까지 출력
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            System.out.println("평   균: " + nf.format(avg));

        } catch (FileNotFoundException e) {
            System.out.println("파일이 없어요" + e.getMessage());
        } finally {
            br.close();
            fr.close();
        }


    }

    public static void main(String[] args) {
        try {
            scoreRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}