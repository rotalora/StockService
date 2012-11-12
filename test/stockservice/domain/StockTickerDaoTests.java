/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockservice.domain;

import junit.framework.TestCase;

/**
 *
 * @author rotalora
 */
public class StockTickerDaoTests extends TestCase
{
    StockTickerDao stockTickerDao;

    protected void setUp() throws Exception
    {
        stockTickerDao = StockTickerDao.getInstance();
    }

    public void testGetStockData()
    {
        StockData stockData = stockTickerDao.getStockPrice("BADSYMBOL");
        assertNull(stockData);

        stockData = stockTickerDao.getStockPrice("APPL");
        this.assertNotNull(stockData);
    }
}
