package com.pjh.example.algorithm.website;

import java.util.LinkedList;
import java.util.Queue;

public class CodolityQKMFGRJH8 {
    //https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
    public static void main(final String[] args){
        System.out.println(solution(new int[]{3,8,9,7,6}, 3));
    }

    public static int[] solution(int[] A, int K) {
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i = A.length-1; i >= 0; i--){
            queue.offer(A[i]);
        }

        while(K > 0){
            int tmp = queue.poll();
            queue.offer(tmp);
            K--;
        }

        int[] answer = new int[queue.size()];

        int cnt = queue.size()-1;
        while(!queue.isEmpty()){
            answer[cnt] = queue.poll();
            cnt--;
        }

        return answer;
    }
}
