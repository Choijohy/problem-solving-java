package 최소스패닝트리;


import java.io.*;

public class FriendChecker {
    static int[] arr;
  	public static int find(int v){
		if (arr[v] == v) return arr[v];
    	else return arr[v] = find(arr[v]);
	}

	public static void union(int a, int b){
		int rootA = find(a);
  		int rootB = find(b);

  		if (rootA != rootB) arr[rootA] = rootB;
	}

  	public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] str = br.readLine().split(" ");
      int n = Integer.parseInt(str[0]); // 학생수
      int m = Integer.parseInt(str[1]); // 숫자쌍

      // 학생별 최초 집합
      arr = new int[n+1];
      for (int i=1; i<=n; i++) arr[i] = i;

      for (int i= 0; i<m;i++){
      	String[] pair = br.readLine().split(" ");
        union(Integer.parseInt(pair[0]),Integer.parseInt(pair[1]));
      }

      String[] question = br.readLine().split(" ");
      if (find(Integer.parseInt(question[0])) == find(Integer.parseInt(question[1]))) System.out.println("YES");
      else  System.out.println("NO");

      return ;
  }
}
