package 깊이우선탐색;

import java.util.*;
import java.io.*;

public class 바둑이태우기 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int c = Integer.parseInt(str[0]);
    int n = Integer.parseInt(str[1]);
    int[] dogs = new int[n];
    for (int i=0; i<n;i++){
      dogs[i] = Integer.parseInt(br.readLine());
    }
    WeightCounter weightCounter = new WeightCounter(c,n,dogs);
    weightCounter.dfs(0,0);
    System.out.println(weightCounter.answer);
    return ;
  }
}

class WeightCounter{
	int c;
  	int n;
  	int[] dogs;
  	int answer;
  	int i;
    boolean stop;

  	WeightCounter(int c, int n, int[] dogs){
      this.c = c;
      this.n = n;
      this.dogs = dogs;
      answer = 0;
      i =0;
      stop = false;
    }

  	// 몇번째 바둑이까지 고려했는지(i), 현재까지 태운 무게(sum)
  	public void dfs(int i, int sum){
          if (sum > c) return;

          if (i == n || sum == c){
            answer = Math.max(answer, sum);
            return;
        }

        dfs(i+1, sum+dogs[i]); // i번째 바둑이를 태운 경우
        dfs(i+1, sum); // i번째 바둑이를 안 태운 경우

    }
}