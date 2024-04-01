package com.example.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class nums2Exam {
    public static void main(String[] args) {
        ArrayList<Integer> temp = new ArrayList<>();
        int[] ch = new int[11];
        dfs(0, 3, 2, temp, ch);
    }

    public static void dfs(int L, int n, int m, List<Integer> temp, int[] ch){
        if(L == m){
            for(int x : temp){
                System.out.print(x + " ");
            }
            System.out.println();
        } else{
            for(int i = 1; i <= n; i++){
                if(ch[i] == 0) {
                    temp.add(i);
                    ch[i] = 1;
                    dfs(L + 1, n, m, temp, ch);
                    temp.removeLast();
                    ch[i] = 0;
                }
            }
        }
    }
}
