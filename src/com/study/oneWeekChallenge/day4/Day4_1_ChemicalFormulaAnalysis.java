package com.study.oneWeekChallenge.day4;

import java.util.*;
import java.util.Scanner;

/**
 * 给定一个用字符串展示的化学公式，计算每种元素的个数。
 * 规则如下：
 *
 * 元素命名采用驼峰命名，例如 Mg
 * () 代表内部的基团，代表阴离子团
 * [] 代表模内部链节通过化学键的连接，并聚合
 * 例如：H2O => H2O1 Mg(OH)2 => H2Mg1O2
 *
 * 格式：
 *
 *
 * 输入：
 * - 化学公式的字符串表达式，例如：K4[ON(SO3)2]2 。
 * 输出：
 * - 元素名称及个数：K4N2O14S4，并且按照元素名称升序排列。
 * 示例：
 *
 *
 * 输入：K4[ON(SO3)2]2
 * 输出：K4N2O14S4
 */
public class Day4_1_ChemicalFormulaAnalysis {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        Map<String, Integer> treeMap = new TreeMap<>();
        List<String> arr = new ArrayList<>();
        StringBuilder numStr = new StringBuilder(), elementStr = new StringBuilder();
        boolean flag = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            char curChar = chars[i];
            if (Character.isDigit(curChar)) {// 是数字
                numStr.insert(0, curChar);
                char nextChar = chars[i - 1];
                if (i > 0 && !Character.isDigit(nextChar)) {
                    arr.add(numStr.toString());
                    numStr = new StringBuilder();
                    if (nextChar != ')' && nextChar != ']') {
                        arr.add(")");
                        flag = true;
                    }
                }
                continue;
            }
            if (Character.isLetter(curChar)) {
                elementStr.insert(0, curChar);
                if (Character.isUpperCase(curChar)) {
                    arr.add(elementStr.toString());
                    elementStr = new StringBuilder();
                    if (flag) {
                        arr.add("(");
                        flag = false;
                    }
                }
                continue;
            }
            arr.add(curChar + "");
        }

        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (String str : arr) {
            if (str.equals("(")) {
                int num = numStack.isEmpty() ? 1 : numStack.pop();
                List<String> tmp = new ArrayList<>();
                while (!strStack.peek().equals(")")) {
                    tmp.add(strStack.pop());
                }
                strStack.pop();
                while (num > 0) {
                    for (String s : tmp) {
                        strStack.push(s);
                    }
                    num--;
                }
            }
            else if (str.equals("[")) {
                int num = numStack.isEmpty() ? 1 : numStack.pop();
                List<String> tmp = new ArrayList<>();
                while (!strStack.peek().equals("]")) {
                    tmp.add(strStack.pop());
                }
                strStack.pop();
                while (num > 0) {
                    for (String s : tmp) {
                        strStack.push(s);
                    }
                    num--;
                }
            }
            else if (Character.isDigit(str.charAt(0))) {
                numStack.push(new Integer(str));
            }
            else {
                strStack.push(str);
            }
        }

        for (String str : strStack) {
            int count = treeMap.getOrDefault(str, 0);
            treeMap.put(str, count + 1);
        }

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.print(entry.getKey() + entry.getValue());
        }


    }


}
