package com.example.carexpensemanagerfinal1;

public class Expense
{
    String expenseType;
    String  carid;
    String details;
    int  amount;
    String  userid;
    String  date;

    public Expense() {
    }

    public Expense(String expenseType, String carid, String details, int amount, String userid, String date)
    {
        this.expenseType = expenseType;
        this.carid = carid;
        this.details = details;
        this.amount = amount;
        this.userid = userid;
        this.date = date;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
