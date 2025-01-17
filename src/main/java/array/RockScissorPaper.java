package array;
import java.util.*;

public class RockScissorPaper {
  public static void solution(int round, int[] resultA, int[] resultB){
  	for (int i=0; i<round;i++){
      if (resultA[i] == resultB[i]) System.out.println("D");
      else if (resultA[i] ==1){
        	if (resultB[i] == 2) System.out.println("B");
          	else if (resultB[i] == 3) System.out.println("A");
      }
      else if (resultA[i] ==2){
        	if (resultB[i] == 3) System.out.println("B");
          	else if (resultB[i] == 1) System.out.println("A");
        }
      else if (resultA[i] ==3){
        	if (resultB[i] == 1) System.out.println("B");
          	else if (resultB[i] == 2) System.out.println("A");
        }
    }
  }
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int round = in.nextInt();
    int[] resultA = new int[round];
    int[] resultB = new int[round];

    for (int i=0; i<round;i++){
    	resultA[i] = in.nextInt();
    }

    for (int i=0; i<round;i++){
    	resultB[i] = in.nextInt();
    }

    solution(round,resultA, resultB);
  }
}

