package 그리디.최소스패닝트리;


import java.util.*;
import java.io.*;

public class WonderLand2 {


  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int V = Integer.parseInt(str[0]);
    int E = Integer.parseInt(str[1]);

    int[][] graph = new int[V+1][V+1]; // 각 정점간 cost를 저장하기 위한 인접행렬
    for (int i=0; i<E; i++){
    	str = br.readLine().split(" ");
      	int s = Integer.parseInt(str[0]);
      	int e = Integer.parseInt(str[1]);
      	int cost = Integer.parseInt(str[2]);
      	graph[s][e] = cost;
        graph[e][s] = cost;
    }

    SolutionWonderLand2 solution = new SolutionWonderLand2(V,E,graph);
    System.out.println(solution.solution());

    return ;
  }
}

class SolutionWonderLand2{
  	private final int V; // 정점수
 	private final int E; // 간선수
  	private int answer = 0;
  	private int count = 0;
  	private final int[][] graph;
  	PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
  	int[] visited;

  	SolutionWonderLand2(int V, int E, int[][] graph){
      	this.V = V;
      	this.E = E;
      	this.graph = graph;
    	visited = new int[V+1];
    }

  	public  int solution(){
		  pq.offer(new int[]{1,0});
		  while(count < V && !pq.isEmpty()){
				int[] node = pq.poll();
				int v = node[0];
				if (visited[v] == 0){
					visited[v] = 1; //방문처리
					answer += node[1]; // 비용 추가
					count ++; //방문 정점 개수
					for (int i=1; i<=V;i++){
						if (visited[i] == 0  && graph[v][i] > 0) {
						  pq.offer(new int[]{i,graph[v][i]});
					}
				}
			}
	  	}
      return answer;
      }
}
