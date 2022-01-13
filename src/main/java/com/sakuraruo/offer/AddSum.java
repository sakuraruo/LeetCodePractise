package com.sakuraruo.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指offer 081
 * @author frank Gao
 * @description
 * @date 2022/1/12
 **/
public class AddSum {
    public static void solution(int[] nums,int target){
        ArrayList<List> result = new ArrayList<List>();
        LinkedList<Integer> combine = new LinkedList<>();
        combine(nums,target,0,result,combine);
        System.out.println(result.size());
    }

    private static void combine(int[] nums,int target,int i,List result,LinkedList combine){
        if(target==0){
            result.add(new LinkedList(combine));
            return;
        }else if(target<0){
            return ;
        }

        for(int j=i;j< nums.length;j++){
            combine.add(nums[j]);
            combine(nums,target-nums[j],j,result,combine);
            combine.removeLast();
        }
    }

    public static void main(String[] args) {
        /**
         * 输入: candidates = [2,3,6,7], target = 7
         * 输出: [[7],[2,2,3]]
         */
        int[] nums=new int[]{2,3,6,7};
        solution(nums,7);

    }
}
