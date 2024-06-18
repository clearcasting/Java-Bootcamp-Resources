import pojo.CashAccount;
import pojo.MarginAccount;
import repository.TradeAccountRepository;
import service.CashAccountService;
import service.MarginAccountService;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    static Path[] paths = new Path[] {Paths.get("data/accounts.txt"), Paths.get("data/transactions.txt")};


    static TradeAccountRepository tradeAccountRepository = new TradeAccountRepository();
    static CashAccountService cashAccountService = new CashAccountService(tradeAccountRepository);
    static MarginAccountService marginAccountService = new MarginAccountService(tradeAccountRepository);


    public static void main(String[] args) {

        try {
            loadTradeAccounts();
            applyTransactions();
            finalTest();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }



    }

    public static void finalTest() throws IOException {
        System.out.println("Account A1234B Cash Balance: " + cashAccountService.retrieveTradeAccount("A1234B").getCashBalance());
        System.out.println("Account E3456F Cash Balance: " + cashAccountService.retrieveTradeAccount("E3456F").getCashBalance());
        System.out.println("Account I5678J Cash Balance: " + cashAccountService.retrieveTradeAccount("I5678J").getCashBalance());
        System.out.println("Account C2345D Margin: " + marginAccountService.retrieveTradeAccount("C2345D").getMargin());
        System.out.println("Account G4567H Margin: " + marginAccountService.retrieveTradeAccount("G4567H").getMargin());
    }


    public static void loadTradeAccounts() {
        try {
            Files.lines(paths[0])
                    .forEach(account -> {
                        String[] split = account.split(" ");
                        if (split[0].equals("CASH")) {
                            cashAccountService.createTradeAccount(new CashAccount(split[1], new BigDecimal(split[2])));
                        } else {
                            marginAccountService.createTradeAccount(new MarginAccount(split[1], new BigDecimal(split[2])));
                        }
                    });
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void applyTransactions() {
        try {
            Files.lines(paths[1])
                    .forEach(transaction -> {
                        String[] split = transaction.split(" ");
                        String id = split[1];
                        BigDecimal amount = new BigDecimal(split[3]);

                        switch (split[2]) {
                            case "DEPOSIT" -> {
                                if (split[0].equals("CASH")) {
                                    cashAccountService.deposit(id, amount);
                                } else {
                                    marginAccountService.deposit(id, amount);
                                }
                            }
                            case "WITHDRAWAL" -> {
                                if (split[0].equals("CASH")) {
                                    cashAccountService.withdraw(id, amount);
                                } else {
                                    marginAccountService.withdraw(id, amount);
                                }
                            }
                        }
                    });
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}