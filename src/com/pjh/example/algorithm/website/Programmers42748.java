package com.pjh.example.algorithm.website;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers42748 {
    //https://programmers.co.kr/learn/courses/30/lessons/42748
    public static void main(final String[] args) {
        int[][] com = new int[][]{{2,5,3}, {4,4,1}, {1,7,3}};
        int[] arr = new int[]{1,5,2,6,3,7,4};

        System.out.println(Arrays.toString(solution(arr, com)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<CommandRepository> commandList = new ArrayList<>();
        for(int[] i : commands){
            commandList.add(new CommandRepository(i));
        }

        for(int i = 0; i < commandList.size(); i++){
            CommandRepository commandRepository = commandList.get(i);
            int[] sp = split(array, commandRepository);
            answer[i] =  sp[commandRepository.key];
        }

        return answer;
    }

    static int[]  split(int[] array, CommandRepository commandRepository){
        int[] tmp = new int[commandRepository.last+1 - commandRepository.first];
        int cnt = 0;
        for(int i = commandRepository.first; i <= commandRepository.last; i++){
            tmp[cnt] = array[i];
            cnt++;
        }
        Arrays.sort(tmp);
//        int[] result = new int[tmp.length];
//        for(int j = 0; j < tmp.length; j++){
//            result[j] = tmp[j];
//        }

        return tmp;
    }

    public static class CommandRepository{
        int first;
        int last;
        int key;

        public CommandRepository(int[] commands){
            this.first = commands[0] -1;
            this.last = commands[1] -1;
            this.key = commands[2] -1;
        }
    }
}
