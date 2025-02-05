package 그리디;


import java.util.*;
import java.io.*;

public class 씨름선수 {
	  public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		List<Player> arr = new LinkedList<>();

		for (int i=0; i<n; i++){
			String[] info = br.readLine().split(" ");
			arr.add(new Player(Integer.parseInt(info[0]), Integer.parseInt(info[1])));
		}

		Collections.sort(arr);
//		for (Player x: arr){
//			System.out.print(x.height);
//			System.out.print(" ");
//			System.out.print(x.weight);
//		}
		Solution solution = new Solution(n, arr);
		bw.append(String.valueOf(solution.solution2()));
		br.close();
		bw.flush();
		br.close();
		return ;
	  }
}

class Player implements Comparable<Player>{
	int height;
  	int weight;
  	Player(int h, int w){
    	this.height = h;
      	this.weight = w;
    }

	// O(nlogn)
  	@Override
  	public int compareTo(Player o1){ // 1차 정렬: 키 오름차순, 2차 정렬: 몸무게 내림차순
		if (this.height > o1.height ) return 1;
      	else if (this.height == o1.height){
        	if (this.weight > o1.weight) return -1;
          	else if (o1.weight == this.weight) return 0;
          	else return 1;
        }
      	else return -1;
    }
}

class Solution{
  	int n;
	List<Player> arr;
   	Solution(int n, List<Player> arr){
      	this.n = n;
    	this.arr = arr;
    }

  	public int solution(){
		int answer = n;
    	for (int i=0; i<n; i++){
          	Player player = arr.get(i);
        	for (int j=i+1; j<n; j++){
                Player next = arr.get(j);
            	if(player.weight < next.weight) {
					answer --;
					break;
				}
            }
        }
      	return answer;
    }

	// 같은 키, 같은 몸무게의 선수가 없는 경우(전제)
	public int solution2(){
		   int answer = 1;
		   int max = arr.get(n-1).weight;
		   for (int i=n-2; i > -1; i--){
			   Player player = arr.get(i);
			   if (player.weight > max) {
				   answer ++;
				   max = player.weight;
			   }

		   }
		   return answer;

	}
}