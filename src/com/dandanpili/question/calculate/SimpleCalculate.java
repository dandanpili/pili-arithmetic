package com.dandanpili.question.calculate;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shaoruilin
 * @create 2021-04-02-11:57
 */
//简易计算器，输入的字符串只包含"+","-","*","/"," ",计算出结果、
//解法：用栈来实现，计算加法和减法的时候，需要从左往右计算
public class SimpleCalculate {
    public static void main(String[] args) {
        String str = "3+3  *  3-3 /3   ";
        long res = calculate(str);
        System.out.println(res);
    }

    public static long calculate(String str) {
        Deque<Long> numStack = new LinkedList<>();
        Deque<Character> signStack = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
               continue;
            }
            if (ch >= '0' && ch <= '9') {
                int cur = i;
                while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    i++;
                }
                numStack.offerLast(Long.valueOf(str.substring(cur, i)));
                i--;
                if (!signStack.isEmpty() && (signStack.peekLast() == '*' || signStack.peekLast() == '/')) {
                    char sign = signStack.pollLast();
                    long num1 = numStack.pollLast();
                    long num2 = numStack.pollLast();
                    if (sign == '*') {
                        numStack.offerLast(num1 * num2);
                    } else {
                        numStack.offerLast(num2 / num1);
                    }
                }
            } else {
                signStack.offerLast(ch);
            }
        }
        while (!signStack.isEmpty()) {
            char sign = signStack.pollFirst();
            long num1 = numStack.pollFirst();
            long num2 = numStack.pollFirst();
            if (sign == '+') {
                numStack.offerFirst(num1 + num2);
            } else {
                numStack.offerFirst(num1 - num2);
            }
        }
        return numStack.peekLast();
    }
}
