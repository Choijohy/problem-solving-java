package 넓이우선탐색;

/*
문제: 송아지 찾기
카테고리: BFS
기타:
    - 가능 경로를 다 하는게 아니라, 최단경로 구하기 -> BFS
    - 초반에는 -1, 1, 5 조합을 활용해서, 현재 민수의 위치와 송아지 사이의 거리값을 가장 빠르게 만드는 식으로 탐색(시간초과)
    - 해당 문제에서는 (-1,1,5) (5,1,-1)이나 같은 탐색 -> 따라서 위와 같은 접근법은 중복 탐색을 야기시킴
    - 특정 좌표 위치에서 타겟 좌표까지 이동할때, 방문하는 좌표 위치자체를 탐색하도록 변경(1->3->9) (1->5->6->9)
*/
import java.util.*;
import java.io.*;
import java.util.Scanner;

public class FindCalf {
  public static int solution(int s, int e){
  	Queue<Integer> queue = new ArrayDeque<>();
    int[] dis = {1,-1,5};
    int[] checked = new int[10001];
    checked[s] = 1;
    queue.add(s);

    int answer = 0;
    while (!queue.isEmpty()){

      	int size = queue.size();
      	for (int i=0; i<size; i++){
          	int current = queue.poll();
          	if (current == e) return answer;
        	for (int j=0;j<3; j++){
              	int next = current+dis[j];
            	if (next > 0 && next < 10001 && checked[next] == 0){
                	checked[next] = 1;
                  	queue.offer(next);
                }
            }
        }
        answer ++;
    }
	return -1;
  }
  public static void main(String[] args) throws IOException{
   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int s = Integer.parseInt(str[0]);
    int e = Integer.parseInt(str[1]);
    System.out.println(solution(s,e));

    return ;
  }
}
//public class FindCalf {
//  public static void addNodes(Queue<int[]> queue, int distance){
//    queue.offer(new int[]{1,distance}); // 이동 거리, 현재까지 앞으로 이동한 거리
//    queue.offer(new int[]{-1,distance});
//    queue.offer(new int[]{5,distance});
//  }
//
//  public static int solution(int target){
//  	Queue<int[]> queue = new ArrayDeque<>();
//    boolean flag = false; // 최단거리 발견 여부
//    addNodes(queue, 0);
//    int answer = 0;
//
//    // bfs
//    while(!queue.isEmpty()){
//      	if (flag) break;
//    	int size = queue.size();
//      	answer ++;
//      	for (int i=0; i<size; i++){
//        	int[] current = queue.poll();
//          	int distance = current[0] + current[1]; // 이전까지의 이동거리 + 현재 움직인 거리
//          	if (distance == target) flag = true;
//          	else addNodes(queue, distance);
//        }
//    }
//    return answer;
//  }
//
//  public static void main(String[] args) throws IOException{
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    String[] str = br.readLine().split(" ");
//    int s = Integer.parseInt(str[0]);
//    int e = Integer.parseInt(str[1]);
//
//    if (e==s) System.out.println(0);
//    else System.out.println(solution(e-s));
//    return ;
//  }
//}
//
