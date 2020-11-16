package com.company;

class Select {

    static void sort(int[] arr){
        int min;
        for (int i=0; i<arr.length; i++){
            min = i;
            for (int j=i+1; j<arr.length-1; j++){
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
