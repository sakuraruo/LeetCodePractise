package com.sakuraruo.sort;

public class BinarySearch {
    public static <T> int binarySearch(T[] array,int left,int right,T value){
        while(left<right) {
            int mid = (left + right) / 2;
            if(array[mid]==value){
                return mid;
            }
            binarySearch(array,left,mid-1,value);
            binarySearch(array,mid+1,right,value);
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1,2,3,4};
        System.out.println(binarySearch(integers,0, integers.length, 3));
    }
}
