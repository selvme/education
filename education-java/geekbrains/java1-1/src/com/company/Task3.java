package com.company;
// Создать класс Task_3. Написать статичный метод (с модификатором static), который принимает на вход два числа, проверяет, лежит ли их сумма в пределах от 10 до 20, и возвращает true или false. Проверить этот метод в методе main(…);
public class Task3 {
    public static boolean inRange(int ... numbers){
        int result = 1;
        for (int num : numbers){
            if (num > 10 && num < 20){
                result *= 1;
            }else {
                result *= 0;
            }
        }
        return result == 1;
    }
}
