package com.example.simulation;

// 시뮬레이션
// 작은 의미로는 문제가 제시한 규칙에 따라 개체를 이동시키는 알고리즘을 말하며,
// 큰 의미로는 문제가 요구하는 대로 시행되도록 코드를 구현하는 알고리즘
public class simulation {
    public static void main(String[] args) {
                // 상  우  하  좌
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // 탐색할 배열
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // 1 2 3
        // 4 5 6
        // 7 8 9
        // 시작 위치 -> [1, 1] = 5
        int r = 1, c = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];
            System.out.println((i+1) + "번째 좌표는 [" + nr + ", " + nc + "] 이며, 해당 좌표의 값은 " + arr[nr][nc] + "입니다.");
        }
    }
}
