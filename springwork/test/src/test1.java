import java.util.ArrayList;
import java.util.Scanner;

public class test1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("A의 값: ");
        int A = sc.nextInt();

        System.out.println("B의 값: ");
        int B = sc.nextInt();



        ArrayList<Integer> alist = new ArrayList<>();
        ArrayList<Integer> blist = new ArrayList<>();

        int count=10;
        int x=0;

        for (int i = 1; i < count; i++) {

            int c = A * i;
            alist.add(c);

            int d = B * i;
            blist.add(d);
        }


        while (true){
            for (int i = 0; i < alist.toArray().length; i++) {
                for (int j = 0; j < blist.toArray().length; j++) {

                    if(alist.get(i) == blist.get(j)){

                        x = alist.get(i);
                        break;
                    }
                }
            }
        }
        System.out.println(x);

    }
}
