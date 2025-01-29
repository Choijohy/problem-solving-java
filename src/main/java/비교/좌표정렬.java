package 비교;


import java.util.*;
import java.io.*;

public class 좌표정렬 {
  public static int[][] solution(int n, int[][] arr){
  	Arrays.sort(arr, new Comparator<int[]>(){
    	@Override
      	public int compare(int[] o1, int[] o2){
          	if(o1[0] > o2[0]) return 1;
          	else if (o1[0] < o2[0]) return -1;
          	else{
            	if(o1[1] > o2[1]) return 1;
          		else if (o1[1] < o2[1]) return -1;
            	else return 0;
            }
        }
    });
    return arr;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][2];

    for (int i=0;i<n;i++){
    	String[] s = br.readLine().split(" ");
      	arr[i][0] = Integer.parseInt(s[0]);
      	arr[i][1] = Integer.parseInt(s[1]);
    }
   	int[][] result = solution(n, arr);
    for (int i=0; i<n;i++){
        bw.append(String.valueOf(result[i][0])).append(" ").append(String.valueOf(result[i][1]));
        bw.newLine();
    }
    br.close();
    bw.flush();
    bw.close();
    return ;
  }
}