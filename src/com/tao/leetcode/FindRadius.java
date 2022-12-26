package com.tao.leetcode;

import java.util.Arrays;

public class FindRadius {

    public static void main(String[] args) {
        int[] houses = {12};
        int[] heaters = {2,30};
        System.out.println(solution1(houses,heaters));
    }

    /*输入：
            [1,2,3,5,15]
            [2,30]
    输出：
            15
    预期结果：
            13*/
    public  static int solution1(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        if(houses.length ==1 ) {
            int maxHouseHeaterGap = 0;
            for (int i = 0; i < heaters.length; i++) {
                maxHouseHeaterGap = Math.max(maxHouseHeaterGap, Math.abs(houses[0]-heaters[i]));
            }
            return  maxHouseHeaterGap;
        }

        if (heaters.length==1){return Math.max(Math.abs(houses[0]-heaters[0]), Math.abs(houses[houses.length-1]-heaters[0]));}

        int leftRadius = Math.abs(houses[0]-heaters[0]);
        int rightRadius = Math.abs(houses[houses.length-1]-heaters[heaters.length-1]);
        int maxHeaterGap = 0;
        for (int i = 1; i < heaters.length; i++) {
            maxHeaterGap = Math.max(maxHeaterGap,heaters[i]-heaters[i-1]);
        }
        int midRadius = maxHeaterGap/2;
        return Math.max(midRadius,Math.max(leftRadius, rightRadius));
    }

    public static int solution2(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
    
        if (houses.length == 1) {
            int maxHouseHeaterGap = 0;
            for (int i = 0; i < heaters.length; i++) {
                maxHouseHeaterGap = Math.max(maxHouseHeaterGap, Math.abs(houses[0] - heaters[i]));
            }
            return maxHouseHeaterGap;
        }
    
        if (heaters.length == 1) {
            return Math.max(Math.abs(houses[0] - heaters[0]), Math.abs(houses[houses.length - 1] - heaters[0]));
        }
    
        int leftRadius = Math.abs(houses[0] - heaters[0]);
        int rightRadius = Math.abs(houses[houses.length - 1] - heaters[heaters.length - 1]);
    
        int maxHeaterGap = 0;
        int maxGapIndex = 0;
        for (int i = 1; i < heaters.length; i++) {
            if (heaters[i] - heaters[i - 1] > maxHeaterGap) {
                maxHeaterGap = heaters[i] - heaters[i - 1];
                maxGapIndex = i;
            }
        }
        int midRadius = maxHeaterGap / 2;
    
        return Math.max(midRadius, Math.max(leftRadius, rightRadius));
    }
    
}
