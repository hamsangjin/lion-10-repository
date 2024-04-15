package com.example.day21.Example;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCollectionExam {
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        readWords();
        removeQuit();
        printScores();
    }

    public static void readWords(){
        Scanner sc = new Scanner(System.in);

        String str = "";
        while(!str.equals("quit")){
            System.out.print("단어를 하나 입력해주세요. : ");
            str = sc.next();
            list.add(str);
        }
        sc.close();
    }

    public static void removeQuit(){
        list.remove(list.size()-1);
    }

    public static void printScores(){
        int charSum = 0;
        int charMax = 0;

        for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i);
            System.out.println(temp);

            charSum += temp.length();
            if(list.get(charMax).length() < list.get(i).length())   charMax = i;

        }
        System.out.println("가장 긴 단어는 " + list.get(charMax) + "이며, 길이는 " + list.get(charMax).length() + "입니다.");
        System.out.println("단어의 개수: " + list.size() + ", 글자 수: " + charSum);
    }
}
