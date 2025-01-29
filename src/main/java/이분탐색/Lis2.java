package 이분탐색;

import java.util.*;
import java.io.*;

public class Lis2 {
    public static int[] arr;
    public static int[] dp;

    public static int solution(){
        int maxValue = 0;
        for (int i=0; i<arr.length; i++){
            int temp = getSubSequence(i);
            dp[i] = temp;
            maxValue = Math.max(maxValue, temp);
        }
        return maxValue;
    }
    public static int getSubSequence(int i){
        int maxValue = 0;
        for (int k=0; k<i; k++){
            if (arr[k] <= arr[i] && dp[k] > maxValue)
                maxValue = dp[k];
        }
        return maxValue+1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp  = new int[n];

        String[] s = br.readLine().split(" ");
        for (int i=0; i<n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println(solution());
        br.close();
    }
}

