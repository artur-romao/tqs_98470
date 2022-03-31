package com.stocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ExtendWith(MockitoExtension.class)
public class StocksPortfolioTest 
{
    @Mock IStockmarketService stockmarket;

    @InjectMocks StocksPortfolio stocksportfolio;


    @Test
    public void getTotalValue()
    {
        Mockito.when(stockmarket.lookUpPrice("AMAZON")).thenReturn(8.0);
        Mockito.when(stockmarket.lookUpPrice("ORACLE")).thenReturn(6.5);

        stocksportfolio.addStock(new Stock("AMAZON", 3));
        stocksportfolio.addStock(new Stock("ORACLE", 3));
        
        double result = stocksportfolio.getTotalValue();

        assertThat(result, is(43.5));
        Mockito.verify(stockmarket, Mockito.times(2)).lookUpPrice(Mockito.anyString());
    }
}
