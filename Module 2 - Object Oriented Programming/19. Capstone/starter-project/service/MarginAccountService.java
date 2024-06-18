package service;


import pojo.MarginAccount;
import repository.TradeAccountRepository;

import java.math.BigDecimal;

public class MarginAccountService implements TradeAccountService {
    private TradeAccountRepository repository;

    public MarginAccountService(TradeAccountRepository repository) {
        this.repository = repository;
    }

    public void createTradeAccount(MarginAccount account) {
        repository.createTradeAccount(account);
    }

    public MarginAccount retrieveTradeAccount(String id) {
        return (MarginAccount) repository.retrieveTradeAccount(id);
    }

    public void updateTradeAccount(MarginAccount account) {
        repository.updateTradeAccount(account);
    }

    public void deleteTradeAccount(String id) {
        repository.deleteTradeAccount(id);
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        MarginAccount account = retrieveTradeAccount(id);
        account.setMargin(account.getMargin().add(amount));
        updateTradeAccount(account);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        MarginAccount account = retrieveTradeAccount(id);
        account.setMargin(account.getMargin().subtract(amount));
        updateTradeAccount(account);
    }
}