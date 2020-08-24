package com.pjh.example.algorithm.website;

import java.util.HashMap;
import java.util.Map;

public class Programmers42576 {
    //https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
    static class Solution {
        public static void main(final String[] args){
            String[] part = {"mislav", "stanko", "mislav", "ana","park"};
            String[] comp = {"mislav", "stanko", "ana","mislav"};

            System.out.println(solution(part, comp));
        }
        public static String solution(String[] participant, String[] completion) {
            Map<String, Integer> map = new HashMap<>();

            for(String s : participant){
                if(map.containsKey(s)){
                   Integer cnt = map.get(s);
                   map.put(s, ++cnt);
                }else {
                    map.put(s, 0);
                }
            }

            for(String s : completion){
                if(map.containsKey(s)){
                    Integer cnt = map.get(s);
                    if(cnt > 1){
                       map.put(s,--cnt);
                    }else{
                        map.remove(s);
                    }
                }
            }

            Object[] key = map.keySet().toArray();
            return (String)key[0];
        }
    }
}