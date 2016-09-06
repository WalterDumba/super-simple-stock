package stocks;

import stocks.domain.StockSymbol;
import stocks.domain.Trade;

/**
 * Created by Walter on 05-09-2016.
 */
public interface StockServiceAPI
{


    /**
     * Computes Divindend Yield for the gived stocks id (symbol)
     *
     * @param symbol - A id of stocks whose dividendYield will be computed
     * @return DividendYield
     *
     * @Assumptions:
     *  1. TickerPrice > 0
     *  or else an RuntimeException will be threw
     */
    double computeDividendYield(StockSymbol symbol);

    /**
     * Computes P/E Ratio for the gived stocks id
     *
     * @param symbol - A id of stocks whose P/E Ratio will be computed
     * @return
     *
     * @Assumptions:
     *  1. Dividend > 0
     *  or else an RuntimeException will be threw
     */
    double computePERatio(StockSymbol symbol);

    /**
     * Computes GBCE for the following stocks
     *
     * @param symbol -A id of stocks whose GBCE will be computed
     * @return GBCE for the gived symbol
     */
    double computeGBCEAllShareIndex(StockSymbol symbol);

    /**
     * Saves the following trade
     *
     * @param trade - A trade to being saved
     * @return true if trade was saved with successful or else false
     */
    boolean record(Trade trade);

    /**
     * Computes a price for a gived stocks
     *
     * @param symbol - A id of stocks whose price will be computed
     * @return  price for the current stocks
     */
    double computePrice(StockSymbol symbol);


}
