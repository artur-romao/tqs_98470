package com.stocks;

import java.util.ArrayList;
import java.util.List;

import com.IStockmarketService;

public class StocksPortfolio implements IStockmarketService {
    private List<Stock> stocks = new ArrayList<>();
    private IStockmarketService stockmarketservice;

    public StocksPortfolio() {}
    
    public StocksPortfolio(IStockmarketService stockmarketService) {
        this.stockmarketservice = stockmarketService;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }
    
    public double getTotalValue() {
        return 0;
    }

    public double lookUpPrice(String label) {
        return 0;
    }

}
