package 다이나믹프로그래밍;


import java.util.*;
import java.io.*;

public class 순열구하기 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] str = br.readLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int r = Integer.parseInt(str[1]);
    int[][] mem = new int[n+1][r+1];

    PermutationCalculator permutationCalculator = new PermutationCalculator(n, r, mem);
    bw.append(String.valueOf(permutationCalculator.getPermutation()));

    br.close();
    bw.flush();
    bw.close();
    return ;
  }
}


class PermutationCalculator{
  	int n;
  	int r;
  	int[][] mem;

  	PermutationCalculator(int n, int r, int[][] mem){
    	this.n =n;
      	this.r =r;
      	this.mem =mem;
    }

	public int getPermutation(){
        if (n==1 || r ==0) return 1;

        mem[1][0] = 1;
    	mem[1][1] = 1;

        int i = 2;
      	while (i < n){
          	mem[i][0] = 1;

        	for (int j=1; j<r+1; j++){
            	mem[i][j] = mem[i-1][j-1] + mem[i-1][j];
            }
            i++;
        }
      	return mem[n-1][r-1] + mem[n-1][r];
    }
}