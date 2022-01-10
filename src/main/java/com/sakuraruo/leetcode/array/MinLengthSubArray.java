package com.sakuraruo.leetcode.array;

/**
 * 209.长度最小的子数组
 */
public class MinLengthSubArray {
    //暴力破解法
    public static int minLengthSubArray1(Integer[] arrays,int sum){
        int length=arrays.length;
        int result=-1;
        for(int i=0;i<length;i++){
            int tempSum=0;
            for(int j=i;j<length;j++){
                tempSum+=arrays[j];
                if(tempSum>=sum){
                    //如果result为初始值 直接覆盖
                    if(result==-1){
                        result=j-i;
                    }
                    //如果result当前不为初始值 且j小于result
                    if(result!=-1&&(j-i+1)<result){
                        result=j-i+1;
                    }
                }
            }
        }
        return result;

    }

    /****
     * 滑动窗口法
     * @param arrays
     * @param sum
     * @return
     */
    public static int minLengthSubArray2(Integer[] arrays,Integer sum){
        int length = arrays.length;
        int minArrayLength=0;
        int result=Integer.MAX_VALUE;
        int tempSum=0;
        int j=0;
        for(int i=0;i<length;i++){
            tempSum+=arrays[i];
            //当窗口内的值大于sum 开始滑动
            while(tempSum>=sum){
                minArrayLength=i-j+1;
                result=result<minArrayLength?result:minArrayLength;
                tempSum-=arrays[j++];

            }

        }
        return result==Integer.MAX_VALUE?-1:result;
    }

    public static void main(String[] args) {
        Integer[] integers = {4, 6, 2, 4, 9, 8, 7};
        //System.out.println(minLengthSubArray1(integers,124));
        System.out.println(minLengthSubArray2(integers,18));
    }
}
