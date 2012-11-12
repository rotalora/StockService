/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockservice.domain;

import java.util.Date;
import junit.framework.TestCase;

/**
 *
 * @author rotalora
 */
public class UserStockTests extends TestCase
{
    UserStock userStock;

    protected void setUp() throws Exception
    {
        userStock = new UserStock();
    }

    public void testSetAndGetId()
    {
        int testId = 1;

        assertEquals(0, userStock.getId());
        userStock.setId(testId);
        assertEquals(testId, userStock.getId());
    }

    public void testSetAndGetUsername()
    {
        String testUsername = "aUsername";

        assertNull(userStock.getUsername());
        userStock.setUsername(testUsername);
        assertEquals(testUsername, userStock.getUsername());
    }

    public void testSetAndGetSymbol()
    {
        String testSymbol = "aSymbol";

        assertNull(userStock.getSymbol());
        userStock.setSymbol(testSymbol);
        assertEquals(testSymbol, userStock.getSymbol());
    }

    public void testSetAndGetStockName()
    {
        String testStockName = "atockName";

        assertNull(userStock.getStockName());
        userStock.setStockName(testStockName);
        assertEquals(testStockName, userStock.getStockName());
    }

    public void testSetAndGetPurchaseDate()
    {
        Date testPurchaseDate = new Date();

        assertNull(userStock.getPurchaseDate());
        userStock.setPurchaseDate(testPurchaseDate);
        assertEquals(testPurchaseDate, userStock.getPurchaseDate());
    }

    public void testSetAndGetPurchasePrice()
    {
        double testPurchasePrice = 2.0;

        assertNull(userStock.getPurchasePrice());
        userStock.setPurchasePrice(testPurchasePrice);
        assertEquals(testPurchasePrice, userStock.getPurchasePrice());
    }

    public void testSetAndGetCurrentPrice()
    {
        double testCurrentPrice = 3.0;

        assertNull(userStock.getCurrentPrice());
        userStock.setCurrentPrice(testCurrentPrice);
        assertEquals(testCurrentPrice, userStock.getCurrentPrice());
    }

    public void testSetAndGetQuantity()
    {
        int testQuantity = 4;

        assertEquals(0, userStock.getQuantity());
        userStock.setQuantity(testQuantity);
        assertEquals(testQuantity, userStock.getQuantity());
    }

    public void testSetAndGetPurchaseValue()
    {
        double testPurchaseValue = 2.0;

        assertNull(userStock.getValue());
        userStock.setValue(testPurchaseValue);
        assertEquals(testPurchaseValue, userStock.getValue());
    }

}
