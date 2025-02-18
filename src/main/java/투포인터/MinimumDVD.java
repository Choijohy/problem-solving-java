package 투포인터;


import java.util.*;
import java.io.*;

public class MinimumDVD {
  public static void main(String[] args) throws IOException{
  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int m = Integer.parseInt(str[1]);


    int[] playTimes = new int[n];
    str = br.readLine().split(" ");
    for(int i=0; i<n; i++){
      	int cur = Integer.parseInt(str[i]);
      	playTimes[i] = cur;
//    	maxValue = Math.max(maxValue, cur);
//      	maxSum += cur;
    }
    int maxValue = Arrays.stream(playTimes).max().getAsInt();
    int maxSum = Arrays.stream(playTimes).sum();
    List<Integer> arr = new ArrayList<>();
    for (int i=maxValue ; i<=maxSum; i++){
    	arr.add(i);
    }

    Solution_MinimumDVD solution = new Solution_MinimumDVD(n,m, playTimes, arr);
    System.out.println(solution.solution());
    return ;
  }
}

class Solution_MinimumDVD{
  	int n;
	int m;
  	int[] playTimes;
  	List<Integer> arr;

  	Solution_MinimumDVD(int n, int m, int[] playTimes, List<Integer> arr){
    	this.n = n;
      	this.m = m;
      	this.playTimes = playTimes;
      	this.arr = arr;
    }

  	public int solution(){
    	int lt = 0;
      	int rt = arr.size()-1;
        int answer =0;
          while(lt <= rt){
              int mid = (lt+rt)/2;
              int midValue = arr.get(mid);
              if (isPossible(midValue)){
                  answer = midValue;
                  rt = mid+-1;
              }else{
                lt = mid + 1;
              }

          }
      return answer;
    }

  	private boolean isPossible(int midValue){
            int sum = 0;
            int count = 0;
            for(int x: playTimes){
                if (count >= m) return false;
                sum += x;
                if (sum > midValue){
                    count ++;
                    sum = x;
                }
            }
            if (count >= m) return false;
            return true;

//            while (i < n){
//              if (count >= m) return false;
//              int sum =0;
//              while (sum < midValue){
//                if (i > n -1) return true;
//                sum += playTimes[i];
//                i++;
//              }
//              count ++; // 사용 디스크 개수
//              if (sum > midValue) i--;
//        }
//        return true;
    }

}