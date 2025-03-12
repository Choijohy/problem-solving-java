package 넓이우선탐색;
/*
* 문제: 경쟁적 전염
* 유형: 정렬 + BFS
* 공부:
*   케이스
*   1) S=0일때(엣지 케이스)
*   2) 입력이 숫자가 높은 바이러스부터 주어질때
*   3) x초에 맨 마지막 바이러스가 퍼지는 구역이 정답으로 나와야 할 때 (-> count ==S 체크를 잘못된 위치에 둬서 실수로 틀렸음)
* */

import java.io.*;
import java.util.*;

class VirusSpreadCompetition{
    public static void spreadVirus(List<Virus> viruses, int N, int[][] graph, int S){
        Queue<Virus> queue = new ArrayDeque<>();
        // 시작 노드(번호 낮은 순서부터)
        for (Virus x: viruses){
            queue.offer(x);
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        int count = 0;
        // 바이러스 증식
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                Virus cur = queue.poll();
                for (int j=0; j<4; j++){
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx>0 && nx <=N && ny>0 && ny<=N && graph[nx][ny] == 0){
                        graph[nx][ny] = cur.type;
                        queue.offer(new Virus(cur.type, nx, ny));
                    }
                }
            }
            count ++;
            if (count == S) return;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int[][] graph = new int[N+1][N+1];
        List<Virus> viruses = new ArrayList<>();
        for (int i=1; i<=N; i++){
            str = br.readLine().split(" ");
            for (int j=1; j<=N;j++){
                int temp = Integer.parseInt(str[j-1]);
                graph[i][j] = temp;
                if (temp != 0) viruses.add(new Virus(temp,i,j));
            }
        }
        str = br.readLine().split(" ");
        int S = Integer.parseInt(str[0]);
        int targetX = Integer.parseInt(str[1]);
        int targetY = Integer.parseInt(str[2]);
        Collections.sort(viruses);

        // 바이러스 증식
        if (S>0) spreadVirus(viruses, N, graph, S);

        // S초후의 x,y의 결과
        System.out.println(graph[targetX][targetY]);
        br.close();
    }
}
class Virus implements Comparable<Virus>{
    int type;
    int x;
    int y;
    Virus(int type, int x, int y){
        this.type = type;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Virus o){
        return this.type - o.type;
    }
}