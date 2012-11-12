/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockservice.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

/**
 *
 * @author rotalora
 */
public class HoldingsDao extends SimpleJdbcDaoSupport
{
    protected final Log logger = LogFactory.getLog(getClass());
    List<UserStock> holdings;
    String username;
    Double holdingsValue;

    public List<UserStock> getHoldings()
    {
        return holdings;
    }

    public void setHoldings(List<UserStock> holdings)
    {
        this.holdings = holdings;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Double getHoldingsValue()
    {
        return holdingsValue;
    }

    public void setHoldingsValue(Double holdingsValue)
    {
        this.holdingsValue = holdingsValue;
    }

    public List<UserStock> readUserHoldings(String username)
    {
        List<UserStock> symbolHoldings = null;
        this.username = username;

        /*
         * Read from the database all the holdings for the given user
         */
        holdings = getSimpleJdbcTemplate().query(
            "SELECT username, symbol, purchasePrice, purchaseDate, quantity " +
            "FROM holdings WHERE username=" + "'" + username + "'",
            new StockMapper());

        /*
         * Add to the result set the data from the finance call that contains
         * current stock price
         */
        addTickerData(holdings);

        return holdings;
    }

    public List<UserStock> readUserHoldings(String username, String symbol)
    {
        List<UserStock> symbolHoldings = null;
        this.username = username;

        /*
         * Read from the database all the holdings for the given user and symbol
         */
        symbolHoldings = getSimpleJdbcTemplate().query(
            "SELECT username, symbol, purchasePrice, purchaseDate, quantity " +
            "FROM holdings WHERE username=" + "'" + username + "'" +
            " AND symbol=" + "'" + symbol + "'",
            new StockMapper());

        /*
         * Add to the result set the data from the finance call that contains
         * current stock price
         */
        addTickerData(symbolHoldings);

        return symbolHoldings;
    }

    private void addTickerData(List<UserStock> stockHoldings)
    {
        StockTickerDao tickerDao = StockTickerDao.getInstance();
        StockData stockData = null;

        /*
         * Get the stock data from the finanace call and add the data to
         * the list of stock the user holds in preparation for display
         */
        Iterator<UserStock> userHoldings = stockHoldings.iterator();
        holdingsValue = 0.0;
        while (userHoldings.hasNext())
        {
            UserStock userStock = userHoldings.next();
            stockData = tickerDao.getStockPrice(userStock.getSymbol());
            userStock.setCurrentPrice(stockData.getPrice());
            userStock.setStockName(stockData.getStockName());
            userStock.setDividendYield(stockData.getDividendYield());

            Double value = userStock.getCurrentPrice() * userStock.getQuantity();
            userStock.setValue(value);
            holdingsValue = holdingsValue + value;
        }
    }

    /*
     * Private row mapper class that provided the list of fields to the database
     */
    private static class StockMapper implements ParameterizedRowMapper<UserStock>
    {
        public UserStock mapRow(ResultSet result, int rowNumber) throws SQLException
        {
            UserStock stock = new UserStock();

            stock.setUsername(result.getString("username"));
            stock.setSymbol(result.getString("symbol"));
            stock.setPurchasePrice(result.getDouble("purchasePrice"));
            stock.setPurchaseDate(result.getDate("purchaseDate"));
            stock.setQuantity(result.getInt("quantity"));

            return stock;
        }
    }

    public void saveUserStockData(UserStock userStock)
    {
        logger.info("Saving user purchased stock:" + userStock.getStockName());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String purchaseDate = dateFormat.format(userStock.getPurchaseDate());

        int id = 0;
        String statement  =
            "insert into holdings (username,symbol,purchasePrice,purchaseDate,quantity) " +
            "values('" +
            userStock.getUsername() + "','" +
            userStock.getSymbol() + "','" +
            userStock.getPurchasePrice() + "','" +
            purchaseDate + "','" +
            userStock.getQuantity() + "')";
        int count = getSimpleJdbcTemplate().update(statement);
        logger.info("Rows affected:" + count);
    }
}
