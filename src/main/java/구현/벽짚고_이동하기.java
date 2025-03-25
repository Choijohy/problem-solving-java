package 구현;

import java.util.*;
import java.io.*;
/*
문제: 벽 짚고 미로 탈출
유형: 시뮬레이션
공부:
    - 테스트케이스
        1) 하나의 벽을 짚고 빙빙 도는 경우
        2) 출발점이 사방으로 벽에 갇힌 경우
        3) 격자 밖으로 탈출
        4) 삼면이 벽으로 둘러쌓인 공간을 들어갔다가 탈출하는 경우
    - dx,dy 테크닉(시계,반시계 따로 만들 필요 없음)
        시계 방향: (curDir + 1)%4
        반시계 방향: (curDir -1 + 4) %4 -> 결국 오른쪽으로 3칸 이동
    - 범위 밖인지 헷갈리면, 움직일때마다 그냥 체크해주기(해설)
*/

public class 벽짚고_이동하기 {
    static int n;
    static int x;
    static int y;
    static int curDir = 0;
    static char[][] maze;
    static boolean[][][] visited;
    static boolean flag;
    static int count = 0;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    private static int turn(){
        return (curDir+1)%4;
    }
    private static int turnReverse(){
        return (curDir -1 +4)%4;
    }
    private static void simulate(){
        if (visited[x][y][curDir]==true) {
            flag = true;
            count = -1;
            return;
        }

        visited[x][y][curDir] = true;

        int nx = x + dx[curDir];
        int ny = y + dy[curDir];

        if (nx < 0 || nx >=n || ny <0 || ny >= n){
            flag = true;
            count ++;
            return;
        }

        if (maze[nx][ny] == '#'){
            curDir = turnReverse();
        }
        else{
            int tempDir = turn();
            int rx = nx + dx[tempDir];
            int ry = ny + dy[tempDir];

            if (rx < 0 || rx >=n || ry <0 || ry >= n){
                flag = true;
                return;
            }
            if (maze[rx][ry]=='#'){
                x = nx;
                y = ny;
                count++;
            }
            else {
                x = rx;
                y = ry;
                curDir = tempDir;
                count +=2;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken())-1;
        y = Integer.parseInt(st.nextToken())-1;

        maze = new char[n][n];
        visited = new boolean[n][n][4];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j);
            }
        }

        while(!flag){
            simulate();
        }
        System.out.println(count);
    }
}