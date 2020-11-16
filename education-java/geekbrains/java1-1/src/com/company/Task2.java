package com.company;
// Создать класс Task_2. Написать статичный метод (с модификатором static), который принимает на вход числа a, b, c, d и возвращает результат выражения a*(b+(c/d)). Проверить этот метод в методе main(…);
public class Task2 {

    public static double calculate(int a, int b, int c, int d){
        double result;
        try{
           result = a*(b+(c/d));
        }catch (Exception e){
            throw new ArithmeticException("Делить на ноль нельзя. Ваша переменная D= " + d);
        }
        return result;
    }

}
