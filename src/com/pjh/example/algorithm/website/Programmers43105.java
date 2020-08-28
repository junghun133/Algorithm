package com.pjh.example.algorithm.website;

public class Programmers43105 {
    //https://programmers.co.kr/learn/courses/30/lessons/43105
    public static void main(final String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
    public static int solution(int[][] triangle) {
        int answer = 0;


        for(int i = triangle.length-1; i >= 0; i --){
            if(i == 0)
                break;

            dp(triangle[i-1], triangle[i]);
        }
        answer = triangle[0][0];

        return answer;
    }

    static void dp(int[] parent, int[] child){
        for(int i = 0; i < parent.length; i++){
            int big = 0;
            if(child[i] > child[i+1]){
                big = child[i];
            }else {
                big = child[i+1];
            }
            parent[i] += big;
        }
    }
  }
