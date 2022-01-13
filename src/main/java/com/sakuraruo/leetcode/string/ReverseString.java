package com.sakuraruo.leetcode.string;

/***
 * 344 反转字符串
 */
public class ReverseString {
    public static String reverseString(String str){
        char[] chars = str.toCharArray();
        int left=0;
        int right= chars.length-1;
        while(left<right){
            char temp=chars[left];
            chars[left++]=chars[right];
            chars[right--]=temp;
        }
        return chars.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString(new String("asdfg")));
    }
}
