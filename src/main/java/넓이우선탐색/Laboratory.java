package 넓이우선탐색;
/*
* 문제: 연구소
* 유형: 완탐 + DFS/BFS
* 공부:
*   시간복잡도 ->
*   벽 세우기 조합: 최대 64C2 <= 40000
*   BFS 격자판: O(N*M) = O(4V) = O(V)
* */
import java.io.*;
import java.util.*;

class Laboratory{
    public static int bfs(int N, int M, int[][] graph, Queue<int[]> virus){
        int[][] temp = new int[N][M];
        for (int i=0; i<N; i++){
            for (int j=0; j<M;j++){
                temp[i][j] = graph[i][j];
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.addAll(virus);
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int count = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll(); // 바이러스의 현재 위치
            for (int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if (nx>-1 && nx<N && ny>-1 && ny<M && temp[nx][ny]==0){
                    count++;
                    temp[nx][ny] = 2;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }

        return count;
    }
    public static int solution(
        int N, int M, int[][] graph, ArrayList<int[]> areas, Queue<int[]> virus)
    {
        int n = areas.size(); // 빈칸 총 개수
        int answer = 0; // 안전 영역 개수
        // 3개씩 랜덤하게 벽을 세우는 경우(완탐)
        for (int i=0; i<n;i++){
            int[] wall1 = areas.get(i);
            graph[wall1[0]][wall1[1]] = 1;
            for (int j=i+1; j<n;j++){
                int[] wall2 = areas.get(j);
                graph[wall2[0]][wall2[1]] = 1;
                for (int k=j+1; k<n; k++){
                    int[] wall3 = areas.get(k);
                    graph[wall3[0]][wall3[1]] = 1;

                    // 증식한 바이러스 수 구하기(bfs)
                    int count = bfs(N, M, graph, virus);
                    answer = Math.max(answer, n-3-count);
                    // System.out.println("벽1: ("+wall1[0]+","+wall1[1]+") 벽2: ("+wall2[0]+","+wall2[1]+") 벽3: ("+wall3[0]+","+wall3[1]+") => "+count);
                    graph[wall3[0]][wall3[1]] = 0;
                }
                graph[wall2[0]][wall2[1]] = 0;
            }
            graph[wall1[0]][wall1[1]] = 0;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        // 그래프 생성
        int[][] graph = new int[N][M]; // N:가로(행), M:세로(열)
        Queue<int[]> virus = new ArrayDeque<>(); // 바이러스 좌표
        ArrayList<int[]> areas = new ArrayList<>(); // 빈칸 좌표
        for (int i=0; i<N; i++){
            str = br.readLine().split(" ");
            for (int j=0; j<M; j++){
                int temp = Integer.parseInt(str[j]);
                graph[i][j] = temp;
                if (temp == 2) virus.offer(new int[]{i,j});
                else if (temp == 0) areas.add(new int[]{i,j});
            }
        }

        System.out.println(solution(N, M, graph, areas, virus));


        br.close();
    }
}