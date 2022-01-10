package com.sakuraruo.sort;

import java.util.Arrays;

public class CountSort {
    public static int[] countSort(int[]array,int max){
        int[] ints = new int[max];
        Arrays.stream(array).forEach((value -> {
            ints[value]++;
        }));
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = new int[1000];
        for(int i=0;i<1000;i++){
            ints[i]=(int)(Math.random()*20);
        }
        int[] sort = countSort(ints, 20);
        for( int j=0;j<20;j++){
            for(int k=sort[j];k>=0;k--){
                System.out.println(j);
            }
        }
    }
}
