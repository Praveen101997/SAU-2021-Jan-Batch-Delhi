package com.praveen.server.Model;

public class Transaction {
    int transactionNumber;
    int accountNumber;
    int currencySerial;

    public boolean isLegal() {
        return legal;
    }

    public void setLegal(boolean legal) {
        this.legal = legal;
    }

    boolean legal;


    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCurrencySerial() {
        return currencySerial;
    }

    public void setCurrencySerial(int currencySerial) {
        this.currencySerial = currencySerial;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionNumber=" + transactionNumber +
                ", accountNumber=" + accountNumber +
                ", currencySerial=" + currencySerial +
                ", legal=" + legal +
                '}';
    }
}
