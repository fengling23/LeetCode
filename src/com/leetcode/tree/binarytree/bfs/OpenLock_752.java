package com.leetcode.tree.binarytree.bfs;

import java.util.*;

public class OpenLock_752 {
    public static void main(String[] args) {
        String[] deadends = new String[]{"2111","2202","2210","0201","2210"};
        String target = "2201";
        System.out.println(new OpenLock_752().openLock(deadends,target));
    }
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) return 0;
        Set<String> deadendSet = new HashSet<>();
        for (String deadend: deadends) deadendSet.add(deadend);
        if (deadendSet.contains("0000")) return -1;

        Set<String> visitedSet = new HashSet<>();
        visitedSet.add("0000");
        Queue<String> paths = new LinkedList<>();
        paths.offer("0000");
        int step = 0;

        while(!paths.isEmpty()) {

            int n = paths.size();
            for (int i = 0; i < n; i++) {
                String path = paths.poll();
                if (deadendSet.contains(path)) continue;
                if (path.equals(target)) return step;

                for (int j = 0; j < 4; j++) {
                    char[] numbers = path.toCharArray();
                    char num = numbers[j];
                    numbers[j] = numPrev(num);
                    String up = new String(numbers);
                    if (!visitedSet.contains(up)) {
                        paths.offer(up);
                        visitedSet.add(up);
                    }
                    numbers[j] = numNext(num);
                    String down = new String(numbers);
                    if (!visitedSet.contains(down)) {
                        paths.offer(down);
                        visitedSet.add(down);
                    }
                }
            }
            ++step;
        }

        return -1;
    }

    private char numNext(char num) {
        return num == '9' ? '0' : (char) (num + 1);
    }

    private char numPrev(char num) {
        return num == '0' ? '9' : (char) (num - 1);
    }
}
