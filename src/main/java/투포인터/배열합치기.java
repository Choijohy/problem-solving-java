package 투포인터;
/*
문제: 배열 오름차순으로 합치기
카테고리: 투포인터
기타:
  - Arrays.sort() : O(nlogn)
*/

import java.util.*;
import java.io.*;

public class 배열합치기 {
      public static int[] getArray(BufferedReader br) throws IOException{
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] s = br.readLine().split(" ");
            for (int i=0; i<n;i++){
                arr[i] = Integer.parseInt(s[i]);
            }
        return arr;
      }

      public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] a = getArray(br);
        int[] b = getArray(br);

        Solution2 solution = new Solution2(a,b);
        int[] result = solution.solution();
        for (int i=0; i< result.length;i++){
            bw.append(String.valueOf(result[i]+" "));
        }

        br.close();
        bw.flush();
        bw.close();
        return ;
      }

}

class Solution2{
  	int n;
  	int m;
    int[] a;
    int[] b;
  	int[] answer;
	Solution2(int[] a, int[] b){
      	this.n = a.length;
      	this.m = b.length;
        this.a = a;
        this.b = b;
    	this.answer = new int[n+m];
    }

  	public int[] solution(){
    	int p1 = 0;
     	int p2 = 0;
      	int i = 0;
      	while (p1<this.n && p2<this.m){
        	if(this.a[p1] <= this.b[p2]){
            	this.answer[i] = this.a[p1];
              	p1 ++;
            } else {
            	this.answer[i] = this.b[p2];
              	p2 ++;
            }
          	i++;
        }

      	if (p1 < this.n){
        	for (int k=p1; k<this.n;k++){
            	this.answer[i] = this.a[k];
              	i++;
            }
        }else if(p2 < this.m){
          for (int k=p2; k<this.m;k++){
          	this.answer[i] = this.b[k];
            i++;
          }
        }
      return answer;
    }
}


