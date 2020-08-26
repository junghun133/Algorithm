package com.pjh.example.algorithm.website;

import java.util.*;

public class Programmers42586_stack {
    //https://programmers.co.kr/learn/courses/30/lessons/42586
    static class Solution {
        public static void main(final String[] args) {
            int[] progresses = {93,30,55};
            int[] speeds = {1,30,5};

            System.out.println(Arrays.toString(solution(progresses, speeds)));
        }

        public static int[] solution(int[] progresses, int[] speeds) {
            List<Integer> resultList = new ArrayList<>();
            Stack<Process> stack = new Stack<>();
            List<Process> processList = new ArrayList<>();

            int cnt = 0;
            for(int i = progresses.length-1; i >= 0; i--){
                processList.add(new Process(progresses[i], speeds[i]));
                stack.push(processList.get(cnt));
                cnt++;
            }


            while(!stack.empty()) {
                for(Process p : processList){
                    p.pro += p.speed;
                }

                int count = 0;
                boolean pop = false;
                while (!stack.empty() && stack.peek().pro >= 100) {
                    stack.pop();
                    count++;
                    pop = true;
                }
                if(pop)
                    resultList.add(count);
            }

            int[] result = new int[resultList.size()];
            for(int j = 0; j < resultList.size(); j++){
                result[j] = resultList.get(j);
            }

            return result;
        }

    }

    static class Process {
        Process(int pro, int speed){
            this.pro = pro;
            this.speed = speed;
        }
        int pro;
        int speed;
    }
}
