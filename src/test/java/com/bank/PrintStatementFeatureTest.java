package com.bank;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

@MicronautTest
 class PrintStatementFeatureTest {

  private Console console;
  private Account account;

  @BeforeEach
  void init() {
    console = mock(Console.class);
    TransactionRepository transactionRepository = new TransactionRepository();
    StatementPrinter statementPrinter = new StatementPrinter(console);
    account = new Account(transactionRepository, statementPrinter);

  }

  @Test
  void print_statement_contaning_all_transactions() {
    account.deposit(1000);
    account.withdraw(500);
    account.deposit(1000);

    account.printStatement();

    InOrder inOrder = inOrder(console);
    inOrder.verify(console).printLine("DATE|AMOUNT|BALANCE");
    inOrder.verify(console).printLine(LocalDate.now()+"|"+1000+"|1000");
    inOrder.verify(console).printLine(LocalDate.now()+"|"+(-500)+"|500");
    inOrder.verify(console).printLine(LocalDate.now()+"|"+1000+"|1500");

  }

}
