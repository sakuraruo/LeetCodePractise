package com.sakuraruo.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/****
 * 249
 */
public class IntersectionOfTwoArray {
    public static Set interSection(int[] array1, int[]array2){
        HashSet<Object> set = new HashSet<>();
        for(int i=0;i<array1.length;i++){
            for(int j=0;j< array2.length;j++){
                if(array1[i]==array2[j]){
                    set.add(array1[i]);
                }
            }
        }
        return set;
    }

    public static void main(String[] args) {
        interSection(new int[]{1,2,3,4,3,6,2,1},new int[]{3,3,1});
    }
}
