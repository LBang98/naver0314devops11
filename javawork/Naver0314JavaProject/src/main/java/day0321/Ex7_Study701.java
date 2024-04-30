package day0321;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.SimpleTimeZone;

public class Ex7_Study701 {
    public static void main(String[] args) {
        String []member = {
                "강하윤","공병현","김도훈","김우형","김정호",
                "김창인","민경진","박민지","박보민","박주용",
                "박한경","배동우","서정현","손가원","시바타유니",
                "신완철","우태형","유상곤","이가현","이병현",
                "이장우","이현성","정민석","정상혁","정진욱",
                "정환용","최시현","허승필","황재웅","꽝!!"
        };

        //2차원 배열에 5명씩 총 6조
        String [][] team = new String[6][5];
        Random r = new Random();
        int[] rnd = new int[30];

        loop:
        for(int i=0; i< member.length; i++){
            rnd[i] = r.nextInt(30);

            for(int j=0; j<i; j++){
                if(rnd[i] == rnd[j]){
                    i--;
                    continue loop;
                }
            }
        }

        int idx = 0;
        for(int i=0; i< team.length; i++){
            for (int j=0; j<team[i].length; j++){
                team[i][j] = member[rnd[idx++]];
            }
        }

        //현재 날짜를 출력하시오 (년-월-일)
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        System.out.println("\t" + sdf.format(date));

        System.out.println("\t ** 701 스터디팀 **");

        for(int i=0; i< team.length; i++){
            System.out.printf("[%d조 팀]\t", i+1);
            for (int j=0; j<team[0].length; j++){
                System.out.print(team[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
