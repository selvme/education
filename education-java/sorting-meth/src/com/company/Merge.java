package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Merge {

    static void sort(int[] arr, int start, int end){
        if (start < end){
            int mid = start + (end - start) / 2;
            sort(arr, start, mid);
            sort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end){
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int l = 0;
        int r = 0;
        for (int i = start; i<=mid; i++){
            left.add(arr[i]);
        }
        for (int i = mid+1; i<=end; i++){
            right.add(arr[i]);
        }
        left.add(Integer.MAX_VALUE);
        right.add(Integer.MAX_VALUE);

        for (int i = start; i<=end; i++){
            if (left.get(l) <= right.get(r)){
                arr[i] = left.get(l);
                l++;
            }else {
                arr[i] = right.get(r);
                r++;
            }
        }
    }
}
