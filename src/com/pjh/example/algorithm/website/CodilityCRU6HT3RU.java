package com.pjh.example.algorithm.website;

public class CodilityCRU6HT3RU {
    //https://app.codility.com/c/run/trainingCRU6HT-3RU/

    public static void main(final String[] args){
        System.out.println(solution(9));
    }

        public  static int solution(int N) {
            String binary = Integer.toBinaryString(N);
            char[] binaryChar = binary.toCharArray();

            int max = 0;
            int blackLength = 0;
            for(char c : binaryChar){
                if(c == '1') {
                    if(max < blackLength)
                        max = blackLength;
                    blackLength = 0;
                }
                else
                    blackLength++;
            }
            return max;
        }
    }
