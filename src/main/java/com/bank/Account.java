package com.bank;

import java.util.List;

public class Account {

  private final TransactionRepository transactionRepository;
  private StatementPrinter statementPrinter;

  public Account(TransactionRepository transactionRepository,
      StatementPrinter statementPrinter) {
    this.transactionRepository = transactionRepository;
    this.statementPrinter = statementPrinter;
  }

  public void deposit(int amount) {
    transactionRepository.addDeposit(amount);
  }

  public void withdraw(int amount) {
    transactionRepository.withdraw(amount);
  }

  public void printStatement() {
    List<Transaction> transactions = transactionRepository.allTransactions();
    statementPrinter.print(transactions);
  }
}
