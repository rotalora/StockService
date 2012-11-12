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
public class HoldingsDaoTests extends TestCase
{
    HoldingsDao holdingsDao;

    protected void setUp() throws Exception
    {
        holdingsDao = new HoldingsDao();
    }

    public void testSetAndGetUsername()
    {
        String testUsername = "aUsername";

        assertNull(holdingsDao.getUsername());
        holdingsDao.setUsername(testUsername);
        assertEquals(testUsername, holdingsDao.getUsername());
    }

    public void testSetAndGetHoldingsValue()
    {
        double testHoldingsValue = 0.0;

        assertEquals(0.0, holdingsDao.getHoldingsValue());
        holdingsDao.setHoldingsValue(testHoldingsValue);
        assertEquals(testHoldingsValue, holdingsDao.getHoldingsValue());
    }

}
