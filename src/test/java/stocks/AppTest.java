package stocks;



import org.junit.Test;
import stocks.domain.Stock;
import stocks.domain.StockSymbol;
import stocks.domain.StockType;
import stocks.persistence.StockRepository;
import stocks.restapi.StockServiceAPImpl;

import java.util.HashMap;
import java.util.Map;

import static stocks.domain.StockSymbol.*;

/**
 * Unit test for simple StockServiceAPI.
 */
public class AppTest
{







   public static  void main(String[] args){


        StockRepository repository = new StockRepository();
        Map<StockSymbol,Stock> stockMap = new HashMap<>();
        stockMap.put(TEA, new Stock(TEA, StockType.COMMON, 2.0, 0.0, 100.0, 2.5));
        stockMap.put(POP, new Stock(POP, StockType.COMMON, 0.0, 0.0, 100.0, 2.5));
        stockMap.put(ALE, new Stock(ALE, StockType.COMMON, 0.0, 0.0, 100.0, 5.5));
        stockMap.put(GIN, new Stock(GIN, StockType.PREFERRED, 0.0, 0.0, 100.0, 7.5));
        stockMap.put(JOE, new Stock(JOE, StockType.COMMON, 0.0, 0.0, 100.0, 2.5));

        repository.setStocks(stockMap);
        StockServiceAPImpl service = new StockServiceAPImpl(repository);

        System.out.println(service.computeDividendYield(TEA)); //TODO: the remains


    }

}
