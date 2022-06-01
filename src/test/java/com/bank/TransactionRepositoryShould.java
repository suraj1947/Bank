package com.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionRepositoryShould {

  private TransactionRepository transactionRepository;
  private List<Transaction> transactions;

  @BeforeEach
  void init() {
    transactionRepository = new TransactionRepository();
    transactions = transactionRepository.allTransactions();
  }

  @Test
  void should_add_deposit_to_account() {
    transactionRepository.addDeposit(100);
    List<Transaction> transactions = transactionRepository.allTransactions();
    assertEquals(1, transactions.size());
    assertEquals(LocalDate.now(), transactions.get(0).getTransactionDate());
    assertEquals(100, transactions.get(0).getAmount());
  }

  @Test
  void should_add_withdrawal_to_account() {
    transactionRepository.withdraw(100);
    assertEquals(1, transactions.size());
    assertEquals(LocalDate.now(), transactions.get(0).getTransactionDate());
    assertEquals(-100, transactions.get(0).getAmount());
  }
}