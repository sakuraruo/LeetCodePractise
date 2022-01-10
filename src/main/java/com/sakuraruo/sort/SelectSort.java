package com.sakuraruo.sort;

import java.util.Arrays;

public class SelectSort {
    public static <T extends Comparable> T[] selectSort(T[]array){
        for(int i=0;i< array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j].compareTo(array[j+1])>0){
                    T temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Integer[] integers = {2, 3, 1, 4};
        Arrays.stream(selectSort(integers)).forEach((s)->System.out.println(s));
    }

}
