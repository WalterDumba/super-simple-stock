package stocks.persistence;

import com.google.common.collect.ImmutableMap;
import stocks.domain.Stock;
import stocks.domain.StockSymbol;
import stocks.domain.StockType;
import stocks.domain.Trade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static stocks.domain.StockSymbol.*;

/**
 * Created by Walter on 06-09-2016.
 */
public class StockRepository {





    private Map<StockSymbol,Stock> stocks;
    private List<Trade> trades;



    public StockRepository(){
        this.stocks = new HashMap<StockSymbol, Stock>();
        this.trades = new ArrayList<>();
    }


    public Stock findOne(StockSymbol symbol) {
        return stocks.get(symbol);
    }

    public boolean save(Trade trade) {
        if(trade==null){
            return false;
        }
        this.trades.add(trade);
        return true;
    }

    public List<Trade> findAllTrades() {
        return trades;
    }

    public Map<StockSymbol, Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Map<StockSymbol, Stock> stocks) {
        this.stocks = stocks;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }


}
