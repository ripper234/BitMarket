package com.bitmarket.controllers;

import com.bitmarket.model.Job;
import com.bitmarket.model.TmpStaticModel;
import com.bitmarket.model.User;
import com.bitmarket.services.dal.MockJobRepository;
import com.bitmarket.services.dal.MockUserRepository;
import com.bitmarket.services.dal.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user/*")
public class UserController {
    private final UserRepository userRepository = new MockUserRepository();
    private final MockJobRepository jobRepository = new MockJobRepository();

    @RequestMapping(value = "showUser")
    public ModelAndView show(long userId) {
        User user = userRepository.read(userId);
        List<Job> jobs = jobRepository.readPostedBy(user.getId());
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("viewedUser", user);
        model.put("viewedUserPostedJobs", jobs);
        TmpStaticModel.saveModel(model);
        return new ModelAndView("showUser.jsp", model);
    }
}
