package com.bitmarket;

import org.springframework.web.servlet.ModelAndView;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IndexControllerTest {
    @Test
    public void testHandleRequestView() throws Exception {
        IndexController controller = new IndexController();
        ModelAndView modelAndView = controller.handleRequest(null, null);
        Assert.assertEquals("hello.jsp", modelAndView.getViewName());
    }
}
