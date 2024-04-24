package com.example.thegame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 진행별 기능 객체 ?
public class GameProgress {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    private TableCard tableCard;
    private Deck deck;
    private UserCard userCard;

    public void startGame() throws IOException {
        System.out.println("\n세팅을 시작합니다.");
        setFirst();

        while (true) {
            if (endOfGame()) break;

            showAll();
            int numberOfCard;
            try {
                System.out.print("\n★★★★★ 몇 장의 카드를 제출하시겠습니까? ");
                numberOfCard = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                continue;
            }

            if (!checkNumberOfCards(numberOfCard)) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                continue;
            }

            if (!submitCard(numberOfCard)) break;

            System.out.println(numberOfCard + "번의 카드 제출 완료");

            // 제출 횟수 만큼 덱에서 유저에게 카드 추가 후 정렬
            addDeckToUser(numberOfCard);
            userCard.sortUserCard();
        }

        calculateScore();
    } // 게임 시작


    // 지정한 수 만큼의 카드를 낼 수 있는지 (덱이 남아 있으면 2장 이상, 없으면 1장 이상)
    public boolean checkNumberOfCards(int n) {
        if (deck.restOfDeck() > 0) {
            if (n >= 2 && n <= userCard.getUserCard().size()) {
                return true;
            }
        } else {
            if (n >= 1 && n <= userCard.getUserCard().size()) {
                return true;
            }
        }

        return false;
    }

    public boolean submitCard(int numberOfCard) throws IOException {
        // 알맞은 형식의 제출은 약속인걸로..
        int index = 0;
        while (index != numberOfCard) {
            showAll();
            if (endOfGame()) return false;

            System.out.print("\n몇 번째 위치에 어떤 카드를 제출하겠습니까? (남은 횟수:" + (numberOfCard - index) + ") -> ");
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken()) - 1;
            int card = Integer.parseInt(st.nextToken());

            // card가 유저의 카드에 있는지 검사해야됨
            if (!userCard.haveCard(card)) continue;

            if (checkCard(pos, card)) {
                tableCard.setCard(pos, card);
                userCard.removeCard(card);
                index++;
            } else {
                System.out.println("다시 입력해주세요.");
            }
        }

        // 정상적으로 끝나면 true
        return true;
    } // 카드 제출

    // 제출한 형식으로 카드를 낼 수 있는지 boolean
    public boolean checkCard(int pos, int card) {
        if (pos == 0 || pos == 1) {
            return card > tableCard.getSpecificCard(pos) || (card + 10) == tableCard.getSpecificCard(pos);
        } else if (pos == 2 || pos == 3) {
            return card < tableCard.getSpecificCard(pos) || (card - 10) == tableCard.getSpecificCard(pos);
        }

        return false;
    }

    public void addDeckToUser(int numberOfCard) {
        for (int i = 0; i < numberOfCard; i++) {
            try {
                int deckCard = deck.getDeck();
                userCard.addCard(deckCard);
            } catch (NoSuchElementException e) {
                break;
            }
        }
    }

    // 게임 종료 조건, 낼 수 없을 때 true
    public boolean endOfGame() {
        // 1. 모든 카드를 내려놓았을 때
        if (deck.restOfDeck() + userCard.getUserCard().size() == 0) return true;

        // 2. 모든 카드를 낼 수 없을 때
        List<Integer> userCards = userCard.getUserCard();
        int limit = 0;

        for (int card : userCards) {
            for (int i = 0; i < 4; i++) {
                if (!checkCard(i, card)) limit++;
            }
        }

        if (limit == userCards.size() * 4) {
            System.out.println("\n당신은 더 이상 카드를 낼 수 없습니다 !");
            return true;
        } else {
            return false;
        }
    }

    public void setFirst() {
        this.tableCard = new TableCard();
        this.deck = new Deck();
        this.userCard = new UserCard();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(deck.getDeck());
        }
        Collections.sort(list);
        userCard.setUserCard(list);
    } // 맨 처음 세팅

    public void showAll() {
        System.out.println("----------------------------------------");
        showTableCard();
        showUserCard();
    } // showTableCard() + showUserCard()

    public void showTableCard() {
        int[] table = tableCard.getCard();
        int index = 0;

        System.out.print("현재 테이블 위 카드 : [ ");
        for (int card : table) {
            System.out.print(card + " ");
            if (++index == 2) {
                System.out.print("| ");
            }
        }
        System.out.println("]");
        System.out.println("남은 덱 수 : " + deck.restOfDeck());
    } // 놓인 카드, 남은 덱 수 show

    public void showUserCard() {
        List<Integer> list = userCard.getUserCard();
        System.out.print("당신의 카드 : [ ");
        for (int card : list) {
            System.out.print(card + " ");
        }
        System.out.println("]");
    } // 보유 카드 show

    public void calculateScore() {
        int score = deck.restOfDeck() + userCard.getUserCard().size();

        if (score <= 5) {
            System.out.println("당신의 점수는 " + score + "점 입니다.");
            System.out.println("꽤 좋은 머리를 가졌군요 !");
        } else {
            System.out.println("당신의 점수는 " + score + "점 입니다.");
            System.out.println("좀 더 분발하세요 !");
        }
    } // 스코어 계산 출력

    // -----------------
    public void showRule() {
        System.out.println("--------- 게임 설명 ---------");
        System.out.println("더 게임은 최대한 많은 카드를 내려놓는 게임입니다.");
        System.out.println("\n테이블에 1카드 두 장, 100카드 두 장이 있습니다.");
        System.out.println("가운데에는 2~99 카드를 섞어 뒤집어놓은 덱이 있고,");
        System.out.println("처음엔 그 중 8장을 플레이어에게 나누어 드립니다.");
        System.out.println("당신은 반드시 2장 이상의 카드를 내고");
        System.out.println("낸 장수 만큼의 카드를 덱에서 가져와야 합니다.");
        System.out.println("\n- 오름차순 카드열 -");
        System.out.println("1로 시작하는 오름차순 카드열에는 놓여있는 카드보다 높은 숫자");
        System.out.println("혹은 놓여있는 카드와 정확히 10 차이의 낮은 카드를 낼 수 있습니다.");
        System.out.println("\n- 내림차순 카드열 -");
        System.out.println("100으로 시작하는 내림차순 카드열에는 놓여있는 카드보다 낮은 숫자");
        System.out.println("혹은 놓여있는 카드와 정확히 10 차이의 높은 카드를 낼 수 있습니다.");
        System.out.println("\n덱에 카드가 다 떨어졌다면, 그 순간부터 카드를 한 장만 내도 됩니다.");
        System.out.println("게임 종료 조건은 다음과 같습니다.");
        System.out.println("1. 당신이 정해진 장 수의 카드를 낼 수 없을 때");
        System.out.println("2. 모든 카드를 내려놓았을 때");
        System.out.println("\n남은 덱 수와 손에 남은 카드 장수를 합한게 총 점수입니다.");
        System.out.println("당연히 점수는 낮을수록 잘한거겠죠?\n");
    } // 게임 설명 메소드

}
