package com.example.day21.Example;

public class Account {
    private int accountNumber;
    private String name;
    private int balance;
    private int password;

    public int getPassword() {
        return password;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public Account(int accountNumber, String name, int balance, int password) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.password = password;
    }

    public void deposit(int amount){
        this.balance += amount;
        System.out.println("입금이 완료되었으며, 현재 잔액은 " + this.balance + "원 입니다.");
    }

    public void withdraw(int amount, int password1, int password2) throws InsufficientFundsException, WrongPasswordException {
        if (password1 == password2) {
            if (this.balance >= amount) {
                this.balance -= amount;
                System.out.println(amount + "원을 출금했으며 남은 잔액은 " + this.balance + "원 입니다.");
            } else throw new InsufficientFundsException("잔액이 부족합니다.");
        } else {
            throw new WrongPasswordException("비밀번호가 틀렸습니다.");
        }
    }
}