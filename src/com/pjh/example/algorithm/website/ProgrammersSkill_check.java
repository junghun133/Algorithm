package com.pjh.example.algorithm.website;

public class ProgrammersSkill_check {
    public static void main(String[] args){
        String s = "abcde";

        String answer = "";
        char[] sA = s.toCharArray();
        int len = sA.length /2;
        if(sA.length % 2 == 0){
            answer = Character.toString(sA[len-1]) +Character.toString(sA[len]);
        }else{
            answer = Character.toString(sA[len]);
        }
        System.out.println(answer);
    }
}
