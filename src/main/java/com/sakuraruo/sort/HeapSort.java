package com.sakuraruo.sort;

import java.util.Arrays;

public class HeapSort {
    public static <T extends Comparable> void  sift(T[]array,int low,int high){
        int i=low;
        int j=2*i+1;
        T temp=array[low];
        while(i<=j){
            if(j+1<=high&&array[j+1].compareTo(array[j])>0){
                j=j+1;
            }
            if(temp.compareTo(array[j])<0){
                array[i]=array[j];
                i=j;
                j=2*i+1;
                if(j>high){
                    break;
                }
            }else{
                break;
            }
        }
        array[i]=temp;
    }

    public static void main(String[] args) {
        int n=100;
        Integer[] ints=new Integer[n];
        for(int i=0;i<n;i++){
            ints[i]=(int)(Math.random()*n);
        }
        for(int j=(n-2)/2;j>=0;j--){
            sift(ints,j,n-1);
        }

        for(int m=n-1;m>=0;m--){
            int max=ints[0];
            ints[0]=ints[m];
            ints[m]=max;
            sift(ints,0,m-1);
        }

        Arrays.stream(ints).forEach(System.out::println);

    }
}

