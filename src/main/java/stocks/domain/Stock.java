package stocks.domain;

/**
 * Created by Walter on 05-09-2016.
 */
public class Stock {


    private StockSymbol symbol;
    private StockType type;
    private double lastDividend;
    private double fixedDividend;
    private double parValue;
    private double tickerPrice;




    public Stock(){
        this.type = StockType.COMMON; //The default one
    }

    public Stock(StockSymbol symbol, StockType type, double lastDividend, double fixedDividend, double parValue, double tickerPrice) {
        this.symbol = symbol;
        this.type = type;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
        this.tickerPrice = tickerPrice;
    }



    //GETTERS AND SETTERS
    public StockSymbol getSymbol() {
        return symbol;
    }

    public void setSymbol(StockSymbol symbol) {
        this.symbol = symbol;
    }

    public StockType getType() {
        return type;
    }

    public void setType(StockType type) {
        this.type = type;
    }

    public double getLastDividend() {
        return lastDividend;
    }

    public void setLastDividend(double lastDividend) {
        this.lastDividend = lastDividend;
    }

    public double getFixedDividend() {
        return fixedDividend;
    }

    public void setFixedDividend(double fixedDividend) {
        this.fixedDividend = fixedDividend;
    }

    public double getParValue() {
        return parValue;
    }

    public void setParValue(double parValue) {
        this.parValue = parValue;
    }

    public double getTickerPrice() {
        return tickerPrice;
    }

    public void setTickerPrice(double tickerPrice) {
        this.tickerPrice = tickerPrice;
    }


    public double getDividendYield() {

        if(this.tickerPrice == 0){
            return 0;   //According to my assumptions on API we only computes for tickerPrice > 0;
        }
        switch (type){
            case COMMON:
                return this.lastDividend/this.tickerPrice;
            case PREFERRED:
                return (this.fixedDividend*this.parValue)/this.tickerPrice;
            default:
                throw new RuntimeException("Invalid type for stocks");
        }
    }

    /**
     * @NOte:
     *
     *  P/E = currentStockPrice/(EPS)
     *       where EPS =DividendYield
     *
     *   Am i wrong??
     */
    public double getPERatio() {
        return this.tickerPrice/this.getDividendYield();
    }
}
