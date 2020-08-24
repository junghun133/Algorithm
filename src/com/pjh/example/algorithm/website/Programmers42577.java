package com.pjh.example.algorithm.website;

import java.util.*;

public class Programmers42577 {
    //https://programmers.co.kr/learn/courses/30/lessons/42577
    static class Solution {
        public static void main(final String[] args) {
            //System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
            System.out.println(solution(new String[]{"123", "456", "789"}));
            //false
        }

        public static boolean solution(String[] phone_book) {
            Arrays.sort(phone_book);

            for(int i = 1; i < phone_book.length; i++){
                if(phone_book[i].startsWith(phone_book[i-1]))
                    return false;
            }
            return true;
        }
    }
}
