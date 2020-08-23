package com.pjh.example.algorithm.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MarsExploration {

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        char[] formatStr = {'S', 'O', 'S'};
        int result =0;
        char[] charArray = s.toCharArray();


        int count = charArray.length / 3;
        int addedCount = 0;

        for(int i =0; i < count; i++){
            for(char c : formatStr){
                System.out.println("c:" + c);
                System.out.println("charArray[addedCount]:" + charArray[addedCount]);

                if(charArray[addedCount] != c)
                    result++;

                addedCount++;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
