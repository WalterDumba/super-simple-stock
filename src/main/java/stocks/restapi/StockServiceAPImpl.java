package stocks.restapi;

import org.joda.time.DateTime;
import stocks.StockServiceAPI;
import stocks.domain.Stock;
import stocks.domain.StockSymbol;
import stocks.domain.Trade;
import stocks.persistence.StockRepository;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * Created by Walter on 05-09-2016.
 */
public class StockServiceAPImpl implements StockServiceAPI {



    private StockRepository stockRepository;




    public StockServiceAPImpl(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }


    public double computeDividendYield(StockSymbol symbol) {

        Stock stock = this.stockRepository.findOne(symbol);
        if(stock == null){
            throw new RuntimeException("Stock not Found");
        }
        return stock.getDividendYield();
    }



    public double computePERatio(StockSymbol symbol) {

        Stock stock = this.stockRepository.findOne( symbol );
        if(stock == null){
            throw new RuntimeException("Stock not Found");
        }
        return stock.getPERatio();
    }



    public boolean record(Trade trade) {

        if(trade == null || trade.getStock() == null){
            throw new RuntimeException("Error while saving trade, please provide a valid object in args");
        }
        boolean saved = this.stockRepository.save(trade);

        if(saved){
            trade.getStock().setTickerPrice(trade.getPrice());//And then we Update associated stocks
        }
        return saved;
    }



    public double computePrice(StockSymbol symbol) {
        return this.computePriceInRange(symbol, 15);
    }


    //AUX
    private double computePriceInRange(StockSymbol symbol, int rangeInMinutes){


        List<Trade> tradeList = this.stockRepository.findAllTrades();
        if(tradeList == null){
            throw new RuntimeException("No such trades found with symbol :"+ symbol);
        }
        //BUILD CRITERIA FILTER
        Predicate<Trade>filterBySymbolAndLetPassAllInRange = (Trade that)->
                that.getStock().getSymbol().equals( symbol)
                && that.getDate().compareTo( DateTime.now().minus(rangeInMinutes) )<= 0;

        List<Trade>requiredTrades = tradeList
                .stream()
                .filter( filterBySymbolAndLetPassAllInRange )
                .collect( Collectors.toList() );
        //An then we computes the cumulative of Price*Quantity o each Trade
        double shareQuantityAcumulated =0;
        double tradePriceAcumulated    =0;
        double stockPrice              =0;

        for(Trade current: requiredTrades){
            tradePriceAcumulated    += current.getPrice()*current.getSharesQuantity();
            shareQuantityAcumulated += current.getSharesQuantity();
        }
        if(shareQuantityAcumulated >0.0){
            stockPrice= tradePriceAcumulated /shareQuantityAcumulated;
        }

        return stockPrice;
    }


    public double computeGBCEAllShareIndex(StockSymbol symbol) {
        return 0;//TODO: Sorry for that, i did my best.
    }




}
