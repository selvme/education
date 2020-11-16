package com.company;

class Insert {

    static void sort(int[] arr){
        int value;
        int indexValue;
        for (int i=1; i<arr.length; i++){
            value = arr[i];
            indexValue = i-1;
            while (indexValue >= 0 && value < arr[indexValue]){
                    arr[indexValue+1] = arr[indexValue];
                    indexValue--;
            }
            arr[++indexValue] = value;
        }
    }
}
