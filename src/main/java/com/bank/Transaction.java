package com.bank;

import java.time.LocalDate;

public class Transaction {

  private LocalDate transactionDate;
  private int amount;

  public Transaction(LocalDate transactionDate, int amount) {
    this.transactionDate = transactionDate;
    this.amount = amount;
  }

  public LocalDate getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(LocalDate transactionDate) {
    this.transactionDate = transactionDate;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
