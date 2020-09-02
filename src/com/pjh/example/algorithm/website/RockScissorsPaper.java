package com.pjh.example.algorithm.website;

public class RockScissorsPaper {
    public static void main(final String[] args) {
        System.out.println(solution("RSPRS"));
    }
    public static int solution(String G) {
        int result = 0;

        Gesture rock = new Gesture("R","S","P");
        Gesture scissors = new Gesture("S","P","R");
        Gesture paper = new Gesture("P","R","S");

        String[] GArray = G.split("");

        //R
        int rResult = 0;
        for(String s : GArray){
            rResult += rock.match(s);
        }
        //S
        int sResult = 0;
        for(String s : GArray){
            sResult += scissors.match(s);
        }
        //P
        int pResult = 0;
        for(String s : GArray){
            pResult += paper.match(s);
        }

        return Math.max(rResult, Math.max(sResult, pResult));
    }

    public static class Gesture{
        String target;
        String win;
        String lose;
        Gesture(String target, String win, String lose){
            this.target = target;
            this.win = win;
            this.lose = lose;
        }

        int match(String giovanni){
            if(target.contentEquals(giovanni)){
                return 1;
            }else if(win.contentEquals(giovanni)){
                return 2;
            }else{
                return 0;
            }
        }
    }
}
