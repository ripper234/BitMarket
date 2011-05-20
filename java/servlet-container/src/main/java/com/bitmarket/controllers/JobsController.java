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
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

@Controller
@RequestMapping(value = "/jobs/*")
public class JobsController {
    // todo - get this via injection
    protected final Log logger = LogFactory.getLog(getClass());
    private final JobRepository jobsRepo = new MockJobRepository();

    @RequestMapping(value = "showJobs")
    public ModelAndView showJobs() throws Exception {
        logger.info("Handling request");
        System.out.println("stdout - Returning hello view");

        // todo - filter the jobs
        List<Job> jobs = jobsRepo.readAll();

        Map<String, Object> map = newHashMap();
        map.put("jobs", jobs);
        map.put("user", null); // todo
        return new ModelAndView("showJobs.jsp", map);
    }

    @RequestMapping(value = "showJob")
    public ModelAndView showJob(long jobId) throws Exception {
        Job job = jobsRepo.read(jobId);
        TmpStaticModel.saveModel("job", job);
        return new ModelAndView("showJob.jsp", "job", job);
    }
}

