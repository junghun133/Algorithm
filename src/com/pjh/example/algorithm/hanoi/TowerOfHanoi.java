package com.pjh.example.algorithm.hanoi;

import java.util.Scanner;

public class TowerOfHanoi {
        static int count = 0;
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);

            int number = scanner.nextInt();

            TowerOfHanoi main = new TowerOfHanoi();
            main.moveDisk("1", "2", "3" , number);
            System.out.println("result :" + count);

        }

        public void moveDisk(String first, String center, String last, int number){
            //first : 원반이 있던 탑
            //center : 중간 위치 탑
            //last : 원반들을 옮길 목적지 탑
            if(number == 1){
                ++ count;
                System.out.println(number + " : " + first + " -> " + last);
            } else{
                moveDisk(first, last, center, number -1);
                ++ count;
                System.out.println(number + " : " + first + " -> " + last);
                moveDisk(center, first, last, number -1);
            }
        }
    }