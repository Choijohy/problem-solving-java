package stack_queue;
  import java.util.*;

public class StockPrice {

    class Solution {
        public int[] solution(int[] prices) {
            ArrayList<int[]> stack = new ArrayList<>();

            stack.add(new int[] {0,prices[0]});

            int[] result = new int[prices.length];

            for (int i=1; i<prices.length; i++){
                 while (!stack.isEmpty() && stack.get(stack.size() -1)[1] > prices[i]){
                        int[] removed = stack.remove(stack.size() -1);
                        int removedIndex = removed[0];
                        int diff = i - removedIndex;
                        result[removedIndex] = diff;
                    }
                stack.add(new int[]{i, prices[i]});
            }

            while(!stack.isEmpty()){
                int[] removed = stack.remove(stack.size()-1);
                result[removed[0]] = prices.length - removed[0]-1;
            }


            return result;
        }
    }
}
