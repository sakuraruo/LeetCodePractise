package com.sakuraruo.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author frank Gao
 * @description
 * @date 2021/12/25
 **/
public class RadixSort {
    public static void radixSort(Integer[]integers,int bitNum){
        List<Integer>[] temp = new ArrayList[10];
        for(int count=0;count<bitNum;count++){
            temp= new ArrayList[10];
            for(int i=0;i<integers.length;i++){
                int index=integers[i]/((int)(Math.pow(10,count)))%10;
                if(temp[index]==null){
                    temp[index]=new ArrayList<>();
                }
                temp[index].add(integers[i]);
            }
            int tempIndex=0;
            for(int j=0;j<10;j++){
                if(null==temp[j]){
                    continue;
                }
                for(Integer t:temp[j]){
                    integers[tempIndex++]=t;
                }
            }
        }
        System.out.println(temp);

    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{112,32,33,51,44};
        radixSort(integers,3);
    }
}