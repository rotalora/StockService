/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockservice.web;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import stockservice.domain.HoldingsDao;
import stockservice.domain.LoginDao;
import stockservice.domain.StockData;
import stockservice.domain.StockTickerDao;
import stockservice.domain.UserStock;

/**
 *
 * @author rotalora
 */
public class PurchasePageController extends AbstractController
{
    LoginDao loginDao;
    HoldingsDao holdingsDao;

    public PurchasePageController()
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
        String sQuantity = null;
        ModelAndView modelView = null;
        String username = holdingsDao.getUsername();

        if (request != null)
        {
            symbol = request.getParameter("symbol");
            sQuantity = request.getParameter("quantity");
        }

        if (symbol != null && sQuantity != null)
        {
            Calendar calendar = Calendar.getInstance();
            Date today = calendar.getTime();
            int quantity = Integer.parseInt(sQuantity);

            StockTickerDao stockTickerDao = StockTickerDao.getInstance();
            StockData stockData = stockTickerDao.getStockPrice(symbol);
            Double value = stockData.getPrice() * quantity;
            UserStock userStock = new UserStock(username, symbol,
                stockData.getStockName(), stockData.getPrice(),
                stockData.getPrice(), today, quantity, value);
            holdingsDao.saveUserStockData(userStock);

            Map<String, Object> loginModel = new HashMap<String, Object>();
            loginModel.put("firstName", loginDao.getUser().getFirstName());
            loginModel.put("lastName", loginDao.getUser().getLastName());
            loginModel.put("userstock", userStock);

            modelView = new ModelAndView("purchasePage", "model", loginModel);
        }
        else
        {
            Map<String, Object> loginModel = new HashMap<String, Object>();
            loginModel.put("firstName", loginDao.getUser().getFirstName());
            loginModel.put("lastName", loginDao.getUser().getLastName());
            loginModel.put("userstock", null);

            modelView = new ModelAndView("purchasePage", "model", loginModel);
        }

        return modelView;
    }
}
