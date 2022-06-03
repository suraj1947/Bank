package com.bank;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatementPrinterShould {

  private Console console;
  private StatementPrinter statementPrinter;
  TransactionRepository transactionRepository;
  @BeforeEach
  void init() {
    console = mock(Console.class);
    statementPrinter = new StatementPrinter(console);
    transactionRepository = new TransactionRepository();
  }

  @Test
  void print_account_statement_header() {
    statementPrinter.print(Collections.emptyList());
    verify(console).printLine("DATE|AMOUNT|BALANCE");
  }

  @Test
  void print_account_statement() {
    Account account = new Account(transactionRepository, statementPrinter);
    account.deposit(500);
    account.withdraw(200);
    StatementPrinter statementPrinter = new StatementPrinter(console);
    statementPrinter.print(transactionRepository.allTransactions());
    verify(console).printLine("DATE|AMOUNT|BALANCE");
    verify(console).printLine(LocalDate.now()+"|"+500+"|500");
    verify(console).printLine(LocalDate.now()+"|"+(-200)+"|300");
  }
}