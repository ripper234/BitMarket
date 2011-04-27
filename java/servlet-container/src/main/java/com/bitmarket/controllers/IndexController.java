package com.bitmarket.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
    // todo - get this via injection
    protected final Log logger = LogFactory.getLog(getClass());

    public ModelAndView handleRequest() throws Exception {
        logger.info("Handling request");
        System.out.println("stdout - Returning hello view");
        return new ModelAndView("index.jsp");
    }
}

