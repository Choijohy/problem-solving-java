package 그리디.최소스패닝트리;

import java.util.*;
import java.io.*;

/*
문제: 최소스패닝트리(모든 정점 포함하는 부분 트리중 최소의 가중치를 가지는 트리)
카테고리: Union & Find를 활용한 크루스칼 알고리즘. 그리디
*/
public class WonderLand {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int V = Integer.parseInt(str[0]); // 정점(도시) 수
    int E = Integer.parseInt(str[1]); // 간선 수

    List<Path> paths = new ArrayList<>();
    for (int i=0; i< E; i++){
    	String[] path = br.readLine().split(" ");
      	paths.add(new Path(Integer.parseInt(path[0]), Integer.parseInt(path[1]), Integer.parseInt(path[2]))); // s,e, cost
    }

    Collections.sort(paths);
    SolutionWonderLand solution = new SolutionWonderLand(V, paths);
    System.out.println(solution.solution());

    return ;
  }
}

class SolutionWonderLand{
  int n; // 정점(도시) 수
  List<Path> paths;
  int[] arr; // 도시별 root노드(속한 집합) 저장용

  SolutionWonderLand(int n, List<Path> paths){
  	this.n = n;
    this.paths = paths;
    arr = new int[n+1];
    for (int i=1; i<=n; i++){
    	arr[i] = i;
    }
  }

  public int find(int v){
  	if (v == arr[v]) return arr[v];
    else return arr[v] = find(arr[v]);
  }

  public void union(int fe, int fs){
  	arr[fe] = fs;
  }

  public int solution(){
    int answer = 0;
    int cnt = 0;
  	for (Path x: paths){
      	if (cnt == n-1) break;
    	int fs = find(x.s);
      	int fe = find(x.e);
      	if (fs != fe) {
          union(fs,fe);
          answer += x.cost;
          cnt ++;
        }
    }
    return answer;
  }
}

class Path implements Comparable<Path>{
	int s;
  	int e;
  	int cost;

  	Path(int s, int e, int cost){
    	this.s = s;
      	this.e = e;
      	this.cost = cost;
    }

  	@Override
  	public int compareTo(Path o){
    	return this.cost - o.cost;
    }

}