package 자료형.array;

/*
문제: 임시반장 정하기
카테코리: 배열
기타: 같은 반이 2번이었더라도, +1 처리만 되어야 한다
* */
import java.io.*;

public class TemporalLeader {
    public static int solution(int n, int[][] arr){
        int maxValue =0;
        int answer =1;
        for (int i=1; i<n+1;i++){
            int count = 0;
            for(int j=1;j<n+1;j++){
                for (int k=1;k<6;k++){
                    if (arr[i][k] == arr[j][k]) {
                        count++;
                        break;
                    }
                }

            }
            if (maxValue < count) {
                answer = i;
                maxValue = count;
            }
        }
        return answer;
    }
  public static void main(String[] args) throws IOException{
   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] arr = new int[n+1][6];

    for (int i=1;i<n+1;i++){
      String[] s = br.readLine().split(" ");
    	for (int j=1;j<6;j++){
          	arr[i][j] = Integer.parseInt(s[j-1]);;
        }
    }

    System.out.println(solution(n, arr));
    return ;
  }
}