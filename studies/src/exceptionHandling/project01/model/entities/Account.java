package exceptionHandling.project01.model.entities;

import exceptionHandling.project01.model.exceptions.AccountException;



public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(){
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }


    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(Double balance){
        this.balance += balance;
    }

    public void withdraw(Double balance) throws AccountException {
        if(balance > withdrawLimit){
            throw new AccountException("The amount exceeds withdraw limit");
        }else if(balance > this.balance){
            throw new AccountException("Insufficient limit");
        }else {
            this.balance -= balance;
        }
    }

}
