package stocks.domain;

import org.joda.time.DateTime;

/**
 * Created by Walter on 05-09-2016.
 */
public class Trade {



    private DateTime date;
    private double sharesQuantity;
    private TradeIndicator indicator;
    private double price;

    private Stock stock; //associated stocks





    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public double getSharesQuantity() {
        return sharesQuantity;
    }

    public void setSharesQuantity(double sharesQuantity) {
        this.sharesQuantity = sharesQuantity;
    }

    public TradeIndicator getIndicator() {
        return indicator;
    }

    public void setIndicator(TradeIndicator indicator) {
        this.indicator = indicator;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
