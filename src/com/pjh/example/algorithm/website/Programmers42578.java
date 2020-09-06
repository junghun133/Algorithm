package com.pjh.example.algorithm.website;

import java.util.*;

public class Programmers42578 {
    //https://programmers.co.kr/learn/courses/30/lessons/42578?language=java
    public static void main(final String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    public static int solution(String[][] clothes) {
        int answer = 0;

        Map<String, List<String>> map = new HashMap<>();
        for(String[] sA : clothes){
            if(!map.containsKey(sA[1])){
                List<String> list = new ArrayList<String>();
                list.add(sA[0]);
                map.put(sA[1], list);
            }else{
                map.get(sA[1]).add(sA[0]);
            }
        }
        answer = clothes.length;


        return answer;
    }
}
