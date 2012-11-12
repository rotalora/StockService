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
public class UserTests extends TestCase
{
    User user;

    protected void setUp() throws Exception
    {
        user = new User();
    }

    public void testSetAndGetUsername()
    {
        String testUsername = "aUsername";

        assertNull(user.getUsername());
        user.setUsername(testUsername);
        assertEquals(testUsername, user.getUsername());
    }

    public void testSetAndGetPassword()
    {
        String testPassword = "aPassword";

        assertNull(user.getPassword());
        user.setPassword(testPassword);
        assertEquals(testPassword, user.getPassword());
    }

    public void testSetAndGetFirstName()
    {
        String testFirstName = "aFirstName";

        assertNull(user.getFirstName());
        user.setFirstName(testFirstName);
        assertEquals(testFirstName, user.getFirstName());
    }

    public void testSetAndGetLastName()
    {
        String testLastName = "aLastName";

        assertNull(user.getLastName());
        user.setLastName(testLastName);
        assertEquals(testLastName, user.getLastName());
    }
}
