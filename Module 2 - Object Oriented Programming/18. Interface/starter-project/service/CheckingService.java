package service;


import pojo.Checking;
import repository.AccountRepository;

import java.math.BigDecimal;

public class CheckingService implements AccountService {

    AccountRepository accountRepository;

    public CheckingService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Checking checking) {
        accountRepository.createAccount(checking);
    }

    public Checking retrieveChecking(String id) {
        return (Checking) accountRepository.retrieveAccount(id);
    }

    public void updateChecking(Checking checking) {
        accountRepository.updateAccount(checking);
    }

    public void deleteChecking(String id) {
        accountRepository.deleteAccount(id);
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        Checking account = retrieveChecking(id);
        account.setBalance(account.getBalance().add(amount));
        updateChecking(account);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        Checking account = retrieveChecking(id);
        account.setBalance(account.getBalance().subtract(amount));
        updateChecking(account);
    }

}
