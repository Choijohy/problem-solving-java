package 투포인터;

import java.util.*;
import java.io.*;

public class BinarySearch {
  public static int binarySearch(int[] arr, int n, int m){
    int lt = 0;
    int rt = n-1;
    int mid = (lt + rt)/2;

    while (lt <=rt) {
        if (m == arr[mid]) return mid + 1;
        if (m > arr[mid]) {
            lt = mid + 1;
        } else {
            rt = mid - 1;
        }
        mid = (lt + rt) / 2;
    }
    return -1;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line1 = br.readLine().split(" ");

    int n = Integer.parseInt(line1[0]);
    int m = Integer.parseInt(line1[1]);

    int[] arr = new int[n];
	String[] line2 = br.readLine().split(" ");
    for (int i=0; i<n; i++){
    	arr[i]= Integer.parseInt(line2[i]);
    }

    Arrays.sort(arr);
	System.out.println(binarySearch(arr,n,m));
    return ;
  }
}
