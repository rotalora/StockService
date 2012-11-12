/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockservice.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author rotalora
 */
public class StockTickerDao
{
    private static final Log log = LogFactory.getLog(StockTickerDao.class);
    private static final StockTickerDao stockDao = new StockTickerDao();
    private static HashMap<String, StockData> stocks =
        new HashMap<String, StockData>();
    
    private StockTickerDao()
    {
    }

    public static StockTickerDao getInstance()
    {
        return stockDao;
    }

    public StockData getStockPrice(String symbol)
    {
        StockData stockData;

        stockData = getStockData(symbol);

        return stockData;
    }

    private synchronized StockData getStockData(String symbol)
    {
        try
        {
            /*
             * Request the data from the finance call to get the stock
             * information
             */
            URL yahooFinance = new URL("http://finance.yahoo.com/d/quotes.csv?s=" +
                symbol + "&f=naby");
            URLConnection yahooQuote = yahooFinance.openConnection();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(yahooQuote.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                String[] yahooStockData = inputLine.split(",");
                StockData stockData = new StockData();
                stockData.setSymbol(symbol);
                stockData.setStockName(yahooStockData[0].replaceAll("\"", ""));
                stocks.put(symbol, stockData);
                stockData.setPrice(Float.valueOf(yahooStockData[1]));
                stockData.setDividendYield(Float.valueOf(yahooStockData[3]));
            }
        }
        catch (MalformedURLException exc)
        {
            log.error("Unable to get stock data for symbol=" + symbol + exc);
        }
        catch (IOException exc)
        {
            log.error("Unable to get stock data for symbol=" + symbol + exc);
        }
        catch (NumberFormatException exc)
        {
            log.error("Unable to get stock price for symbol=" + symbol + exc);
        }

        return stocks.get(symbol);
    }
}
