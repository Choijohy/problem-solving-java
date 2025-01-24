package 구현;

import java.io.*;
import java.util.*;

public class stoves {
    static HashMap<Integer, Integer> map = new HashMap<>();

    // O(N)
    public static int solution(int n, int[] nums){
        for (int i=0;i<n;i++){
            getDivisors(nums[i]);
        }

        int max = 0;
        // key,value 순회
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            int value = entry.getValue();
            if (max < value) max = value;
        }

        return max;
    }

    // O(N(1/2))
    public static void getDivisors(int num){
        for (int i=2;i<=Math.sqrt(num);i++){
            if (num%i == 0){
                map.put(i,map.getOrDefault(i,0)+1);
                if (i != num/i) {
                    map.put(num/i,map.getOrDefault(num/i,0)+1);
                }
            }
        }
            map.put(num,map.getOrDefault(num,0)+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i=0; i<n;i++){
            nums[i] = Integer.parseInt(str[i]);
        }

        System.out.println(solution(n, nums));

        br.close();
    }
}

