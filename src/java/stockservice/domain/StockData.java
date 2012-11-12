/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockservice.domain;

/**
 *
 * @author rotalora
 */
public class StockData
{
    String symbol;
    String stockName;
    double price;
    double dividendYield;

    public StockData()
    {
    }

    public StockData(String symbol, String stockName, double price)
    {
        this.symbol = symbol;
        this.stockName = stockName;
        this.price = price;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    public String getStockName()
    {
        return stockName;
    }

    public void setStockName(String name)
    {
        this.stockName = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getDividendYield()
    {
        return dividendYield;
    }

    public void setDividendYield(double dividendYield)
    {
        this.dividendYield = dividendYield;
    }

}
