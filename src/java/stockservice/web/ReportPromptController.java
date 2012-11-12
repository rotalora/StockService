/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockservice.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import stockservice.domain.HoldingsDao;
import stockservice.domain.LoginDao;
import stockservice.domain.StockData;
import stockservice.domain.UserStock;

/**
 *
 * @author rotalora
 */
public class ReportPromptController extends AbstractController
{
    LoginDao loginDao;
    HoldingsDao holdingsDao;

    public ReportPromptController()
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
        List<UserStock> userHoldings = holdingsDao.getHoldings();
        String username = holdingsDao.getUsername();

        /*
         * Make a list of unique symbols that the user holds to prompt
         * the user to select a stock to report
         */
        LinkedHashMap userStocks = new LinkedHashMap();
        Iterator iterator = userHoldings.iterator();
        while (iterator.hasNext())
        {
            UserStock userStock = (UserStock)iterator.next();
            userStocks.put(userStock.getSymbol(), userStock.getStockName());
        }

        /*
         * Build a list that contains the symbols and company names of the
         * stocks to be displayed as a selection list to the user
         */
        List<StockData> stockList = new ArrayList<StockData>();
        Collection collection = userStocks.keySet();
        iterator = collection.iterator();
        while (iterator.hasNext())
        {
            String symbol = (String)iterator.next();
            String stockName = (String)userStocks.get(symbol);
            StockData stockData = new StockData(symbol, stockName, 0);
            stockList.add(stockData);
        }

        /*
         * Add the necessary data to the model to display to the user
         */
        Map<String, Object> loginModel = new HashMap<String, Object>();
        loginModel.put("firstName", loginDao.getUser().getFirstName());
        loginModel.put("lastName", loginDao.getUser().getLastName());
        loginModel.put("userstocks", stockList);

        ModelAndView mv = new ModelAndView("reportPrompt", "model", loginModel);

        return mv;
    }
}
