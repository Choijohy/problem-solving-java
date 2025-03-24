package 깊이우선탐색;


import java.util.*;
import java.io.*;

public class 윳놀이 {
    static int n;
    static int m;
    static int k;
    static int[] nums;
    static int[] scores;
    static int answer = 0;

    private static void dfs(int L){
        if (L==n){
            int count = 0;
            for(int i=0;i<k;i++){
                if (scores[i]>= m) count++;
            }
            answer = Math.max(answer, count);
            return;
        }

        for (int i=0; i<k; i++){
            scores[i] += nums[L];
            dfs(L+1);
            scores[i] -= nums[L];
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        scores = new int[k];
        Arrays.fill(scores, 1);
        dfs(0);
        System.out.println(answer);
    }
}
