package com.sakuraruo.sort;

import java.util.Arrays;

/**
 * Shell排序相当于是分组的插入排序
 */
public class ShellSort {
    public static <T extends Comparable> void inserSortGap(T []array,int gap){
        for(int i=0;i<array.length;i++){
            T temp=array[i];
            int j=i-gap;
            while(j>=0){
                if(array[j].compareTo(temp)>0){
                    array[j+gap]=array[j];
                    j-=gap;
                }else{
                    break;
                }
            }
            array[j+gap]=temp;
        }
    }
    public static void main(String[] args) {
//        Integer[] integers = {2, 4, 3, 1};
//        inserSortGap(integers,1);
//        Arrays.stream(integers).forEach(System.out::println);
        Integer[] integers = new Integer[20];
        for(int i=0;i<20;i++){
            integers[i]=(int)(Math.random()*20);
        }
        int d=integers.length/2;
        while(d>0){
            inserSortGap(integers,d);
            d/=2;
        }
        Arrays.stream(integers).forEach(System.out::println);

    }
}
