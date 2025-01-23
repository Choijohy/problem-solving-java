package 백트래킹;

import java.io.*;

public class NQueen{
    public static void main(String[] argas) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Solution solution = new Solution(n);
        int answer = solution.solution();
        System.out.println(answer);
    }
}

class Solution{
    int[] queens; // 퀸 말이 놓인 위치-> 인덱스는 해당 말이 놓인 '행', 인덱스에 해당하는 값은 '열'을 의미
    int count = 0;
    int n;

    Solution(int n){
        this.n = n;
        this.queens = new int[n];
        for (int i=0; i<n;i++){
            queens[i] = -1;
        }
    }
    public int solution(){
        for (int i=0; i<this.n;i++){
            queens[0] = i;
            dfs(0,i);
            queens[0] = -1;
        }
        return count;
    }
    public void dfs(int row, int col){
        if (validator(row, col)){ // 적합한 해일 경우
            if (row == this.n-1){ // 최대 깊이 노드일 경우
                this.count ++;
                return;
            } else{
                for (int i=0; i<this.n;i++){ // 더 탐색 가능한 노드가 있을 경우
                    this.queens[row+1] = i;
                    dfs(row+1, i);
                    this.queens[row+1] = -1;
                }
            }
        }
    }

    public boolean validator(int row, int col){
        // 같은 열 or 대각선에 퀸이 존재하는지 체크
        // 같은 행은 dfs() 호출 과정에서부터 겹치지 않도록 하므로 별도로 체크 x
        for (int i=0; i < row; i++){
            if (this.queens[i] == col) return false; // 열
            if (Math.abs(col-queens[i]) == Math.abs(row - i)) return false; // 대각선
        }

        return true;
    }
}