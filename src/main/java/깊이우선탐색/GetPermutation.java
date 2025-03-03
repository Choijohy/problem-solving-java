package 깊이우선탐색;
/*
문제: 순열 구하기
유형: DFS
공부:
    1) DFS 중단 조건:
        1. 더이상 탐색할 경로가 없거나 (경로 찾기)
        2. 최대 깊이에 도달했거나 (L을 파라미터로 전달)
    2) 조합 nCr = n-1Cr-1 + n-1Cr
*/
import java.io.*;

public class GetPermutation {
  static int[] ch;
  static int[] arr;
  static int[][] mem;
  static boolean flag = false;

  public static void dfs(int F, int N, int L, int sum){
  	if (sum > F || flag) return;
    if (L == N){
    	if (sum == F) {
          flag = true;
        }
    }else{
    	for (int i=1; i<=N; i++){
        	if (ch[i] == 0){
                if (flag) return;
            	arr[L] = i;
              	ch[i] = 1;
              	dfs(F,N,L+1, sum + arr[L]*mem[N-1][L]);
              	ch[i] = 0;
            }
        }
    }
  }

  public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    mem = new int[10][10];
    mem[1][0] = 1;
    mem[1][1] = 1;

    String[] str = br.readLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int F = Integer.parseInt(str[1]);

    // 조합 메모이제이션
    for (int i=2; i<N;i++){
    	for(int j=0;j<N;j++){
        	if (j==0||i==j) mem[i][j] = 1;
          	else mem[i][j] = mem[i-1][j-1]+mem[i-1][j];
        }
    }

    arr = new int[N];
    ch = new int[N+1];


    dfs(F,N,0,0);
    for (int i=0; i<N;i++){
    	bw.append(String.valueOf(arr[i])).append(" ");
    }


    br.close();
    bw.flush();
    bw.close();
    return ;
  }
}