package 스택큐;

import java.util.*;
import java.io.*;

public class Pipe {
  public static void main(String[] args) throws IOException{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Deque<Character> stack = new ArrayDeque<>();
    int answer = 0;
	char pre = ' ';
    for (char x: str.toCharArray()){
    	if (x == '(') stack.push(x);
      	else {
          stack.pop();
          if (pre == '(') answer += stack.size();
          else answer ++;
        }
        pre = x;
    }
    System.out.println(answer);
    return ;
  }
}