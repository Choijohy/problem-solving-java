package 깊이우선탐색;


import java.io.*;
import java.util.*;

public class 자율주행 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i=0; i<n;i++){
            String[] str = br.readLine().split(" ");
            for (int j=0; j<n;j++){
                System.out.print(str[j]+ " ");
                board[i][j] = Integer.parseInt(str[j]);
            }
            System.out.println();
        }

        Solution2 solution = new Solution2(n, board);
        List<Integer> result = solution.solution();
        Collections.sort(result);
        for (Integer x: result){
            bw.append(String.valueOf(x));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();

    }
}

class Solution2{
    int n;
    int[][] board;
    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};

    Solution2(int n, int[][] board){
        this.n = n;
        this.board = board;
    }

    public List<Integer> solution(){
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<n;i++){
            for (int j=0; j<n;j++){
                if (board[i][j] == 1){
                    board[i][j] = 0;
                    result.add(dfs(i,j));
                }
            }
        }
        return result;
    }

    public int dfs(int x, int y){
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > -1 && nx<n && ny >-1 && ny <n && (board[nx][ny] == 1)){
                board[nx][ny] = 0;
                return dfs(nx, ny) + 1;
            }
        }
        return 1;
    }
}