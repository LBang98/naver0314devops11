package day0321;

public class Ex3_ArrayStringSort {
    public static void main(String[] args) {

        String[] arr = {"하석진", "강호동", "강호마", "Candy", "손석구"};
        //정렬
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){

                //기준값이 더 클 경우 양수값이 발생
                if(arr[i].compareTo(arr[j]) > 0){
                    String stemp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = stemp;
                }
            }
        }
        System.out.println("** 순서대로 출력하기 **");
        for(int i=0; i<arr.length; i++)
            System.out.print("\t" + arr[i]);
    }
}
