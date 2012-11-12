/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockservice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import junit.framework.TestCase;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rotalora
 */
public class PurchasePageControllerTests extends TestCase
{
    public void testHandleRequestView() throws Exception
    {
        PurchasePageController controller = new PurchasePageController();
        HttpServletRequest request = null;
        HttpServletResponse response = null;

        ModelAndView modelAndView = controller.handleRequest(request, response);
        assertEquals("purchasePage.jsp", modelAndView.getViewName());
    }

}
