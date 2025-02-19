package 투포인터;
/*
문제: 마구간 거리 구하기
카테고리: 이분탐색(결정 알고리즘)
기타:
    N(3<=N<=200,000), C(2<=C<=N)
    배열 정렬 -> O(NlogN)
    이분탐색 -> O(logX) (X: 가능한 거리 종류 개수)
    해당 거리로 배치가능한지 mid 마다 확인 -> O(N) (N:마구간 개수)
*/
import java.util.*;
import java.io.*;

public class MaximumStallDistance {
  public static boolean isPossible(int mid, int c, int[] stalls){
      int count = c-1; // 첫번째 마구간에 우선 배치
    int minDistance = stalls[0] + mid;
    for (int x: stalls){
		if (count == 0) break;
      	else if (x >= minDistance) {

          	count --;
        	minDistance = x + mid;
        }
     }

    if (count == 0) return true;
    else return false;
  }

  public static int solution(int n, int c, int[] stalls){
  	int lt = 1;
    int rt = stalls[n-1] - stalls[0];
    int answer = 0;
    while (lt <= rt){
    	int mid = (lt + rt)/2;
      	if (isPossible(mid, c, stalls)) {
          answer = mid;
          lt = mid +1;
        }
      	else rt = mid -1;
    }
    return answer;
  }

  public static void main(String[] args) throws IOException{
   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int c = Integer.parseInt(str[1]);

	int[] stalls = new int[n];
    str = br.readLine().split(" ");
    for (int i=0; i<n; i++){
    	stalls[i] = Integer.parseInt(str[i]);
    }

    Arrays.sort(stalls); // 마구간 좌표 오름차순 정렬
    System.out.println(solution(n, c, stalls));
    return ;
  }
}

