package com.company;
//Создать класс Task_4. Написать статичный метод (с модификатором static), который определяет является ли год високосным по следующим правилам: каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й так же високосный. Проверить этот метод в методе main(…);

public class Task4 {
    protected static boolean isVesokosniyYear(int year){
        int result = year%400;
        if (result == 0){
            return true;
        }
        result %= 100;
        result %= 4;
        return result == 0;
    }
}
