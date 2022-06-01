package com.bank;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountShould {

  Account account;
  private TransactionRepository transactionRepository;

  @BeforeEach
  void init() {
    transactionRepository = mock(TransactionRepository.class);
    account = new Account(transactionRepository);
  }

  @Test
  void deposit_the_amount_in_account() {
    account.deposit(100);
    verify(transactionRepository).addDeposit(100);
  }

  @Test
  void withdraw_from_account() {
    account.withdraw(100);
    verify(transactionRepository).withdraw(100);
  }
}