/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockservice.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import stockservice.domain.HoldingsDao;
import stockservice.domain.LoginDao;
import stockservice.domain.UserStock;

/**
 *
 * @author rotalora
 */
public class LoginController extends AbstractController
{
    LoginDao loginDao;
    HoldingsDao holdingsDao;

    public LoginController()
    {
    }

    public void setLoginDao(LoginDao loginDao)
    {
        this.loginDao = loginDao;
    }

    public void setHoldingsDao(HoldingsDao holdingsDao)
    {
        this.holdingsDao = holdingsDao;
    }

    protected ModelAndView handleRequestInternal(HttpServletRequest request,
        HttpServletResponse response)
    {
        String verificationMsg = null;

        HttpSession session = request.getSession();

        String username = null;
        String password = null;

        ModelAndView mv = null;

        if (request != null)
        {
            username = request.getParameter("username");
            password = request.getParameter("password");
        }

        if (username == null)
        {
            username = (String)session.getAttribute("username");
            password = (String)session.getAttribute("password");
        }

        boolean loginSuccessful = loginDao.verifyLoginDetails(
           username, password);
        if (loginSuccessful == false)
        {
            verificationMsg = loginDao.getLoginResult();
            Map<String, Object> loginModel = new HashMap<String, Object>();
            loginModel.put("username", username);
            loginModel.put("resultMsg", verificationMsg);
            
            mv = new ModelAndView("userLogin", "model", loginModel);
        }
        else
        {
            verificationMsg = loginDao.getLoginResult();
            List<UserStock> userHoldings = holdingsDao.readUserHoldings(username);
            Double value = holdingsDao.getHoldingsValue();

            List<UserStock> userHoldingsSummary = new ArrayList<UserStock>();
            Iterator iteratorBase = userHoldings.iterator();
            while (iteratorBase.hasNext())
            {
                UserStock userStockBase = (UserStock)iteratorBase.next();
                Iterator iteratorSummary = userHoldingsSummary.iterator();
                boolean foundStockInSummary = false;
                while (iteratorSummary.hasNext())
                {
                    UserStock userStockSummary = (UserStock)iteratorSummary.next();
                    String symbolBase = userStockBase.getSymbol();
                    String symbolSummary = userStockSummary.getSymbol();
                    if (symbolBase.equals(symbolSummary))
                    {
                        int quantityBase = userStockBase.getQuantity();
                        int quantitySummary = userStockSummary.getQuantity();
                        userStockSummary.setQuantity(quantityBase + quantitySummary);
                        Double newValue = userStockSummary.getQuantity() *
                           userStockSummary.getCurrentPrice();
                        userStockSummary.setValue(newValue);
                        foundStockInSummary = true;
                    }
                }
                if (!foundStockInSummary)
                {
                    userHoldingsSummary.add(userStockBase);
                }
            }

            /*
             * Set session attributes to keep the username and passwed
             */
            session.setAttribute("username", username);
            session.setAttribute("password", password);

            /*
             * Set the necessary data in the model to display to the user
             */
            Map<String, Object> loginModel = new HashMap<String, Object>();
            loginModel.put("firstName", loginDao.getUser().getFirstName());
            loginModel.put("lastName", loginDao.getUser().getLastName());
            loginModel.put("resultMsg", verificationMsg);
            loginModel.put("holdings", userHoldingsSummary);
            loginModel.put("value", value);

            mv = new ModelAndView("loginPage", "model", loginModel);
        }

        return mv;
    }
}
