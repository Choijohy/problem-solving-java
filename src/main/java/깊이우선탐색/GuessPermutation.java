package 깊이우선탐색;

import java.io.*;

public class GuessPermutation {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int f = Integer.parseInt(str[1]);

        Solution_GuessPermutation solution = new Solution_GuessPermutation(n,f);
        solution.dfs(0,0);

    }
}

class Solution_GuessPermutation{
    int n;
    int f;
    int[] b, p, ch;
    int[][] mem;
    boolean flag = false;

    Solution_GuessPermutation(int n, int f){
        this.n = n;
        this.f = f;
        b = new int[n];
        p = new int[n];
        ch = new int[n+1];
        mem = new int[n][n];
        // 조합 결과 메모이제이션
        for (int i=0; i<n; i++){
            b[i] = getCombination(n-1, i);
        }

    }

    private int getCombination(int n, int r){
        if (mem[n][r] > 0) return mem[n][r];
        if (n==r || r==0) return 1;
        else return mem[n][r] = getCombination(n-1, r-1) + getCombination(n-1,r);
    }

    public void dfs(int L, int sum){
        if (flag) return;
        if (L == n) {
            if (sum == f){
                for (int x : p) System.out.print(x+ " ");
                flag = true;
            }
        }
        else{
            for (int i=1; i<=n ; i++){
                if (ch[i] ==0){
                    ch[i] = 1;
                    p[L] = i;
                    dfs(L+1, sum+(p[L]*b[L]));
                    ch[i] = 0;
                }
            }
        }
    }


}