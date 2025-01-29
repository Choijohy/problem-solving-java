package 이분탐색;

import java.util.*;

public class Lis {
      public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int size = in.nextInt();
        int[] nums = new int[size];
        for (int i=0; i<size;i++){
            nums[i] = in.nextInt();
        }
        Solution solution = new Solution(nums);
        System.out.println(solution.solution());
        return ;
      }
}

class Solution {
    static int[] lis;
    static int[] nums;
    Solution(int[] arr){
        this.lis = new int[arr.length];
        lis[0] = arr[0];
        this.nums = arr;
    }

    public static int solution() {
        int end = 0;

        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            if (key > lis[end]) { // 부분 수열의 마지막 항 보다 크거나 같을때
                end++;
                lis[end] = key;
            } else {
                int pos = binarySearch(0, end, key);
                lis[pos] = key;
            }
        }
        return end + 1;
    }

    private static int binarySearch(int lt, int rt, int key) {
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (lis[mid] < key) {
                lt = mid + 1;
            } else if (lis[mid] == key) {
                return mid;
            } else {
                rt = mid - 1;
            }
        }
        return lt;
    }
}

