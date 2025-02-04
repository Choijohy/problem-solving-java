package 깊이우선탐색;


import java.util.*;
import java.io.*;

public class 동전교환 {

  public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
    String[] str = br.readLine().split(" ");
    int[] coins = new int[n];
    for (int i=0;i<n;i++){
    	coins[i] = Integer.parseInt(str[n-1-i]); // 시간복잡도를 위해 내림차순으로 탐색
    }
	int target = Integer.parseInt(br.readLine());

    CoinExchange coinExchange = new CoinExchange(n, target, coins);
    //coinExchange.dfs(0,0);
	coinExchange.bfs();
    System.out.println(coinExchange.answer);

    br.close();
    return ;
  }
}

class CoinExchange {
	int n;
  	int target;
  	int[] coins;
  	int answer = Integer.MAX_VALUE;
  	boolean stop;
	Queue<int[]> queue = new ArrayDeque<>(); // bfs

  	CoinExchange(int n, int target, int[] coins){
    	this.n = n;
      	this.target = target;
      	this.coins = coins;
      	stop = false;
    }

  	public void dfs(int count, int sum){
    	if (sum > target || count > answer) return; // 시간복잡도(무의미한 경로 cut)
		if (sum == target) {
          	answer = Math.min(answer, count);
        }
      	for (int i=0; i<n; i++){
        	dfs(count+1, sum + coins[i]);
        }
    }

	public void bfs(){
		  queue.offer(new int[] {0,0});

		  while (!queue.isEmpty()) {
			  int[] node = queue.poll();
			  int count = node[0];
			  int sum = node[1];
			  if (count > n){
				  answer = -1;
				  System.out.println("동전 교환 불가");
				  return;
			  }
			  if (sum == target) {
				  answer = count;
				  return;
			  }
			  for (int i = 0; i < n; i++) {
				  queue.offer(new int[]{count + 1, sum + coins[i]});
			  }
		  }
	}
}