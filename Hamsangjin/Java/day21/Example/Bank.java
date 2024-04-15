package com.example.day21.Example;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Account> AccountList = new ArrayList<>();

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public void addAccount(Account account) throws DuplicateAccountNumberException {
        for(Account a : AccountList){
            if(a.getAccountNumber() == account.getAccountNumber()){
                throw new DuplicateAccountNumberException("해당 계좌번호의 계좌가 존재합니다.");
            }
        }
        System.out.println("계좌 생성이 완료되었습니다.");
        AccountList.add(account);
    }

    public void infoCheck(int accountNumber, int password) throws AccountNotFoundException, WrongPasswordException {
        for(Account a : AccountList){
            if(a.getAccountNumber() == accountNumber && a.getPassword() == password){
                System.out.println("현재 잔액은 " + a.getBalance() + "원입니다.");
                return;
            } else if(a.getAccountNumber() == accountNumber && a.getPassword() != password){
                throw new WrongPasswordException("비밀번호가 틀렸습니다.");
            }
        }
        throw new AccountNotFoundException("요청한 계좌 번호의 통장이 존재하지 않습니다.");
    }
}