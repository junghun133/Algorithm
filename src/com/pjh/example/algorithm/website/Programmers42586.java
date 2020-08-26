package com.pjh.example.algorithm.website;

import java.util.*;

public class Programmers42586 {
    //https://programmers.co.kr/learn/courses/30/lessons/42586
    static class Solution {
        public static void main(final String[] args) {
            int[] progresses = {1, 1, 1, 1, 1, 1, 1};
            int[] speeds = {1, 1, 1, 50, 1, 1, 1};

            System.out.println(Arrays.toString(solution(progresses, speeds)));
            //return 2,1
        }

        public static int[] solution(int[] progresses, int[] speeds) {
            Process[] pro = new Process[progresses.length];
            for(int i = 0; i < progresses.length; i ++){
                pro[i] = new Process(progresses[i], speeds[i]);

                if(i != 0)
                    pro[i].previousProcess = pro[i-1];
            }
            HashMap<Integer, Integer> answer = new HashMap<>();

            boolean run = true;
            while(run){
                for(int j = 0; j < progresses.length; j++){
                    if(pro[j].done)
                        continue;

                    pro[j].addDay();
                    pro[j].processAddedTime();

                    if(j == 0){
                        if(pro[j].isCompleted()){
                            answer.put(pro[j].day, 1);
                            pro[j].done = true;
                            continue;
                        }
                    }else {
//                        if (pro[j].isCompleted() && pro[j].previousProcess.isCompleted()) {
                        if (pro[j].isCompleted() && pro[j].previousProcess.isCompleted()) {
                            if (answer.containsKey(pro[j].day)) {
                                answer.put(pro[j].day, answer.get(pro[j].day) + 1);
                                pro[j].done = true;
                            }
                            else {
                                answer.put(pro[j].day, 1);
                                pro[j].done = true;
                            }
                        }
                    }
                }

                int exitCount = 0;
                for(Process p : pro){
                    if(p.isCompleted()){
                        exitCount++;
                    }
                }
                if(exitCount == progresses.length)  run = false;

            }
            int[] array =  new int[answer.size()];
            Iterator<Integer> integerIterator = answer.values().iterator();
            int i = 0;
            while(integerIterator.hasNext()){
                array[i++] = integerIterator.next();
            }
//            int[] array = resultList.stream().mapToInt(i->i).toArray();
            return array;
        }

        static class Process {
            boolean done = false;
            int pro = 0;
            int sp = 0;
            int day = 0;
            Process previousProcess;
            Process(int pro, int sp ){
               this.pro = pro;
               this.sp = sp;
            }

            public void addDay(){ day++; }
            public void processAddedTime(){
                pro += sp;
            }

            public boolean isCompleted(){
                if(previousProcess == null){
                    return pro >= 100;
                }
                return previousProcess.isCompleted() && pro >= 100;
            }
        }
    }
}
