package com.sakuraruo.leetcode.hashtable;

import java.util.HashMap;

/****
 * 454
 */
public class FourSum {
    public static int fourSum(int []a,int[]b,int[]c,int[]d ){
        HashMap<String,Integer> map = new HashMap<>();
        for(int i1:a){
            for(int i2:b){
                Integer integer = map.get(String.valueOf(i1 + i2));
                if(null!=integer){
                    map.put(String.valueOf(i1+i2),++integer);
                }else{
                    map.put(String.valueOf(i1+i2),1);
                }
            }
        }
        int count=0;
        for(int i3:c){
            for(int i4:d){
                Integer integer = map.get(String.valueOf(0 - (i3 + i4)));
                if(null!=integer){
                    count+=integer;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{3,1,4},new int[]{-2,4,3},new int[]{-1,3,2},new int[]{3,-2,0}));
    }
}
