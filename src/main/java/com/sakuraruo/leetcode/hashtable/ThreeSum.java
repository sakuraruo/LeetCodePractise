package com.sakuraruo.leetcode.hashtable;


import java.util.Arrays;
import java.util.LinkedList;

/***
 * 15 三数之和 双指针法
 */
public class ThreeSum {
    public static LinkedList threeSum(int[] nums){
        return solution(nums,0);
    }
    public static LinkedList solution(int[] nums,int target){
        LinkedList<LinkedList> result = new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0;i< nums.length;i++){
            if(nums[i]>0){
                return result;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }

            int left=i+1;
            int right= nums.length-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else{
                    if(nums[i]+nums[left]+nums[right]==target){
                        LinkedList<Integer> list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                    }

                    while(left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    while(left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    left++;
                    right--;

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

}
