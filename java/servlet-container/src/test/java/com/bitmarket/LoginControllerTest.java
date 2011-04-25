package com.bitmarket;

import com.bitmarket.controllers.LoginController;
import org.springframework.web.servlet.ModelAndView;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginControllerTest {
    @Test
    public void testHandleRequestView() throws Exception {
        LoginController controller = new LoginController();
        ModelAndView modelAndView = controller.handleRequest(null, null);
        Assert.assertEquals("login.jsp", modelAndView.getViewName());
    }
}
