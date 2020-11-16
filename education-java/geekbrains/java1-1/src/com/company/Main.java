package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(Task2.calculate(1, 5, 0 , 1));

        System.out.println(Task3.inRange(10, 20 ,11));
        System.out.println(Task3.inRange(10, 20 ,110));
        System.out.println(Task3.inRange(11, 12, 16));
        System.out.println(Task3.inRange(11, 12, 118));

        System.out.println(Task4.isVesokosniyYear(2001));
        System.out.println(Task4.isVesokosniyYear(2004));
        System.out.println(Task4.isVesokosniyYear(1996));
    }

}
