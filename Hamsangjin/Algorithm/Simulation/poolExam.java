package com.example.simulation;

public class poolExam {
    public static void main(String[] args) {
        System.out.println(pool(new int [][]{
                {10, 20, 50, 30, 20},
                {20, 30, 50, 70, 90},
                {10, 15, 25, 80, 35},
                {25, 35, 40, 55, 80},
                {30, 20, 35, 40, 90}
        }));

        System.out.println(pool(new int [][]{
                {80, 25, 10, 65, 100},
                {20, 10, 32, 70, 33},
                {45, 10, 88, 9, 90},
                {10, 35, 10, 55, 66},
                {10, 84, 65, 88, 99}
        }));

        System.out.println(pool(new int [][]{
                {33, 22, 55, 65, 55},
                {55, 88, 99, 12, 19},
                {18, 33, 25, 57, 77},
                {46, 78, 54, 55, 99},
                {33, 25, 47, 85, 17}
        }));
    }

    public static int pool(int[][] nums){
        //          상  우  하  좌
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int answer = 0;

        int n = nums.length;
        int m = nums[0].length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                boolean flag = true;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && nums[r][c] >= nums[nr][nc]){
                        flag = false;
                        break;
                    }
                }
                if(flag)    answer++;
            }
        }
        return answer;
    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120866
