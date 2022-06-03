package com.bank;

import java.util.List;

public class StatementPrinter {

  private final Console console;
  private int balance = 0 ;
  public StatementPrinter(Console console) {
    this.console = console;
  }
  private String getBalance(Transaction transaction){
    balance = balance+transaction.getAmount();
    return String.valueOf(balance);

  }
  public void print(List<Transaction> transactions) {
    console.printLine("DATE|AMOUNT|BALANCE");
    for (Transaction transaction : transactions) {
      console.printLine(transaction.getTransactionDate().toString()+"|"+ transaction.getAmount() +"|"+getBalance(transaction));
    }
  }
}
