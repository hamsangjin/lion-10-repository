package com.example.graph;

/*
그래프: 정점(Vertext)과 간선(Edge)의 집합을 의미
• 연결되어 있는 원소들간의 관계를 표현하는 자료구조이다.

2. 인접리스트 : 연결리스트을 이용해 그래프를 표현하는 방법
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphList {
    public static void main(String[] args) {
        // 정점 개수
        int n = 5;

        // 1. 무방향 그래프
        // 간선
        int[][] edge1 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 4}};
        List<Integer>[] graph1 = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph1[i] = new ArrayList<>();
        }

        // 초기 그래프 출력
        System.out.println(Arrays.toString(graph1));

        for(int[] e : edge1){
            graph1[e[0]].add(e[1]); // v1 -> v2
            graph1[e[1]].add(e[0]); // v2 -> v1
        }

        // 관계를 적용한 그래프 출력
        System.out.println(Arrays.toString(graph1));

        System.out.println();
        System.out.println("---------------");
        System.out.println();

        // 2. 방향 그래프
        // 간선
        int[][] edge2 = {{1, 2}, {1, 3}, {2, 5}, {3, 4}, {4, 2}};
        List<Integer>[] graph2 = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph2[i] = new ArrayList<>();
        }

        // 초기 그래프 출력
        System.out.println(Arrays.toString(graph2));

        for(int[] e : edge2){
            graph2[e[0]].add(e[1]); // v1 -> v2
        }

        // 관계를 적용한 그래프 출력
        System.out.println(Arrays.toString(graph2));

        System.out.println();
        System.out.println("---------------");
        System.out.println();
    }
}