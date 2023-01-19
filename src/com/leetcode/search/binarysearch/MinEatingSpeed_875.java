package com.leetcode.search.binarysearch;

public class MinEatingSpeed_875 {

    //h=sum(piles)时,最小值1
    //h=piles.length时, 最大值max(piles)
    public static int minEatingSpeed1(int[] piles, int h) {
        int max = getMax(piles);
        int cost;
        for (int speed = 1; speed< max; speed++){
            cost = getCost(piles, speed);
            if(cost <= h) { return speed;}
        }
        return max;
    }

    //二分查找寻找左边界
    //如果在速度 speed\textit{speed}speed 下可以在 hhh 小时内吃掉所有香蕉，则最小速度一定小于或等于 speed 因此将上界调整为 speed
    //否则，最小速度一定大于 speed, 因此将下界调整为 speed+1
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = getMax(piles);
        int mid;
        while (low < high) {
            mid = low + (high-low)/2;
            if (getCost(piles, mid) <= h) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }



    private static int getCost(int[] piles, int speed) {
        int cost = 0;
        for (int pile: piles) {
            cost += ((pile + speed - 1) / speed);
        }
        return cost;
    }

    private static int getMax(int[] piles) {
        int max = 0;
        for (int pile: piles) max = Math.max(max,pile);
        return max;
    }

    public static void main(String[] args) {
        //从1开始计算的时候, cost会超过int最大值
        int[] piles = new int[]{332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
        int h = 823855818;
        System.out.println(minEatingSpeed(piles,h));

    }
}
