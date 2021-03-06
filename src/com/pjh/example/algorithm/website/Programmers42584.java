package com.pjh.example.algorithm.website;

import java.util.*;

public class Programmers42584 {
    //https://programmers.co.kr/learn/courses/30/lessons/42584
    static class Solution {
        public static void main(final String[] args) {
            System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
            // return [4, 3, 1, 1, 0]
        }

        public static int[] solution(int[] prices) {
            int len = prices.length;
            int[] answer = new int[len];
            int i, j;
            for (i = 0; i < len; i++) {
                for (j = i + 1; j < len; j++) {
                    answer[i]++;
                    if (prices[i] > prices[j])
                        break;
                }
            }
            return answer;
        }
    }
}
