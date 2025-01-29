package 투포인터;
import java.io.*;

public class 부분수열합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);

        int[] arr = new int[n];
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s2[i]);
        }

        // 로직 실행
        Solution solution = new Solution(n, m, arr);
        System.out.println(solution.solution(m));

        br.close();
    }
}

class Solution{
    private int n, m;
    private int left, right;
    private int sum;
    private int[] nums;

    Solution(int n, int m, int[] arr){
        this.n = n;
        this.m = m;
        this.left = 0;
        this.right = 0;
        this.nums = arr;
        this.sum = nums[0];
    }

    private void addRight() {
        right++;
        sum += nums[right];
    }

    private void removeLeft() {
        sum -= nums[left];
        left++;
    }

    // 실제 투 포인터 로직
    public int solution(int m) {
        int count = 0;
        sum = nums[0];

        while (right < nums.length) {
            if (sum == m) {
                count++;
                removeLeft();
                if (right == nums.length - 1) break;
                addRight();
            } else if (sum < m) {
                if (right == nums.length - 1) break;
                addRight();
            } else {
                removeLeft();
                if (left > right) right++;
            }
        }

        return count;
    }

}