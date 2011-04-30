package com.bitmarket.controllers;

import com.bitmarket.model.TmpStaticModel;
import com.bitmarket.model.User;
import com.bitmarket.services.LoginService;
import com.bitmarket.services.dal.MockUserRepository;
import com.bitmarket.services.dal.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value = "/login/*")
public class LoginController {
    // todo - get this via injection
    protected final Log logger = LogFactory.getLog(getClass());
    private final UserRepository userRepository = new MockUserRepository();

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
    public Object cheatLogin(long userId) {
        User user = userRepository.read(userId);
        return successfulLogin(user);
    }

    @RequestMapping(value = "showLogoutForm")
    public ModelAndView showLogoutForm() {
        return new ModelAndView("show-logout-form.jsp");
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public RedirectView logout() {
        TmpStaticModel.saveModel("user", null);
        return new RedirectView("../");
    }

    private RedirectView successfulLogin(User user) {
        // todo - set cookie

        // todo  remove this crap
        TmpStaticModel.saveModel("user", user);

        // todo - support returnUrl
        // todo - do an actual redirect to / (by returning RedirectView)

        // return new ModelAndView("../show.jsp", "user", user);
        return new RedirectView("../");
    }

    private void springExample() {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("services.xml"));
        LoginService service = (LoginService) beanFactory.getBean("LoginServiceBean");
        service.login("fo", "ao");
    }
}
