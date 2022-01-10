package com.sakuraruo.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    public static <T extends Comparable>  void  merge(T[]array,int low,int mid,int high){
        int i=low;
        int j=mid+1;
        T[] temp = (T[]) Array.newInstance(Comparable.class, high + 1);
        int count=0;
        while(i<=mid&&j<=high){
            if(array[j].compareTo(array[i])<0){
                temp[count++]=array[j];
                j++;
            }else{
                temp[count++]=array[i];
                i++;
            }
        }
        while(i<=mid){
            temp[count++]=array[i++];
        }
        while(j<=high){
            temp[count++]=array[j++];
        }
        if(temp.length!=0){
            int head=0;
            for(int index=low;index<=high;index++) {
                array[index] = temp[head++];
            }
        }
    }

    public static <T extends Comparable> void mergeSort(T[]array,int low,int high){
        if(low<high){
            int mid=(int)((low+high)/2);
            mergeSort(array,low,mid);
            mergeSort(array,mid+1,high);
            merge(array,low,mid,high);
        }
    }
    public static void main(String[] args) {
        Integer[] integers = new Integer[4];
        for(int i=0;i<4;i++){
            integers[i]=(int)(Math.random()*4);
        }
        mergeSort(integers,0,3);

        Arrays.stream(integers).forEach(System.out::println);

    }
}
