package 넓이우선탐색;
/*
문제: 상범빌딩
유형: 최단거리(BFS)
공부:
    1) 좌표값 0,1,9 3가지 -> 큐에 넣을때 1로 방문처리하는게 문제(9인 경우가 1로 바뀌어버려, 탈출구를 알 수 없음)
    2) 3차원 배열(층, 행, 열)
 */

/
import java.io.*;
import java.util.*;

public class SangBumBuilding{
    public static class Location{
        int floor;
        int row;
        int col;

        Location(int floor, int row, int col){
            this.floor = floor;
            this.row = row;
            this.col = col;
        }
    }

    public static int solution(int L, int R, int C, int[][][] building, Location S){
        Queue<Location> queue = new ArrayDeque<>();
        queue.offer(S);
        int[] dx = {0,0,0,0,-1,1};
        int[] dy = {0,0,1,-1,0,0};
        int[] df = {1,-1,0,0,0,0};

        int answer = -1;
        while (!queue.isEmpty()){
            answer ++;
            int size = queue.size();
            for (int i=0; i<size;i++){
                Location cur = queue.poll();
                // 아니라면, 새로운 경로 추가
                // 층 이동
                for (int j=0; j<6;j++){
                    int nextFloor = cur.floor + df[j];
                    int nextRow = cur.row + dx[j];
                    int nextCol = cur.col + dy[j];
                    if (nextFloor > -1 && nextFloor < L &&
                        nextRow > -1 && nextRow < R &&
                        nextCol > -1 && nextCol < C && building[nextFloor][nextRow][nextCol] != 1)
                    {
                        if ( building[nextFloor][nextRow][nextCol] == 9) return answer+1;
                        else building[nextFloor][nextRow][nextCol] = 1;
                        queue.offer(new Location(nextFloor, nextRow, nextCol));

                    }
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] str = br.readLine().split(" ");
            int L = Integer.parseInt(str[0]);
            int R = Integer.parseInt(str[1]);
            int C = Integer.parseInt(str[2]);

            if (L==0 && R==0 && C==0) break;
            int[][][] building = new int[L][R][C];
            Location S = null;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    str = br.readLine().split("");
                    for (int k = 0; k < C; k++) {
                        if (str[k].equals("S")) {
                            S = new Location(i, j, k);
                            building[i][j][k] = 1;
                        } else if (str[k].equals("#")) {
                            building[i][j][k] = 1;
                        } else if (str[k].equals("E")) {
                            building[i][j][k] = 9;
                        }

                    }
                }
                str = br.readLine().split("");
            }
            int answer = solution(L,R,C,building,S);
            if (answer == -1)System.out.println("Trapped!");
            else System.out.println("Escaped in "+answer+" minute(s).");
        }
        br.close();
    }




}
