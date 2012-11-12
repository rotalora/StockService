/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockservice.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author rotalora
 */
public class LoginDao
{
    DataSource dataSource;
    User user = null;
    String loginResult;

    public LoginDao()
    {
    }

    public DataSource getDataSource()
    {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getLoginResult()
    {
        return loginResult;
    }

    public void setLoginResult(String loginResult)
    {
        this.loginResult = loginResult;
    }

    public boolean verifyLoginDetails(String username, String password)
    {
        boolean loginValid = false;

        this.loginResult = "Login Unsucessful";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        /*
         * Verify that the provided username and password is a valid login
         * using the database
         */
        if (username != null && password != null)
        {
            try
            {
                if (dataSource == null)
                {
                    return false;
                }
                connection = dataSource.getConnection();
                if (connection == null)
                {
                    return false;
                }
                statement = connection.createStatement();
                if (statement == null)
                {
                    return false;
                }
                resultSet = statement.executeQuery(
                    "select username, password, firstName, lastName from users;");
                if (resultSet == null)
                {
                    return false;
                }

                while (resultSet.next())
                {
                    String uname = resultSet.getString(1);
                    if (uname.equals(username))
                    {
                        String passwrd = resultSet.getString(2);
                        if (passwrd.equals(password))
                        {
                            user = new User();
                            user.setUsername(username);
                            user.setPassword(password);
                            user.setFirstName(resultSet.getString(3));
                            user.setLastName(resultSet.getString(4));

                            loginResult = "Login Successful";
                            loginValid = true;
                        }
                    }
                }
            }
            catch (SQLException exc)
            {
                exc.printStackTrace();
            }
            finally
            {
                try
                {
                    if (resultSet != null)
                    {
                        resultSet.close();
                    }

                    if (statement != null)
                    {
                        statement.close();
                    }

                    if (connection != null)
                    {
                        connection.close();
                    }
                }
                catch (SQLException exc)
                {
                    exc.printStackTrace();
                }
            }
        }

        return loginValid;
    }

}
