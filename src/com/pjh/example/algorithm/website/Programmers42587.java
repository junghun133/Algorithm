package com.pjh.example.algorithm.website;

import java.util.*;

public class Programmers42587 {
    //https://programmers.co.kr/learn/courses/30/lessons/42587
    public static void main(final String[] args) {
        System.out.println(solution(new int[]{1,1,9,1,1,1}, 0));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> priList = new ArrayList<>();
        int[] copyPriorities = priorities.clone();
        Arrays.sort(copyPriorities);

        for(int i : priorities) {
            priList.add(i);
        }

        int loop = 0;
        int topCount = copyPriorities.length -1;
        while(topCount > 0){
            for(int i = 0 ; i < copyPriorities.length; i++){
                if(priList.get(i) >= copyPriorities[topCount]){
                    priList.set(i, 0);

                    topCount--;
                    loop++;
                    if(i == location) {
                        answer = loop;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
