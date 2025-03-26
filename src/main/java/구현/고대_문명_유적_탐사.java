package 구현;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

/*
문제: 고대문명 유적 탐사
유형: 시뮬레이션
공부:
    1) 우선순위 고려 잘못함: for문 순서는 "회전 -> 열 -> 행"이 되어야 한다.
    -> 문제 잘못 넘겨짚고, 열->행->회전으로함
    2) bfs탐색할때, temp 하나를 visited용으로 같이쓰는 문제
        -> 기본적으로 n^2을 전부 탐색하게 되기 때문에, 탐색 완료후에는 결과와 상관없이 temp가 전부 0으로 됨
    3) 회전시킬때,  temp[i][j] = grid[n-1-j] 방식 사용
    -> grid 전체에 대해서 전체적으로 회전할때 적용 가능
    -> 이 문제는 5*5에서 일부 3*3 격자만 회전시키기 때문에 grid의 행열 좌표를 그대로 사용하면서 위에처럼
    회전시키기 어려움. 예를 들어 (2,0)을 좌측 상단으로 가지는 3*3격자일 경우 위의 계산식 적용 안됨
    따라서 아래 코드처럼 9개를 하나하나 회전해줘야함.

*/
public class 고대_문명_유적_탐사 {
    static final int N = 5;
    static int K; // 탐사 횟수
    static int M; // 유물 개수
    static int[][] grid;
    static Queue<Integer> wall = new ArrayDeque<>();
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static ArrayList<Integer> answer = new ArrayList<>();

    private static void fill(int[][] board, Queue<Integer> wall){
        for (int col=0; col<N; col++){
            for (int row=N-1;row >=0;row--){
                if(board[row][col] == 0) {
                    int cur = wall.poll();
                    board[row][col] = cur;
                    wall.offer(cur);
                }
            }
        }
    }

    private static int bfs(int x, int y, int[][] temp, boolean[][] visited){
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> trace = new ArrayDeque<>();

        queue.add(new int[]{x,y});
        trace.add(new int[]{x,y});

        int count = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int k=0; k<4; k++){
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx>-1 && nx<N && ny>-1 && ny<N && (temp[x][y] == temp[nx][ny])
                    && (visited[nx][ny] == false)){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny});
                    trace.add(new int[]{nx,ny});
                    count ++;
                }
            }
        }
        if (count >=3){
            while(!trace.isEmpty()){
                int[] cur = trace.poll();
                temp[cur[0]][cur[1]] = 0;
            }
        }
        return count;
    }
    private static int explore(int[][] temp){
        boolean[][] visited = new boolean[N][N];

        // 유물 탐색
        int sum = 0;
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (visited[i][j] == false){
                    visited[i][j] = true;
                    int count = bfs(i,j,temp,visited);
                    if (count >=3) sum += count;
                }
            }
        }
        // System.out.println(sum);
        return sum;
    }
    private static int[][] rotate(int r, int c, int count){
        // r: 좌측 상단 행, c: 좌측 상단 열
        int[][] rotated = new int[N][N];

        for (int i=0; i< N; i++){
            for (int j=0;j<N;j++){
                rotated[i][j] = grid[i][j];
            }
        }

        for (int i=0; i<count;i++){
            int temp = rotated[r+0][c+2];
            rotated[r+0][c+2] = rotated[r+0][c+0];
            rotated[r+0][c+0] = rotated[r+2][c+0];
            rotated[r+2][c+0] = rotated[r+2][c+2];
            rotated[r+2][c+2] = temp;

            temp = rotated[r+1][c+2];
            rotated[r+1][c+2] = rotated[r+0][c+1];
            rotated[r+0][c+1] = rotated[r+1][c+0];
            rotated[r+1][c+0] = rotated[r+2][c+1];
            rotated[r+2][c+1] = temp;
        }
        return rotated;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[5][5];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<M; i++){
            wall.offer(Integer.parseInt(st.nextToken()));
        }

        for (int time = 0; time<K;time++){
            int[][] maxBoard = new int[N][N];
            boolean flag = false;

            int maxSum = 0;
            // 3*3 격자 선택
            for (int rotation=1; rotation<=3; rotation++){
                for (int c=0;c<=2;c++){
                    for (int r=0;r<=2;r++){
                        int[][] temp = rotate(r,c,rotation);
                        //System.out.println((rotation+1)+"번 째 회전");

                        int count = explore(temp);
                        if(count>maxSum){
                            flag = true;
                            maxSum = count;
                            for (int i=0; i<N;i++){
                                for (int j=0; j<N; j++){
                                    maxBoard[i][j] = temp[i][j];
                                }
                            }
                        }
                    }
                }
            }

            if (flag == false) break;

            // for (int i=0; i<N;i++){
            //         for (int j=0; j<N; j++){
            //             System.out.print(maxBoard[i][j]+ " ");
            //         }
            //         System.out.println();
            //     }
            // 3*3격자가 정해진 경우 -> 연쇄 획득
            for (int i=0; i<N;i++){
                for (int j=0; j<N; j++){
                    grid[i][j] = maxBoard[i][j];
                }
            }

            while(true){
                // 유물 채우기
                fill(grid,wall);
                int count = explore(grid);
                if (count == 0) break;
                maxSum+=count;
            }
            answer.add(maxSum);
        }
        for (int x: answer){
            System.out.print(x+" ");
        }

    }
}
