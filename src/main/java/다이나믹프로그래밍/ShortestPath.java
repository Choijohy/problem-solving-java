package 다이나믹프로그래밍;

import java.util.*;
import java.io.*;

class ShortestPath{
    public static int solution(int destination, int n, Shortest[] paths, boolean[] exist){
        int[] dp = new int[destination+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int current = 2; current <= destination; current++){
            dp[current] = dp[current-1] +1;
            if (exist[current]){
                for (Shortest shortest:paths) {
                    if (current == shortest.e) {
                        dp[current] = Math.min(dp[current], dp[shortest.s] + shortest.d);
                    }
                }
            }
        }

        return dp[destination];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int destination = Integer.parseInt(info[1]);

        Shortest[] paths = new Shortest[n];
        boolean[] exist = new boolean[10001];
        for (int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            int e = Integer.parseInt(str[1]);
            exist[e] = true;
            paths[i] = new Shortest(Integer.parseInt(str[0]), e, Integer.parseInt(str[2]));
        }
        System.out.println(solution(destination, n, paths, exist));
    }

}

class Shortest implements Comparable<Shortest>{
    int s;
    int e;
    int d;

    Shortest(int s,int e, int d){
        this.s = s;
        this.e = e;
        this.d = d;
    }

    @Override
    public int compareTo(Shortest o){
        return this.e - o.e;
    }


}