package com.sakuraruo.leetcode.queueandstack;

/**
 * 42 接雨水
 */
public class TrappingRainWater {
    //双指针解法
    public static int[] trapRainWater(int[] nums){
        int[] ints = new int[nums.length];
        ints[0]=0;
        ints[nums.length-1]=0;
        for(int i=1;i< nums.length-1;i++){
            int now=nums[i];
            int left=i-1;
            int right=i+1;
            while(left-1>=0){
                if(nums[left]<nums[left-1]){
                    left--;
                }else{
                    break;
                }
            }

            while(right+1<nums.length){
                if(nums[right]<nums[right+1]){
                    right++;
                }else{
                    break;
                }
            }
            int min = Math.min(nums[left], nums[right]);
            if(min>now){
                ints[i]=min-now;
            }else{
                ints[i]=0;
            }
        }
        return ints;
    }

    //动态规划解法


    //单调栈解法

    public static void main(String[] args) {
        //int[] ints = {1, 0, 2, 1, 3, 1, 0, 1, 2, 0, 1};
        int[] ints = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] rainWater = trapRainWater(ints);
        System.out.println(rainWater);
    }
}
