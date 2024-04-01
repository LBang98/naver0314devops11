package day0401;

public class ss {
    class Solution {
        public int[] solution(int n) {
            int[] answer = {};

            answer = new int[n];
            int j = 1;

            for(int i=0; i<=n; i++){
                answer[i] = j;
                j += 2;
            }


            return answer;
        }
    }
    public static void main(String[] args) {


    }
}
