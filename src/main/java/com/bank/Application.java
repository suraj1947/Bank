package com.bank;

import io.micronaut.runtime.Micronaut;

public class Application {
    public static void main(String[] args) {
        TransactionRepository transactionRepository = new TransactionRepository();
        Account account = new Account(transactionRepository,new StatementPrinter(new Console()));

        account.deposit(1000);
        account.deposit(2000);

        account.printStatement();

        Micronaut.run(Application.class, args);
    }
}
