package 그리디;

import java.io.*;
import java.util.*;

public class 젤다 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> answer = new ArrayList<>();
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        int count = 1;
        while(true){
            int n = Integer.parseInt(br.readLine());
            if (n==0) break;

            // 격자 채우기
            int[][] grid = new int[n][n];
            for (int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++){
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<RupeeSteal> pq = new PriorityQueue<>();
            pq.offer(new RupeeSteal(0,0,grid[0][0]));

            // 최소로 잃는 루피 저장
            int[][] arr = new int[n][n];

            for (int i=0;i<n;i++){
                Arrays.fill(arr[i],Integer.MAX_VALUE);
            }
            boolean[][] visited = new boolean[n][n];

            while(!pq.isEmpty()){
                RupeeSteal cur = pq.poll();
                int x = cur.x;
                int y = cur.y;
                visited[x][y] = true;
                arr[x][y] = Math.min(arr[x][y], cur.cost);
                if (x == n-1 && y == n-1) {
                    break;
                }
                for (int i=0; i<4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx > -1 && nx <n && ny >-1 && ny < n && !visited[nx][ny]){
                        pq.offer(new RupeeSteal(nx,ny,cur.cost+grid[nx][ny]));
                    }
                }
            }
            System.out.println("Problem "+count+": "+arr[n-1][n-1]);
            count++;
        }
    }
}

class RupeeSteal implements Comparable<RupeeSteal> {
    int x;
    int y;
    int cost;

    RupeeSteal(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(RupeeSteal o){
        return this.cost - o.cost;
    }


}