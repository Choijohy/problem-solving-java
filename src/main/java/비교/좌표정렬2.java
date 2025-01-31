package 비교;

import java.util.*;
import java.io.*;

public class 좌표정렬2 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Point[] arr = new Point[n];

    for (int i=0; i<n; i++){
    	String[] s = br.readLine().split(" ");
      	int a = Integer.parseInt(s[0]);
      	int b = Integer.parseInt(s[1]);
      	arr[i] = new Point(a,b);
    }

	Arrays.sort(arr);
    for (Point x: arr){
    	bw.append(String.valueOf(x.a)).append(" ").append(String.valueOf(x.b));
        bw.newLine();
    }

    br.close();
    bw.flush();
    bw.close();
    return ;
  }
}

class Point implements Comparable<Point>{
    int a;
    int b;

  	Point(int a, int b){
    	this.a = a;
      	this.b = b;
    }

    @Override
    public int compareTo(Point o){
    	if (this.a == o.a) return this.b - o.b;
      	else return this.a - o.a;
    }
  }