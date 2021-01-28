package com.praveen.server.Model;

public class Currency {

    int amount;  //valid values are 500 and 1000
    int serialNumber;

    public Currency(){}
    public Currency(int serialNumber,int amount)
    {
        this.serialNumber=serialNumber;
        this.amount=amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
}
