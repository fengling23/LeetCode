package com.leetcode.sort;

import java.util.*;

public class BucketSort {

    public static void main(String[] args) {
        // 输入元素均在 [0, 10) 这个区间内
        float[] arr = new float[] { 0.12f, 2.2f, 8.8f, 7.6f, 7.2f, 6.3f, 9.0f, 1.6f, 5.6f, 2.4f };
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //数组加链表的结构
    private static void bucketSort(float[] arr) {
        List<LinkedList<Float>> list = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }

        for (float value: arr) {
            int index = getBucketIndex(value);
            insertSort(list.get(index), value);
        }
        int i = 0;
        for (LinkedList<Float> bucket: list) {
            for (Float value: bucket) {
                arr[i++] = value;
            }
        }
    }

    /**
     * 计算得到输入元素应该放到哪个桶内
     */
    public static int getBucketIndex(float data) {
        // 这里例子写的比较简单，仅使用浮点数的整数部分作为其桶的索引值
        // 实际开发中需要根据场景具体设计
        return (int) data % 10;
    }

    /**
     * 我们选择插入排序作为桶内元素排序的方法 每当有一个新元素到来时，我们都调用该方法将其插入到恰当的位置
     */
    public static void insertSort(LinkedList<Float> bucket, float data) {
        ListIterator<Float> it = bucket.listIterator();
        boolean tailFlag = true;
        while (it.hasNext()) {
            if (data < it.next()) {
                it.previous(); // 把迭代器的位置偏移回上一个位置
                it.add(data); // 把数据插入到迭代器的当前位置
                tailFlag = false;
                break;
            }
        }
        if (tailFlag) {
            bucket.add(data); // 否则把数据插入到链表末端
        }
    }


}
