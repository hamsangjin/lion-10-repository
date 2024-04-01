package com.example.dfsbfs;

public class dfsExam {
    public static void main(String[] args) {
        dfs(1);
    }

    public static void dfs(int v){
        if(v <= 7){
            System.out.print(v + " ");
            dfs(v*2);
            dfs(v*2+1);
        }
    }
}
