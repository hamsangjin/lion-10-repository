package com.example.graph;

/*
그래프: 정점(Vertext)과 간선(Edge)의 집합을 의미
• 연결되어 있는 원소들간의 관계를 표현하는 자료구조이다.

1. 인접행렬 : 2차원 배열을 이용해 그래프를 표현하는 방법
*/

public class GraphMatrix {
    public static void main(String[] args) {

        // 정점 개수
        int n = 5;

        // 1. 무방향 그래프
        // 간선
        int[][] edge1 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 4}};
        int[][] graph1 = new int[n+1][n+1];
        for(int[] e : edge1){
            graph1[e[0]][e[1]] = 1; // v1 -> v2
            graph1[e[1]][e[0]] = 1; // v2 -> v1
        }

        // 그래프 출력
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print(graph1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("---------------");
        System.out.println();

        // 2. 방향 그래프
        // 간선
        int[][] edge2 = {{1, 2}, {1, 3}, {2, 5}, {3, 4}, {4, 2}};
        int[][] graph2 = new int[n+1][n+1];
        for(int[] e : edge2){
            graph2[e[0]][e[1]] = 1; // v1 -> v2
        }

        // 그래프 출력
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print(graph2[i][j] + " ");
            }
            System.out.println();
        }
    }
}