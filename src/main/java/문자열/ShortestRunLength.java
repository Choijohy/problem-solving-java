package 문자열;

import java.util.*;
import java.io.*;

public class ShortestRunLength {
    static String str;
    static int size;
    static int answer = 20;

    private static String shift(int n){
        char[] shifted = str.toCharArray();
        for (int i=0; i<n; i++){ // n: shift 횟수
            char temp = shifted[size-1];
            for (int j=size-1; j>0; j--){
                shifted[j] = shifted[j-1];
            }
            shifted[0] = temp;
        }

        return new String(shifted);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        size = str.length();

        // shift 횟수 완전 탐색 (0 ~ size-1)
        // for (int i=0;i<size;i++){
        //     String shifted = shift(i);
        //     StringBuilder sb = new StringBuilder();

        //     char prev = shifted.charAt(0);
        //     int count = 1;
        //     for (int j=1; j<size; j++){
        //         if (prev == shifted.charAt(j)){
        //             count ++;
        //         }else{
        //             sb.append(prev).append(String.valueOf(count));
        //             count = 1;
        //             prev = shifted.charAt(j);
        //         }
        //     }
        //     sb.append(prev).append(String.valueOf(count));
        //     String result = sb.toString();

        //     //System.out.println(result);
        //     answer = Math.min(answer, result.length());
        // }

        for (int i=0;i<size;i++){
            str = str.substring(size -1) + str.substring(0, size-1);

            StringBuilder sb = new StringBuilder();

            char prev = str.charAt(0);
            int count = 1;
            for (int j=1; j<size; j++){
                if (prev == str.charAt(j)){
                    count ++;
                }else{
                    sb.append(prev).append(String.valueOf(count));
                    count = 1;
                    prev = str.charAt(j);
                }
            }
            sb.append(prev).append(String.valueOf(count));
            String result = sb.toString();

            //System.out.println(result);
            answer = Math.min(answer, result.length());
        }
        System.out.println(answer);
    }
}