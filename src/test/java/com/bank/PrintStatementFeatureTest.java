package com.bank;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

@MicronautTest
public class PrintStatementFeatureTest {

  private Console console;
  private Account account;
  private TransactionRepository transactionRepository;

  @BeforeEach
  void init() {
    account = new Account(transactionRepository);
    console = mock(Console.class);
  }

  @Test
  void print_statement_contaning_all_transactions() {
    account.deposit(1000);
    account.withdraw(500);
    account.deposit(1000);

    account.printStatement();

    InOrder inOrder = inOrder(console);
    inOrder.verify(console).printLine("DATE         |AMOUNT   |BALANCE");
    inOrder.verify(console).printLine("10/05/2022   |1000     |1000");
    inOrder.verify(console).printLine("11/05/2022   | -500    |500");
    inOrder.verify(console).printLine("13/05/2022   |1000     |1500");


  }

}