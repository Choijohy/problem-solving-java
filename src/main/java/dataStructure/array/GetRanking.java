package dataStructure.array;

import java.util.*;

public class GetRanking {
    public static int[] solution(int num, int[] scores){
        int[] result = new int[num];
        for (int i=0; i<num; i++){
            int count = 0;
            int current = scores[i];
            for (int j=0; j<num;j++){
                if (scores[j] > current) count ++;
            }
            result[i] = count+1;
        }
        return result;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num = in.nextInt();
        int[] scores = new int[num];
        for (int i=0; i<num; i++){
            scores[i] = in.nextInt();
        }
        int[] result = solution(num, scores);
        for (int i=0; i< result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
