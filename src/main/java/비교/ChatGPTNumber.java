package 비교;

import java.util.*;

public class ChatGPTNumber {
    public static String[] solution(String[] nums){
        Arrays.sort(nums, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                // 정부수 소수부 분리
                String[] splited1 = o1.split("\\.");
                String[] splited2 = o2.split("\\.");

                // System.out.println(Arrays.toString(splited1));
                // System.out.println(Arrays.toString(splited2));
                int intPart1 = Integer.parseInt(splited1[0]);
                int intPart2 = Integer.parseInt(splited2[0]);

                Integer decimalPart1 = splited1.length > 1 ? Integer.parseInt(splited1[1]): null;
                Integer decimalPart2 = splited2.length > 1 ? Integer.parseInt(splited2[1]): null;

                // o1 > o2 (양수), 같으면(0), o1 < o2 (음수)
                if (intPart1 == intPart2){
                    if (decimalPart1 != null && decimalPart2 != null)
                        return Integer.compare(decimalPart1, decimalPart2);
                    else if (decimalPart1 != null && decimalPart2 == null) return 1;
                    else if (decimalPart1 == null && decimalPart2 != null) return -1;
                    else return 0;
                }
                else
                    return Integer.compare(intPart1, intPart2);
            }
        });
        return nums;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        String[] nums = new String[size];
        for (int i=0;i<size;i++){
            nums[i] = in.next(); // nextLine()은 에러
        }
        String[] result = solution(nums);
        for (int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}
