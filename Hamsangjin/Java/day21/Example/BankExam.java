package com.example.day21.Example;

public class BankExam {
    public static void main(String[] args) {

        Bank woori = new Bank("Woori");

        Account acc1 = new Account(1234567, "홍길동", 30000, 1234);
        Account acc2 = new Account(2345678, "아무개", 70000, 5678);
        Account acc3 = new Account(2345678, "함상진", 45000, 4321);

        Banker banker1 = new Banker("은행원1", 1, woori);

        banker1.addAccountOK(acc1);
        banker1.addAccountOK(acc2);
        banker1.addAccountOK(acc3);

        System.out.println();

        banker1.withdrawOK(acc1, 30000, 1234);
        banker1.withdrawOK(acc1, 30000, 1234);

        System.out.println();

        banker1.infoCheckOK(1234567, 1234);
        banker1.depositOK(acc1, 20000);
        banker1.infoCheckOK(1234567, 1234);

        banker1.infoCheckOK(1234567, 5678);

        banker1.infoCheckOK(1234568, 1234);
    }
}