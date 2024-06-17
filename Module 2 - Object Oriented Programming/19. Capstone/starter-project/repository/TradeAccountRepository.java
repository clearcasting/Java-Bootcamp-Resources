package repository;

import pojo.TradeAccount;

import java.util.HashMap;
import java.util.Map;

public class TradeAccountRepository {
    private Map<String, TradeAccount> dataStore = new HashMap<>();

    public void createTradeAccount(TradeAccount account) {
        dataStore.put(account.getId(), account.clone());
    }

    public TradeAccount retrieveTradeAccount(String id) {
        return dataStore.get(id) == null ? null : dataStore.get(id).clone();
    }

    public void updateTradeAccount(TradeAccount account) {
        dataStore.put(account.getId(), account.clone());
    }

    public void deleteTradeAccount(String id) {
        dataStore.remove(id);
    }

}
