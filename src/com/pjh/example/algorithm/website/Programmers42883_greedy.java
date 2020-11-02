package com.pjh.example.algorithm.website;

public class Programmers42883_greedy {
    //https://programmers.co.kr/learn/courses/30/lessons/42883
    public static void main(final String[] args) {
        System.out.println(solution("1924", 2));
    }

    private static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        for (int i = 0; i+1 < sb.length() && k>0; i++) {
            if(sb.charAt(i) < sb.charAt(i+1)) {
                sb.deleteCharAt(i);
                i=-1;
                k--;
            }
        }
        if(k!=0)
            sb.delete(sb.length()-k, sb.length());
        return sb.toString();


    }
}
