package com.example.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class bfsExam {
    public static void main(String[] args) {
        bfs();
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);

        int L = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            System.out.print(L + ": ");
            for (int i = 0; i < n; i++) {
                int x = q.poll();
                System.out.print(x + " ");
                for (int nx = x * 2; nx <= x * 2 + 1; nx++) {
                    if (nx > 7) continue;

                    if(nx > 0)  q.add(nx);
                }
            }
            System.out.println();
            L++;
        }
    }
}
