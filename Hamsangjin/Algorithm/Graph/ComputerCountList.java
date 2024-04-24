package com.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComputerCountList {
    static int cnt = 0;
    public static void  dfs(int v, List<Integer>[] graph, boolean[] ch){
        // 해당 노드 방문 표시, 개수 + 1
        ch[v] = true;
        cnt ++;

        // 해당 노드와 연결되어 있는 노드들 방문하는데 -> graph[v][i] == 1
        // 그 중 방문하지 않은 노드들만 방문 -> !ch[i]
        for (int nv : graph[v]) {
            if (!ch[nv]) {
                dfs(nv, graph, ch);
            }
        }
    }

    public static int solution(int n, int[][] edges){
        boolean[] ch = new boolean[n+1];
        List<Integer>[] graph = new List[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] e : edges){
            graph[e[0]].add(e[1]); // v1 -> v2
            graph[e[1]].add(e[0]); // v2 -> v1
        }

        System.out.println(Arrays.toString(graph));

        // 서버 컴퓨터를 기준으로 dfs 호출
        dfs(1, graph, ch);

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
