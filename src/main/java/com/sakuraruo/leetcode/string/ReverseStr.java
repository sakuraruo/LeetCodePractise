package com.sakuraruo.leetcode.string;

/***
 *541 分段反转字符串
 */
public class ReverseStr {
    public static String reverseStr(String str,int k){
        char[] chars = str.toCharArray();
        int length= chars.length;
        int i=0;
        for(;i<length/(2*k);i++){
            reverseSegment(chars,2*k*i,k-1);
        }
        //剩下小于2k的字符
        int j = length % (2*k);
        int start=k*(i+1);
        //当剩余大于等于k
        if(j>=k){
            //剩余大等于k 反转k个
            reverseSegment(chars,start,k-1);
        }else{
            //剩余小于k 反转所有
            reverseSegment(chars,start,j-1);
        }


        return chars.toString();
    }

    public static void reverseSegment(char[]array,int left,int k){
        int l=left;
        int r=left+k;
        while(l<r){
            char temp=array[l];
            array[l++]=array[r];
            array[r--]=temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("asdfghjklw",3));
    }
}
