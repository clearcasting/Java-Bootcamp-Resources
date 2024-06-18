package service;


import pojo.CashAccount;
import repository.TradeAccountRepository;

import java.math.BigDecimal;

public class CashAccountService implements TradeAccountService{
    private TradeAccountRepository repository;

    public CashAccountService(TradeAccountRepository repository) {
        this.repository = repository;
    }

    public void createTradeAccount(CashAccount account) {
        repository.createTradeAccount(account);
    }

    public CashAccount retrieveTradeAccount(String id) {
        return (CashAccount) repository.retrieveTradeAccount(id);
    }

    public void updateTradeAccount(CashAccount account) {
        repository.updateTradeAccount(account);
    }

    public void deleteTradeAccount(String id) {
        repository.deleteTradeAccount(id);
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        CashAccount account = retrieveTradeAccount(id);
        account.setCashBalance(account.getCashBalance().add(amount));
        updateTradeAccount(account);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        CashAccount account = retrieveTradeAccount(id);
        account.setCashBalance(account.getCashBalance().subtract(amount));
        updateTradeAccount(account);
    }
}
