package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int capasity = 10_000;
	    int[] arr = new int[capasity];
	    for (int i=0; i<capasity; i++){
	        arr[i] = (int) (Math.random() * capasity);
        }
//        Bubble.sort(arr);
//        Select.sort(arr);
//        Insert.sort(arr);
        Merge.sort(arr, 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
