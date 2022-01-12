package com.sakuraruo.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 242
 */
public class ValidAnagram {
    public static boolean isValidAnagram(String src,String des){
        HashMap<Character, Integer> charMap = new HashMap<>();
        char[] chars = src.toCharArray();
        //将字符散列到hash表中
        for(int i=0;i< chars.length;i++){
            Integer integer = charMap.get(chars[i]);
            if(null!=integer){
                charMap.put(chars[i],++integer);
            }else{
                charMap.put(chars[i],1);
            }
        }

        char[] charArray = des.toCharArray();
        for(int j=0;j<charArray.length;j++){
            Integer integer = charMap.get(chars[j]);
            if(null!=integer){
                charMap.put(chars[j],--integer);
            }else{
                //存在src中不存在的字符
                return false;
            }
        }

        Set<Map.Entry<Character, Integer>> set = charMap.entrySet();
        for(Map.Entry<Character, Integer> entry:set){
            if(entry.getValue()!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidAnagram("asd","asd"));
    }
}
