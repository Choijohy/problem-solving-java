package 투포인터;

import java.util.*;
import java.io.*;

public class 공통원소{
  public static ArrayList<Integer> solution(int[] a, int[] b){
  	Arrays.sort(a);
    Arrays.sort(b);
    int lengthA = a.length;
    int lengthB = b.length;
    ArrayList<Integer> answer = new ArrayList<>();
    int p1=0, p2 =0;

    while(p1 < lengthA && p2 <lengthB){
    	if (a[p1] == b[p2]){
        	answer.add(a[p1]);
          	p1++;
          	p2++;
        }
      	else if(a[p1] < b[p2])p1 ++;
       	else p2 ++;
    }
    return answer;

  }
  public static int[] getArray(BufferedReader br)throws IOException{
  	int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] s = br.readLine().split(" ");
    for (int i = 0; i<n;i++){
    	arr[i] = Integer.parseInt(s[i]);
    }
    return arr;
  }
  public static void main(String[] args) throws IOException{
   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] a = getArray(br);
    int[] b = getArray(br);

    for (int x: solution(a,b)){
    	bw.append(String.valueOf(x)+" ");
    }
    br.close();
    bw.flush();
    bw.close();
    return ;
  }
}