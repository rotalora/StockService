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
public class StockDataTests extends TestCase
{
    StockData stockData;

    protected void setUp() throws Exception
    {
        stockData = new StockData();
    }

    public void testSetAndGetSymbol()
    {
        String testSymbol = "aSymbol";

        assertNull(stockData.getSymbol());
        stockData.setSymbol(testSymbol);
        assertEquals(testSymbol, stockData.getSymbol());
    }

    public void testSetAndGetStockName()
    {
        String testStockName = "aStockName";

        assertNull(stockData.getStockName());
        stockData.setStockName(testStockName);
        assertEquals(testStockName, stockData.getStockName());
    }

    public void testSetAndGetPrice()
    {
        double testPrice = 0.0;

        assertEquals(0.0, stockData.getPrice());
        stockData.setPrice(testPrice);
        assertEquals(testPrice, stockData.getPrice());
    }

}
