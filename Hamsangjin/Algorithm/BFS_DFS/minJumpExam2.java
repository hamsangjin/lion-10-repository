package com.example.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class minJumpExam2 {
    public static void main(String[] args) {
        System.out.println(bfs(0, 10));
    }
    public static int bfs(int start, int home) {
        Queue<Integer> q = new LinkedList<>();
        int[] ch = new int[10001];

        q.add(0);
        int L = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int x = q.poll();
                for (int nx : new int[]{x+1, x-1, x+5}) {
                    if (nx == home)     return L+1;
                    if(nx >= 0 && ch[nx] == 0){
                        q.add(nx);
                        ch[nx] = 1;
                    }
                }
            }
            L++;
        }

        return 0;
    }
}
