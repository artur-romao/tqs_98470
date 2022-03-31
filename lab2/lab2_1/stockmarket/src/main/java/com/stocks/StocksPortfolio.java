package com.stocks;

import java.util.ArrayList;
import java.util.List;

public class StocksPortfolio {
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
        double price = 0;
        for (Stock s : stocks) {
            price += s.getQuantity() * stockmarketservice.lookUpPrice(s.getLabel());
        }
        return price;
    }

}
