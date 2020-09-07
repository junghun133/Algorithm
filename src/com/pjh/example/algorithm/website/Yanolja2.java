package com.pjh.example.algorithm.website;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Yanolja2 {
    /*
     *  야놀자 코딩 테스트
     *  배팅 게임에 참가하고, input으로 가지고 있는 chip수와 allIn할 수 있는 count를 받는다
     *  모든 게임을 이겼으며, allin은 가진 칩을 2배로 낼수있다
     *  모든 칩을 소모하는 라운드가 가장 작은 수를 출력
     */

    static Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
    public static void main(final String[] args) {
        System.out.println(solution(18, 2));
    }
    public static int solution(int N, int K) {

        return calc(N, K);
//        return calc(N, K);
    }

    private static int calc(int chip, int allInCnt) {
        Pair<Integer, Integer> pair = new Pair<>(chip,allInCnt);
        if(map.containsKey(pair)){
            return map.get(pair);
        }


        if(chip == 1) {
            map.put(new Pair<>(chip,allInCnt), 0);
            return 0;
        }
        if(allInCnt < 0) {
            map.put(new Pair<>(chip,allInCnt), Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }

        //bat 1
        int batOneResult = calc(chip - 1, allInCnt);
        //bat all-in
        int allInResult = Integer.MAX_VALUE;
        if(chip%2 == 0)
            allInResult = calc(chip / 2, allInCnt - 1);

        map.put(new Pair<>(chip,allInCnt), Math.min(batOneResult, allInResult) + 1);
        return Math.min(batOneResult, allInResult) + 1;
    }

}
