package 그리디;

import java.util.*;
import java.io.*;

public class Wedding {
    static int n;
    static int answer = Integer.MIN_VALUE;

    private static void getMaxPeople(ArrayList<TimeLine> arr){
        int sum = 0;
        for (TimeLine x:arr){
            if (x.type == 's'){
                sum ++;
            }else sum --;

            answer = Math.max(answer, sum);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ArrayList<TimeLine> arr = new ArrayList<>();

        for (int i=0; i<n; i++){
                String[] str = br.readLine().split(" ");
                arr.add(new TimeLine(Integer.parseInt(str[0]), 's'));
                arr.add(new TimeLine(Integer.parseInt(str[1]), 'e'));
            }
        Collections.sort(arr);
        getMaxPeople(arr);
        System.out.println(answer);
    }
}

class TimeLine implements Comparable<TimeLine>{
    int time;
    char type;

    TimeLine(int time, char type){
        this.time = time;
        this.type = type;
    }

    @Override
    public int compareTo(TimeLine o){
        if (this.time == o.time) return this.type - o.type; // 알파벳순
        else return this.time - o.time;
    }
}