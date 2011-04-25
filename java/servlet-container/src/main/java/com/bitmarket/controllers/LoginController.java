package com.bitmarket.controllers;

import com.bitmarket.services.LoginService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {
    // todo - get this via injection
    protected final Log logger = LogFactory.getLog(getClass());

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("Handling request");
        System.out.println("stdout - Returning hello view");



        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("services.xml"));
        LoginService service = (LoginService) beanFactory.getBean("LoginServiceBean");
        service.login("fo", "ao");
        return new ModelAndView("login.jsp");
    }
}
