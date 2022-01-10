package com.sakuraruo.sort;

import java.util.Arrays;
import java.util.Random;

/****
 * 快排如果在逆序排序下的效率过低，进行优化，随机选出哨兵
 */
public class QuickSort {
    public static <T extends Comparable> void quickSort(T[] array,int left,int right){
        if(left<right){
            int partition = partition(array,left, right);
            quickSort(array,left,partition-1);
            quickSort(array,partition+1,right);
        }
    }

    private static <T extends Comparable> int partition(T[]array,int left,int right){
        int l=left;
        int r=right;
        T value=array[left];
        while(l<r){
            while((l<r)&&array[r].compareTo(value)>=0){
                r--;
            }
            array[left]=array[right];
            while((l<r)&&array[l].compareTo(value)<=0){
                l++;

            }
            array[right]=array[left];
        }
        array[l]=value;
        return l;
    }

    public static void main(String[] args) {
        Integer[] integers = {1,1,1,2,3,2,3,3};
        //随机选择一个然后 和第一个位置交换
        Random random = new Random(integers.length);
        int nextInt = random.nextInt();
        Integer temp=integers[nextInt];
        integers[nextInt]=integers[0];
        integers[0]=temp;
        //System.out.println(partition(integers,0, integers.length-1));
        quickSort(integers,0, integers.length-1);
        Arrays.stream(integers).forEach(System.out::println);
        /*quickSort(integers,0, integers.length-1);
        Arrays.stream(integers).forEach(System.out::println);*/

    }
}
