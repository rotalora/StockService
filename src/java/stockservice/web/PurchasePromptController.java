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
public class PurchasePromptController extends AbstractController
{
    LoginDao loginDao;
    HoldingsDao holdingsDao;

    public PurchasePromptController()
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

        Map<String, Object> loginModel = new HashMap<String, Object>();
        loginModel.put("firstName", loginDao.getUser().getFirstName());
        loginModel.put("lastName", loginDao.getUser().getLastName());
        loginModel.put("holdings", userHoldings);

        ModelAndView mv = new ModelAndView("purchasePrompt", "model", loginModel);

        return mv;
    }
}
