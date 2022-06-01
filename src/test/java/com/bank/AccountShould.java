package com.bank;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountShould {

  private Account account;
  private TransactionRepository transactionRepository;
  private StatementPrinter statementPrinter;

  @BeforeEach
  void init() {
    transactionRepository = mock(TransactionRepository.class);
    statementPrinter = mock(StatementPrinter.class);
    account = new Account(transactionRepository, statementPrinter);
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

  @Test
  void print_account_statement() {
    List<Transaction> transactions = List.of(new Transaction(LocalDate.now(),100));
    when(transactionRepository.allTransactions()).thenReturn(transactions);
    account.printStatement();
    verify(statementPrinter).print(transactions);

  }
}