package com.sakuraruo.leetcode.string;

public class KmpStr {
    private static void getNext(int[] next,String str){
        int j=-1;
        next[0]=j;
        char[] chars = str.toCharArray();
        for(int i=1;i<str.length();i++){
            //前后缀不相同
            while(j>=0&&chars[i]!=chars[j+1]){
                j=next[j];
            }
            //找到相同的前后缀
            if(chars[i]==chars[j+1]){
                j++;
            }
            next[i]=j;
        }
    }

    public static int str(String str,String subStr){
        char[] strArr = str.toCharArray();
        char[] subStrArr = subStr.toCharArray();
        if(str.length()==0){
            return -1;
        }
        int[] next = new int[subStr.length()];
        int j=-1;
        getNext(next,subStr);
        for(int i=0;i<str.length();i++){
            while(j>=0&&strArr[i]!=subStrArr[j+1]){
                j=next[j];
            }
            if(strArr[i]==subStrArr[j+1]){
                j++;
            }
            if(j==(subStrArr.length-1)){
                return (i- subStrArr.length+1);
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(str(new String("aabaabaafa"),new String("aabaaf")));
    }
}
