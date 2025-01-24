package 구현;

import java.io.*;
import java.util.*;

public class FilialPiety {
    public static int solution(int[][] land){
        int min = 100;
        for (int i=0;i<3;i++){
            min = Math.min(min, unifyLand(land[i][0], land[i][1], land[i][2]));
            min = Math.min(min, unifyLand(land[0][i], land[1][i], land[2][i]));
        }
        return min;


    }

    public static int unifyLand(int a, int b, int c){
        int min = 100;
        for (int h=1;h<4;h++){
            min = Math.min(min, Math.abs(a-h) + Math.abs(b-h) + Math.abs(c-h));
        }
        return min;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] land = new int[3][3];
        for (int i=0; i<3;i++){
            String[] nums = br.readLine().split(" ");
            for (int j=0;j<3;j++){
                land[i][j] = Integer.parseInt(nums[j]);
            }
        }
        System.out.println(solution(land));
        br.close();
    }
}