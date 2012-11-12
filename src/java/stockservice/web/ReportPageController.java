/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockservice.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import stockservice.domain.HoldingsDao;
import stockservice.domain.LoginDao;
import stockservice.domain.UserStock;

/**
 *
 * @author rotalora
 */
public class ReportPageController extends AbstractController
{
    LoginDao loginDao;
    HoldingsDao holdingsDao;

    public ReportPageController()
    {
    }

    public void setHoldingsDao(HoldingsDao holdingsDao)
    {
        this.holdingsDao = holdingsDao;
    }

    public void setLoginDao(LoginDao loginDao)
    {
        this.loginDao = loginDao;
    }

    protected ModelAndView handleRequestInternal(HttpServletRequest request,
        HttpServletResponse response)
    {
        String symbol = null;
        String stockName = null;
        List<UserStock> userHoldings = null;
        Double value = 0.0;

        if (request != null)
        {
            symbol = request.getParameter("symbol");

            String username = holdingsDao.getUsername();
            userHoldings = holdingsDao.readUserHoldings(username, symbol);
            value = holdingsDao.getHoldingsValue();
        }
        stockName = userHoldings.get(0).getStockName();

        Map<String, Object> loginModel = new HashMap<String, Object>();
        loginModel.put("firstName", loginDao.getUser().getFirstName());
        loginModel.put("lastName", loginDao.getUser().getLastName());
        loginModel.put("stockname", stockName);
        loginModel.put("holdings", userHoldings);
        loginModel.put("value", value);

        ModelAndView mv = new ModelAndView("reportPage", "model", loginModel);

        return mv;
    }
}
