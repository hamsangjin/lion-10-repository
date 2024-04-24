package com.example.graph;

import java.util.Arrays;

public class ComputerCountMatrix {
    static int cnt = 0;
    public static void dfs(int v, int[][] graph, boolean[] ch, int n){
        // 해당 노드 방문 표시, 개수 + 1
        ch[v] = true;
        cnt ++;

        // 해당 노드와 연결되어 있는 노드들 방문하는데 -> graph[v][i] == 1
        // 그 중 방문하지 않은 노드들만 방문 -> !ch[i]
        for (int i = 1; i <= n; i++) {
            if (graph[v][i] == 1 && !ch[i]) {
                // 해당 노드로 또 dfs 호출
                dfs(i, graph, ch, n);
            }
        }
    }

    public static int solution(int n, int[][] edges){
        boolean[] ch = new boolean[n+1];
        int[][] graph = new int[n+1][n+1];
        for(int[] e : edges){
            graph[e[0]][e[1]] = 1; // v1 -> v2
            graph[e[1]][e[0]] = 1; // v2 -> v1
        }

        // 그래프 출력
        System.out.print("   ");
        for (int i = 0; i <= n; i++) {
            if(i >= 9) System.out.print(i + " ");
            else System.out.print(i + "  ");
        }
        System.out.println();
        for(int i = 0; i <= n; i++) {
            System.out.println(i + " " + Arrays.toString(graph[i]));
        }

        // 서버 컴퓨터를 기준으로 dfs 호출
        dfs(1, graph, ch, n);

        return n - cnt;
    }
    public static void main(String[] args) {
        cnt = 0;
        int answer1 = solution(11, new int[][]{{1, 2}, {1, 4}, {2, 3}, {4, 5}, {5, 6}, {7, 8}, {7, 10}, {8, 9}, {10, 11}});
        System.out.println(answer1);

//        cnt = 0;
//        int answer2 = solution(12, new int[][]{{1, 2}, {1, 7}, {1, 8}, {1, 6}, {8, 11}, {11, 12}});
//        System.out.println(answer2);
//
//        cnt = 0;
//        int answer3 = solution(14, new int[][]{{1, 6}, {1, 5}, {6, 7}, {7, 8}, {9, 8}, {3, 4}, {4, 14}});
//        System.out.println(answer3);
//
//        cnt = 0;
//        int answer4 = solution(15, new int[][]{{1, 4}, {1, 5}, {9, 5}, {9, 6}, {7, 9}, {7, 14}});
//        System.out.println(answer4);
    }
}