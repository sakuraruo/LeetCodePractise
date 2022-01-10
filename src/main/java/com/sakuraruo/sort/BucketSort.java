package com.sakuraruo.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class BucketSort {
    public static Integer[] bucketSort(Integer[]array,int num,int maxNum){
        ArrayList<Integer>[] bucket = new ArrayList[num];
        Arrays.stream(array).forEach(value->{
            int index=Math.min((value/(maxNum/num)),num-1);
            //create dy list
            if(bucket[index]==null){
                bucket[index]=new ArrayList<Integer>();
            }
            int size=bucket[index]==null?0:bucket[index].size();
            bucket[index].add(value);
            int i=-1;
            //resort after insert
            for(i=size;i>0;i--){
                if(bucket[index].get(i)<bucket[index].get(i-1)){
                    bucket[index].set(i,bucket[index].get(i-1));
                }else{
                    break;
                }
            }
            bucket[index].set(i,value);
        });
        int sum=0;
        for(int i=0;i<num;i++){
            int j=0;
            while(j<bucket[i].size()){
                array[sum++]=bucket[i].get(j);
                j++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[1000000];
        for(int i=0;i<1000000;i++){
            integers[i]=(int) (Math.random()*10000000);
        }
        Arrays.stream(bucketSort(integers, 100, 10000000)).forEach(System.out::println);

    }
}
