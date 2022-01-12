package com.sakuraruo.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums,int target){
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i:nums){
            map.put(String.valueOf(i),i);
        }
        for(int i:nums){
            Integer integer = map.get(String.valueOf(target - i));
            if(null!=integer){
                return new int[]{i,integer};
            }

        }
        return null;
    }

    public static void main(String[] args) {
        twoSum(new int[]{2,7,11,15},9);
    }
}
