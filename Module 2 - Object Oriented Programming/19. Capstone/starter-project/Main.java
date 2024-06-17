import pojo.CashAccount;
import pojo.MarginAccount;
import pojo.TradeAccount;
import repository.TradeAccountRepository;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        TradeAccountRepository repository = new TradeAccountRepository();

        CashAccount cashAccount = new CashAccount("C123", new BigDecimal("1000.00"));
        repository.createTradeAccount(cashAccount);

        MarginAccount marginAccount = new MarginAccount("M456", new BigDecimal("5000.00"));
        repository.createTradeAccount(marginAccount);

        TradeAccount retrievedCashAccount = repository.retrieveTradeAccount("C123");
        System.out.println("Retrieved Cash Account ID: " + retrievedCashAccount.getId());
        System.out.println("Cash Balance: " + ((CashAccount) retrievedCashAccount).getCashBalance());

        TradeAccount retrievedMarginAccount = repository.retrieveTradeAccount("M456");

        System.out.println("Retrieved Margin Account ID: " + retrievedMarginAccount.getId());
        System.out.println("Margin: " + ((MarginAccount) retrievedMarginAccount).getMargin());


        // Update the cash account
        ((CashAccount) retrievedCashAccount).setCashBalance(new BigDecimal("1500.00"));
        repository.updateTradeAccount(retrievedCashAccount);


        // Verify that the cash account was updated
        retrievedCashAccount = repository.retrieveTradeAccount("C123");
        System.out.println("Updated Cash Balance: " + ((CashAccount) retrievedCashAccount).getCashBalance());


        // Delete the margin account
        repository.deleteTradeAccount("M456");


        // Verify that the margin account was deleted
        retrievedMarginAccount = repository.retrieveTradeAccount("M456");
        if (retrievedMarginAccount == null) {
            System.out.println("Margin account successfully deleted.");
        } else {
            System.out.println("Margin account deletion failed.");
        }


    }
}