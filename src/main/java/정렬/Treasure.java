package 정렬;

import java.io.*;
import java.util.*;

class Treasure{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] arrayA = new Integer[n];
        Integer[] arrayB = new Integer[n];
        ArrayList<Number> arrayDetails = new ArrayList<>();

        String[] strA = br.readLine().split(" ");
        for (int i=0; i < strA.length; i++){
            arrayA[i] = Integer.parseInt(strA[i]);
        }

        String[] strB = br.readLine().split(" ");
        for (int i=0; i < strB.length; i++){
            arrayB[i] = Integer.parseInt(strB[i]);
        }

        // 배열A 오름차순 정렬
        Arrays.sort(arrayA);

        // 배열B 내림차순 정렬
        // Collections.sort(arrayDetails, Collections.reverseOrder());
        Arrays.sort(arrayB, Collections.reverseOrder());

        // 배열B의 가장 큰 값이 존재하는 위치부터, A의 작은 값을 위치 시킨다.
        int result = 0;
        for (int i=0; i<n; i++){
            int num1 = arrayA[i];
            int num2 = arrayB[i];
            result += (num1 * num2);

        }
        System.out.println(result);
    }

}

class Number implements Comparable<Number>{
    int value;
    int index;

    Number(int value, int index){
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Number o){
        return this.value - o.value;
    }


}