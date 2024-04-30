package day0320;

public class Ex7_Array {
    public static void main(String[] args) {

        int []data = {1,2,3,4,5,6,7,8,9,-1};
        int max,min;
        max = min = data[0]; //무조건 첫데이타를 max 또는 min 지정

        for(int i=1; i<data.length; i++){
            if(max<data[i])
                max = data[i];
            if(min>data[i])
                min = data[i];
        }
        System.out.println("최대값: " + max);
        System.out.println("최소값: " + min);

        int pcnt = 0, mcnt = 0;
        //배열데이타 중 양수의 갯수와 음수의 갯수를 구하여서 출력해보시오
        for(int i=0; i<data.length; i++){
            if(data[i]>0)
                pcnt++;
            else if(data[i]<0)
                mcnt++;
        }
        System.out.println("양수의 갯수: " + pcnt);
        System.out.println("음수의 갯수: " + mcnt);

    }
}
