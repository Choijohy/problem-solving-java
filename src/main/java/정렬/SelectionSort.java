package 정렬;

import java.util.*;
import java.io.*;

public class SelectionSort {
  public static int[] selectionSort(int n, int[] arr){
  	for (int i=0; i<n; i++){
      	int selectionIndex = i;
    	for (int j=i; j<n;j++){
        	if (arr[j] < arr[selectionIndex]){
                selectionIndex = j;
            }
        }
      	int tmp = arr[i];
      	arr[i] = arr[selectionIndex];
      	arr[selectionIndex] = tmp;
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
    int[] result = selectionSort(n, arr);
    for (int i=0; i<n; i++){
    	System.out.print(result[i]+" ");
    }
    return ;
  }
}