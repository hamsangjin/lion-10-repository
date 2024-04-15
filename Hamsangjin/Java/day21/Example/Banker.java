package com.example.day21.Example;

public class Banker {
    private final String name;
    private final int id;
    private Bank bank;

    public Banker(String name, int id, Bank bank) {
        this.name = name;
        this.id = id;
        this.bank = bank;
    }

    public void addAccountOK(Account account){
        try{
            bank.addAccount(account);
        } catch (DuplicateAccountNumberException e){
            System.out.println(e.getMessage());
        }
    }

    // 출금
    public void withdrawOK(Account account, int amount, int password){
        try {
            account.withdraw(amount, account.getPassword(), password);
        } catch (InsufficientFundsException e){
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e){
            System.out.println(e.getMessage());
        }
    }

    // 입금
    public void depositOK(Account account, int amount){
        account.deposit(amount);
    }


    public void infoCheckOK(int accountNumber, int password){
        try {
            bank.infoCheck(accountNumber, password);
        } catch (AccountNotFoundException e){
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e){
            System.out.println(e.getMessage());
        }
    }
}