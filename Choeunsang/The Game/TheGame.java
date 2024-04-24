package com.example.thegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        System.out.println("더 게임을 참여해주셔서 감사합니다.");
        // 게임 진행
        while (true) {
            GameProgress gameProgress = new GameProgress();

            System.out.println("\n# 다음 3가지 중 선택해주세요.");
            System.out.print("1.시작 2.게임 설명 3.게임 종료 | 숫자 입력 : ");
            int n;
            try {
                n = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                continue;
            }

            switch (n) {

                case 1: // 게임 시작
                    gameProgress.startGame();
                    break;

                case 2: // 게임 설명
                    gameProgress.showRule();
                    break;

                case 3: // 게임 종료
                    System.out.println("게임을 종료합니다.");
                    System.exit(1);

                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    break;
            }
        }
    }
}
