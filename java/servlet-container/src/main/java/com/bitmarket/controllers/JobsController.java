package com.bitmarket.controllers;

import com.bitmarket.model.Job;
import com.bitmarket.model.TmpStaticModel;
import com.bitmarket.services.dal.JobRepository;
import com.bitmarket.services.dal.MockJobRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/jobs/*")
public class JobsController {
    // todo - get this via injection
    protected final Log logger = LogFactory.getLog(getClass());
    private final JobRepository jobsRepo = new MockJobRepository();

    @RequestMapping(value = "show")
    public ModelAndView handleRequest() throws Exception {
        logger.info("Handling request");
        System.out.println("stdout - Returning hello view");

        List<Job> jobs = jobsRepo.readAll();
        TmpStaticModel.saveModel("jobs", jobs);

        // todo - filter jobs
        return new ModelAndView("show.jsp", "jobs", jobs);
    }
}

