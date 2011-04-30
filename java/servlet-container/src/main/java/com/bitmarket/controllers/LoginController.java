package com.bitmarket.controllers;

import com.bitmarket.model.TmpModelResolverCrap;
import com.bitmarket.model.User;
import com.bitmarket.services.LoginService;
import com.bitmarket.services.dal.FakeUserRepository;
import com.bitmarket.services.dal.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login/*")
public class LoginController {
    // todo - get this via injection
    protected final Log logger = LogFactory.getLog(getClass());
    private final UserRepository fakeUserRepository = new FakeUserRepository();

    @RequestMapping("showProviders")
    public ModelAndView showProviders() {
        logger.info("Displaying login options");
        System.out.println("Displaying login options");
        return new ModelAndView("openid-selector/login-show-providers.jsp");
    }

    @RequestMapping(value = "startLogin", method = RequestMethod.POST)
    public ModelAndView startLogin(String openid_identifier) {
        logger.info(String.format("Starting login process with openID '%s'", openid_identifier));
        System.out.println("Starting login process");
        return new ModelAndView("login-with-provider.jsp", "openid", openid_identifier);
    }

    @RequestMapping(value = "cheatLogin")
    public ModelAndView cheatLogin(long userId) {
        User user = fakeUserRepository.read(userId);
        return successfulLogin(user);
    }

    private ModelAndView successfulLogin(User user) {
        // todo - set cookie

        // todo  remove this crap
        TmpModelResolverCrap.saveModel(user);

        return new ModelAndView("successful-login.jsp", "user", user);
    }

    private void springExample() {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("services.xml"));
        LoginService service = (LoginService) beanFactory.getBean("LoginServiceBean");
        service.login("fo", "ao");
    }
}
