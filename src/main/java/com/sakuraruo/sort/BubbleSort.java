package com.sakuraruo.sort;

public class BubbleSort {
    public static <T extends Comparable> T[] bubbleSort(T[]array){
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j< array.length;j++){
                if(array[i].compareTo(array[j])>0){
                    T temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Integer[] integers = {2, 1, 4, 3};
        for(int i:bubbleSort(integers)){
            System.out.println(i);
        }
    }
}
