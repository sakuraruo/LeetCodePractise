package com.sakuraruo.leetcode;

/****
 * 59 螺旋矩阵
 */
public class SpiralMatrix {
    public static void printSpiralMatrix(int n){
        Integer[][] integers = new Integer[n][n];
        int num=1;
        //横排
        int startx=0;
        //竖排
        int starty=0;
        //每条边遍历的长度
        int offset=1;
        //需要遍历的次数
        int loop=n/2;
        while(loop-->0){
            int i=startx;
            int j=starty;
            for(;i<startx+n-offset;i++){
                //往右画
                integers[j][i]=num++;
            }
            //往下画
            for(;j<starty+n-1;j++){
                integers[j][i]=num++;
            }
            //往左画
            for(;i>startx;i--){
                integers[j][i]=num++;
            }
            //往上画
            for(;j>starty;j--){
                integers[j][i]=num++;
            }

            startx++;
            starty++;

            offset+=2;
        }
        //如果n为奇数 则需要给中间的位置赋值
        if(n%2==1){
            integers[n/2][n/2]=num++;
        }
        System.out.println(integers);
    }

    public static void main(String[] args) {
        printSpiralMatrix(3);
    }
}
