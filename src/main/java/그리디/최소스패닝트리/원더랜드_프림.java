package 그리디.최소스패닝트리;
/*
* 문제: 원더랜드
* 유형: 그리디, mst, prim 알고리즘
* 기타:
*   - 틀린 케이스: 기존 코드에서는 while문의 정지 조건으로 "현재 노드에서 더 이상 전진가능한 노드가 없는가?"를 판단함
*   -> 이는 1,2,3 까지 방문하고, 실제 pq에 5,6 등의 다음 정점이 있음에도,
*   만약 4를 방문하고 더이상 전진가능 노드가 없으면 while문을 종료시켜버림(dfs에서, 다음 자식들에 대해서도 탐색이 진행되어야하는데
*   첫번째 자식 탐색 끝났나고 2,3번째 자식 탐색 안 하는 느낌)
* */
import java.util.*;
import java.io.*;

public class 원더랜드_프림 {
  public static void main(String[] args) throws IOException{
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int v = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());

    int[][] grid = new int[v+1][v+1];
    for (int i=0; i<e; i++){
    	st = new StringTokenizer(br.readLine());
      	int v1 = Integer.parseInt(st.nextToken());
      	int v2 = Integer.parseInt(st.nextToken());
      	int cost = Integer.parseInt(st.nextToken());
      	grid[v1][v2] = cost;
      	grid[v2][v1] = cost;
    }
    boolean[] visited = new boolean[v+1];
    PriorityQueue<MovingCost> pq = new PriorityQueue<>();
    pq.offer(new MovingCost(1,0));

    boolean flag = true;
    int sum = 0;
    int count = 0;
    while(count < v && !pq.isEmpty()){
    	MovingCost cur = pq.poll();
      	int city = cur.city;
      	int cost = cur.cost;

        if (visited[city]) continue;

        System.out.println("도시: "+city+"비용: "+cost);

        sum += cost;
      	visited[city] = true;
      	count ++;
      	for (int i=1; i<=v; i++){
        	if(grid[city][i] > 0 && !visited[i]){
            	pq.offer(new MovingCost(i, grid[city][i]));
            }
        }
    }

    System.out.println(sum);
    return ;
  }
}

class MovingCost implements Comparable<MovingCost>{
	int city;
  	int cost;

  	MovingCost(int city, int cost){
    	this.city = city;
      	this.cost = cost;
    }

  	@Override
    public int compareTo(MovingCost o){
    	return this.cost - o.cost;
    }

}