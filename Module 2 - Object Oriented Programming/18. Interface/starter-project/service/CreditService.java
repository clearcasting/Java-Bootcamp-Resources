package service;


import pojo.Credit;
import repository.AccountRepository;

import java.math.BigDecimal;

public class CreditService implements AccountService {

    AccountRepository accountRepository;

    public CreditService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Credit credit) {
        accountRepository.createAccount(credit);
    }

    public Credit retrieveCredit(String id) {
        return (Credit) accountRepository.retrieveAccount(id);
    }

    public void updateCredit(Credit credit) {
        accountRepository.updateAccount(credit);
    }

    public void deleteCredit(String id) {
        accountRepository.deleteAccount(id);
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        Credit account = (Credit) accountRepository.retrieveAccount(id);
        account.setCredit(account.getCredit().add(amount));
        updateCredit(account);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        Credit account = (Credit) accountRepository.retrieveAccount(id);
        account.setCredit(account.getCredit().subtract(amount));
        updateCredit(account);
    }
}
