package 넓이우선탐색;

import java.io.*;
import java.util.*;

public class CoinExchanger {

    public static int solution(int[] coins, int n, int m){
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i=0; i<n; i++){
            queue.offer(coins[i]);
        }

        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            for (int i=0; i<size;i++){
                int sum = queue.poll();
                for (int j=0; j<n; j++){
                    if (sum == m){
                        return count;
                    }
                    if (sum+coins[j] <= m) queue.offer(sum+coins[j]);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str= br.readLine().split(" ");
        int[] coins = new int[n];
        for (int i=0; i<n; i++){
            coins[i] = Integer.parseInt(str[i]);
        }
        int m = Integer.parseInt(br.readLine());
        System.out.println(solution(coins, n, m));
    }
}
