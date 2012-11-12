/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockservice.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author rotalora
 */
public class UserStock implements Serializable
{
    private int id;
    private String username;
    private String symbol;
    private String stockName;
    private Double purchasePrice;
    private Double currentPrice;
    private Date purchaseDate;
    private int quantity;
    private Double value;
    private Double dividendYield;

    public UserStock()
    {
    }

    public UserStock(String username, String symbol, String stockName,
        Double purchasePrice, Double currentPrice, Date purchaseDate,
        int quantity, double value)
    {
        this.username = username;
        this.symbol = symbol;
        this.stockName = stockName;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.value = value;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String Symbol)
    {
        this.username = Symbol;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String Symbol)
    {
        this.symbol = Symbol;
    }

    public String getStockName()
    {
        return stockName;
    }

    public void setStockName(String name)
    {
        this.stockName = name;
    }

    public Date getPurchaseDate()
    {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate)
    {
        this.purchaseDate = purchaseDate;
    }

    public Double getPurchasePrice()
    {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }

    public Double getCurrentPrice()
    {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice)
    {
        this.currentPrice = currentPrice;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public Double getValue()
    {
        return value;
    }

    public void setValue(Double value)
    {
        this.value = value;
    }

    public Double getDividendYield()
    {
        return dividendYield;
    }

    public void setDividendYield(Double dividendYield)
    {
        this.dividendYield = dividendYield;
    }

    public String toString()
    {
        StringBuffer buffer = new StringBuffer();

        buffer.append("Symbol: " + symbol + ";");
        buffer.append("Quantity " + quantity);

        return buffer.toString();
    }
}
