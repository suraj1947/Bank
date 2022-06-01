package com.bank;

public class Account {

  TransactionRepository transactionRepository;

  public Account(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  public void deposit(int amount) {
    transactionRepository.addDeposit(amount);
  }

  public void withdraw(int amount) {
    transactionRepository.withdraw(amount);
  }

  public void printStatement() {
  }
}
