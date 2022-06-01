package com.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {

  Transaction transaction;
  List<Transaction> allTransactions = new ArrayList<>();

  public void addDeposit(int amount) {
    transaction = new Transaction(LocalDate.now(), amount);
    allTransactions.add(transaction);
  }

  public void withdraw(int amount) {
    transaction = new Transaction(LocalDate.now(), -amount);
    allTransactions.add(transaction);
  }

  public List<Transaction> allTransactions() {
    return Collections.unmodifiableList(allTransactions);
  }
}
