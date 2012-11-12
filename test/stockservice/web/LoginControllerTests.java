/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockservice.web;

import javax.servlet.http.HttpServletRequest;
import junit.framework.TestCase;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rotalora
 */
public class LoginControllerTests extends TestCase
{
    public void testHandleRequestView() throws Exception
    {
        LoginController controller = new LoginController();

        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals("loginPage.jsp", modelAndView.getViewName());
    }
}

