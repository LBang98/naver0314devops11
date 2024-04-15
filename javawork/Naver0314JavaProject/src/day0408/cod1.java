package day0408;

import java.util.List;


    public static void main(String[] args) {
        int answer = 0;
        int n = array.length / 2 + 1;
        int temp = 0;

        for(int i=0; i<=array.length; i++){

            for (int j=i+1; j<=array.length; j++){

                if(array[i] > array[j]){

                    temp = array[j];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        answer = array[n];


        return answer;
    }




