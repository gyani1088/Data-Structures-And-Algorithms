package com.lucky.practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrefixEvaluation {

    public static void main(String[] args) {
        System.out.println(calculatePrefixExpression("* + 10 2 3")); //36
        System.out.println(calculatePrefixExpression("+ * 10 2 3")); //23
        System.out.println(calculatePrefixExpression("+ 10 * 2 3")); //16
    }
    // 10 2 * 3 5 * + 9 -
    public static int calculatePrefixExpression(String str){
        String[] splits = str.split(" ");
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=splits.length-1;i>=0;i--){
            String s = splits[i];
            if(s.matches("\\d+")) stack.push(Integer.parseInt(s));
            else{
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                switch (s){
                    case "+":
                        stack.push(operand1+operand2);
                        break;
                    case "-":
                        stack.push(operand1-operand2);
                        break;
                    case "*":
                        stack.push(operand1*operand2);
                        break;
                    case "/":
                        stack.push(operand1/operand2);
                        break;
                    case "^":
                        stack.push((int)Math.pow(operand1,operand2));
                        break;
                }
            }
        }
        return stack.pop();
    }
}
