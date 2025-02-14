package 정렬;

import java.util.*;
import java.io.*;

public class BubbleSort {
  public static int[] bubbleSort(int n, int[] arr){
  	for (int i=n; i>=1; i--){
      	int index = 0;
    	for (int j=0; j < i; j++){
        	if (arr[index] > arr[j]){
            	int tmp = arr[index];
              	arr[index] = arr[j];
              	arr[j] = tmp;
            }
        	index = j;
        }
    }
    return arr;
  }
  public static void main(String[] args) throws IOException{
   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());


    String[] str = br.readLine().split(" ");
    int[] arr = new int[n];
    for (int i=0; i<n; i++){
    	arr[i] = Integer.parseInt(str[i]);
    }

    int[] result = bubbleSort(n, arr);
    for (int i=0; i<n; i++){
    	System.out.print(result[i]+" ");
    }
    return ;
  }
}