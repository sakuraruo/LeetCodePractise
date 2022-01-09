package com.sakuraruo.leetcode;

/***
 * LeetCode 第27题移除数组中的元素 用快慢指针实现 最终返回移除之后到底剩余元素个数 也就是慢指针移动的位置
 */
public class RemoveElement {
    public static void removeEle(Integer[] array,Integer ele){
        int length = array.length;
        int slowIndex=0;
        for(int fastIndex=0;fastIndex<length;fastIndex++){
            if(ele!=array[fastIndex]){
                array[slowIndex++]=array[fastIndex];
            }
        }
        System.out.println(slowIndex);
    }

    public static void main(String[] args) {
        Integer[] integers = {4, 5, 6, 4, 4, 4};
        removeEle(integers,4);
        //Arrays.stream(integers).forEach(System.out::println);
    }
}
