package 정렬;

/*
    문제: K번째 최대합 찾기
    카테고리: 자료구조(TreeSet)
    기타;
        - TreeSet: 중복 제거 + 정렬
*/

import java.util.*;
import java.io.*;

public class FindKthNumber {
    public static int solution(int n, int k, int[] cards){
        TreeSet<Integer> uniqueSums = new TreeSet<>(Collections.reverseOrder());

        // n <= 100으로, 딘순 삼중 for문으로 풀이 가능
        for (int i= 0; i<n; i++){
            for (int j= i+1; j<n; j++) {
                for (int l = j + 1; l < n; l++) {
                    uniqueSums.add(cards[i] + cards[j] + cards[l]);
                }
            }
        }

        int rank = 1;
        for (int x: uniqueSums){
            if (rank == k){
                return x;
            }
            rank++;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int k = Integer.parseInt(str[1]);
    int[] cards = new int[n];
    String[] temp = br.readLine().split(" ");
    for (int i=0; i<n; i++){
        cards[i] = Integer.parseInt(temp[i]);
    }

    System.out.println(solution(n,k,cards));

    br.close();
    }
}