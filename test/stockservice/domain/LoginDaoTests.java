/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockservice.domain;

import javax.sql.DataSource;
import junit.framework.TestCase;

/**
 *
 * @author rotalora
 */
public class LoginDaoTests extends TestCase
{
    LoginDao loginDao;

    protected void setUp() throws Exception
    {
        loginDao = new LoginDao();
    }

    public void testSetDataSource()
    {
        DataSource testDataSource = null;

        assertNull(loginDao.getDataSource());
        loginDao.setDataSource(testDataSource);
        assertEquals(testDataSource, loginDao.getDataSource());
    }

    public void testSetAndGetUser()
    {
        User testUser = null;

        assertNull(loginDao.getUser());
        loginDao.setUser(testUser);
        assertEquals(testUser, loginDao.getUser());
    }

    public void testSetAndGetLoginResult()
    {
        String testLoginResult = "aLoginResult";

        assertNull(loginDao.getLoginResult());
        loginDao.setLoginResult(testLoginResult);
        assertEquals(testLoginResult, loginDao.getLoginResult());
    }

    public void testVerifyLoginDetails()
    {
        boolean testLoginSuccess = false;

        boolean loginSuccess = loginDao.verifyLoginDetails(null, null);
        this.assertEquals(testLoginSuccess, loginSuccess);

        loginSuccess = loginDao.verifyLoginDetails("", null);
        this.assertEquals(testLoginSuccess, loginSuccess);

        loginSuccess = loginDao.verifyLoginDetails("", "");
        this.assertEquals(testLoginSuccess, loginSuccess);
    }

}
