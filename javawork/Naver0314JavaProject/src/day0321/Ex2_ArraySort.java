package day0321;


public class Ex2_ArraySort {
    public static void main(String[] args) {

        /*//두값을 바꿀경우
        int a = 10, b=20, temp;
        System.out.println("a= " + a + ", b= " + b);

        //두값을 서로 바ㅏ꾸기
        temp = a;
        a = b;
        b = temp;
        System.out.println("a= " + a + ", b= " + b);*/

        int[] arr = {5,8,2,1,10};
        //selection sort
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]>arr[j]){
                    //서로 값을 바꾼다
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        //출력
        for(int a:arr){
            System.out.print(a + "\t");
        }
    }
}
