package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = 0;
        int summ = 0;

        while (inputNum != -1){
            inputNum = Integer.parseInt(r.readLine());
            summ += inputNum;
        }
        System.out.println(summ);

    }
}
