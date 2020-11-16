package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        short num1 = Short.parseShort(r.readLine());
        short num2 = Short.parseShort(r.readLine());
        short num3 = Short.parseShort(r.readLine());

        if (num1 == num2 && num1 == num3){
            System.out.println(num1);
        }

        if (num1 > num2 && num1 < num3 || num1 < num2 && num1 > num3){
            System.out.println(num1);
        }else {
            if (num2 == num3 || num2 == num1){
                System.out.println(num2);
            }

            if (num1 == num2 || num1 == num3){
                System.out.println(num1);
            }

            if (num3 == num1 || num3 == num2){
                System.out.println(num1);
            }
        }
        if (num2 > num1 && num2 < num3 || num2 < num1 && num2 > num3){
            System.out.println(num2);
        }else {
            if (num2 == num3 || num2 == num1){
                System.out.println(num2);
            }

            if (num1 == num2 || num1 == num3){
                System.out.println(num1);
            }

            if (num3 == num1 || num3 == num2){
                System.out.println(num1);
            }
        }
        if (num3 > num2 && num3 < num1 || num3 < num2 && num3 > num1){
            System.out.println(num3);
        }else {
            if (num2 == num3 || num2 == num1){
                System.out.println(num2);
            }

            if (num1 == num2 || num1 == num3){
                System.out.println(num1);
            }

            if (num3 == num1 || num3 == num2){
                System.out.println(num1);
            }
        }
    }
}
