package com.pjh.example.algorithm.website;

import java.util.*;

public class Programmers42840 {
    public static void main(final String[] args) {
        int[] answer = new int[]{2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        System.out.println(Arrays.toString(solution(answer)));
    }
    public static int[] solution(int[] answers) {
        List<User> result = new ArrayList<>();
        int[] guess1 = {1, 2, 3, 4, 5};
        int[] guess2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] guess3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        result.add(new User(1 ,test(answers,guess1)));
        result.add(new User(2 ,test(answers,guess2)));
        result.add(new User(3 ,test(answers,guess3)));

        UserComparator userComparator = new UserComparator();
        result.sort(userComparator);

        List<Integer> answerList = new ArrayList<>();
        int max = result.get(0).completeCnt;
        for(User u : result){
            if(max <= u.completeCnt) {
                answerList.add(u.id);
                max = u.completeCnt;
            }
            else
                break;
        }
        Collections.sort(answerList);
//
//        int[] answer = new int[answerList.size()];
//        int j = 0;
//        for(int i = answerList.size()-1; i >= 0; i--){
//            answer[i] = answerList.get(j);
//            j++;
//        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }

    private static int test(int[] answers, int[] guess) {
        int completeCnt = 0;
        int guessCnt = 0;
        for(int i = 0; i < answers.length; i++){
            if((i/(guess.length-1)) == 1)
                guessCnt = 0;

            if(answers[i] == guess[guessCnt]){
                completeCnt++;
            }
            guessCnt++;
        }
        return completeCnt;
    }
    static class User{
        int id;
        int completeCnt;

        public User(int id, int completeCnt) {
            this.id = id;
            this.completeCnt = completeCnt;
        }
    }

    static class UserComparator implements Comparator<User>{
        @Override
        public int compare(User o1, User o2) {
            if(o1.completeCnt > o2.completeCnt){
                return -1;
            }else if(o1.completeCnt < o2.completeCnt){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
