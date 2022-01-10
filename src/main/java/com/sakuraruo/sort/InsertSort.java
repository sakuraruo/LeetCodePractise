package com.sakuraruo.sort;

import java.util.Arrays;

public class InsertSort {
    public static <T extends Comparable> T[] insertSort(T[] array){
        for(int i=0;i< array.length;i++){
            int index=i;
            T temp=array[i];
            while(index>0){
                if(temp.compareTo(array[index-1])<0){
                    array[index]=array[index-1];
                    index--;
                }else{
                    break;
                }
            }
            array[index]=temp;
        }
        return array;
    }

    public static void main(String[] args) {
        //2 3 4 1
        Integer[] integers = {2, 4, 3, 1};
        Arrays.stream(insertSort(integers)).forEach((s)->System.out.println(s));
    }
}
