package dataStructure.hashSet;

import java.util.*;

public class SalesType {

        // O(n^2) 비효율
        public static ArrayList<Integer> solution(int n, int k, int[] sales){
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i+ k <= n; i++){
                HashSet<Integer> set = new HashSet<>();
                for (int j = 0; j< k; j++){
                     set.add(sales[i+j]);
                }
                result.add(set.size());
            }
            return result;
        }

      public static ArrayList<Integer> solution2(int n, int k, int[] sales){
            ArrayList<Integer> result = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();

            // 초기 n개 (index: 0 ~ k-1)
            for (int i = 0; i< k; i++){
                map.put(sales[i],map.getOrDefault(sales[i],0)+1);
            }
            result.add(map.size());

            if (n > k){
                for (int i = k; i < n; i++){
                    map.put(sales[i-k],map.get(sales[i-k])-1);
                    if (map.get(sales[i-k]) == 0) map.remove(sales[i-k]);
                    map.put(sales[i],map.getOrDefault(sales[i],0)+1);
                    result.add(map.size());
                }
            }
            return result;
      }

      public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int total = in.nextInt(); // 전체 매출액 건수
        int num = in.nextInt(); // 연속으로 계산해야 하는 일수
        int[] sales = new int[total];
        for (int i=0; i<total; i++){
            sales[i] = in.nextInt();
        }

        for (int x:  solution2(total, num, sales)){
            System.out.print(x +" ");
        }

        return ;
      }
}
