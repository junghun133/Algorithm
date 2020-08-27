package com.pjh.example.algorithm.website;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers43165 {
    //https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
    public static void main(final String[] args) {
        System.out.println(solution(new int[]{1,1,1,1,1}, 3));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();

        //양수 음수 초기값
        queue.offer(new Node(numbers[0], 0));
        queue.offer(new Node(-numbers[0], 0));

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            //주어진 값의 길이만큼만
            if (n.index == numbers.length-1) {
                if (n.value == target) { // target 과 같으면 (정답이면)
                    answer += 1;
                } continue;
            }

            //정답이 아닐경우 추가로 계속 queue를 add해준다
            int c1 = n.value + numbers[n.index+1];
            int c2 = n.value - numbers[n.index+1];
            queue.add(new Node(c1, n.index+1));
            queue.add(new Node(c2, n.index+1));
        }

        return answer;
    }

    static class Node{
        Node(int value, int index){ this.value = value; this.index = index;}
        int value;
        int index;
    }
}
