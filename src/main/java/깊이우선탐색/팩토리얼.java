package 깊이우선탐색;

import java.io.*;

public class 팩토리얼 {
    public static int bfs(int n){
        if (n == 1) return 1;
        return n* bfs(n-1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(bfs(n));
    }
}
