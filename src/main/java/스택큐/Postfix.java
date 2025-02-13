package 스택큐;

import java.util.*;
import java.io.*;

public class Postfix {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Deque<Integer> stack = new ArrayDeque<>();

    for (char x: str.toCharArray()){
    	if (Character.isDigit(x)){
        	stack.push(Integer.parseInt(String.valueOf(x))); // stack.push(x-48);
        }else{
          	int num2 = stack.pop();
          	int num1 = stack.pop();

          	if (x=='+') stack.push(num1 + num2);
            else if (x=='-') stack.push(num1 - num2);
            else if (x=='*') stack.push(num1 * num2);
            else if (x=='/') stack.push(num1 / num2);
        }
    }

    System.out.println(stack.pop());
    return ;
  }
}