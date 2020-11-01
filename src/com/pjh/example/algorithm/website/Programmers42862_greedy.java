package com.pjh.example.algorithm.website;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/42862
public class Programmers42862_greedy {

    public static void main(final String[] args) {
        System.out.println(solution(5, new int[]{2,3,4}, new int[]{1,4}));
    }

    private static int solution(int n, int[] lost, int[] reserve) {
        int result = n - lost.length;


        for(int i = 0; i < lost.length; i++){
            for(int index = 0; index < reserve.length; index++){
                if(lost[i] == reserve[index]) {
                    result++;
                    reserve[index] = 0;
                    lost[i] = 0;
                    break;
                }
            }
        }

        for(int i = 0; i < lost.length; i++){
            if(lost[i] == 0)
                continue;

            int pre = 0;
            int next = 0;

            if(lost[i]-1 != 0) {
                pre = lost[i]-1;
            }
            next = lost[i]+1;

            for(int index = 0; index < reserve.length; index++){
                if(reserve[index] == 0)
                    continue;


                if(reserve[index] == pre){
                    result ++;
                    reserve[index] = 0;
                    break;
                }else if(reserve[index] == next){
                    result ++;
                    reserve[index] = 0;
                    break;
                }
            }
        }
        return result;
    }
}
