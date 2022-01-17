package com.sakuraruo.leetcode.queueandstack;

import java.util.ArrayDeque;

/****
 * 239 滑动窗口的最大值
 */
public class SlidingWindow {
    public static int[] maxNumArray(int[] array,int k){

        int[] ints = new int[array.length - k+1];
        ArrayDeque<Integer> deque = new ArrayDeque<>(k);
        int i=0;
        //入单调队列
        while(i<k-1){
            //当尾部不为空 且当前下标下的值大于队列尾部值
            while((!deque.isEmpty())&&array[i]>deque.getFirst()){
                deque.removeFirst();
            }
            deque.push(array[i++]);
        }

        //滑动窗口
        int j=0;
        for(;i<array.length;i++){
            if(array[j]== deque.getLast()){
                deque.removeLast();
            }
            boolean flag=false;
            while((!deque.isEmpty())&&array[i]>deque.getFirst()){
                deque.removeFirst();
                flag=true;
            }
            if(flag){
                deque.push(array[i]);
            }
            //最大值数组赋值
            ints[j]=deque.getLast();
            j++;
        }

        return ints;
    }

    public static void main(String[] args) {
        int[] ints = maxNumArray(new int[]{2, 4, -2, -4, 3, 1, 5}, 4);
        System.out.println(ints);
    }
}
