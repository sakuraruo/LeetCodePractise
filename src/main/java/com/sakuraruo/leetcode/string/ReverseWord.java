package com.sakuraruo.leetcode.string;

/****
 * 151 反转字符串内的单词 (要求不能使用额外的空间)
 */
public class ReverseWord {
    /**
     * 使用了split方法使用了额外空间
     * @param str
     * @return
     */
    public static String reverseWord(String str){
        String[] strings = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i=strings.length-1;i>=0;i--){
            builder.append(strings[i]).append(" ");
        }
        return builder.substring(0,builder.length()-1);
    }

    public static String reverseWordCurrent(String str){
        char[] chars = str.toCharArray();
        int i=0;
        while(chars[i]==' '){
            i++;
        }
        int j=chars.length-1;
        while(chars[j]==' '){
            j--;
        }
        int end=j;
        reverseSegment(chars,i,j-i);
        j=i;
        //找到单词的结尾
        while(j<end){
            while(j<=end&&chars[j]!=' '){
                j++;
            }
            //这时候i为单词起点 j为单词结尾
            reverseSegment(chars,i,j-i-1);
            i=j;
            while(i<end&&chars[i]==' '){
                i++;
            }
            j=i;
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
        //System.out.println(reverseWord("I am a programing"));
        System.out.println(reverseWordCurrent("jiling gou wo cao le ni de ma"));
    }
}
