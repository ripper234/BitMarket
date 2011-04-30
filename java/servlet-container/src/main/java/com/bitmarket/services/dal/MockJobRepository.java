package com.bitmarket.services.dal;

import com.bitmarket.model.Job;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MockJobRepository implements JobRepository{
    @Override
    public List<Job> readAll() {
        List<Job> jobs = new ArrayList<Job>();
        jobs.add(createJob(1, 1, "My first job", "This is just a test job, I don't really want you to do anything."));
        jobs.add(createJob(25, 2, "Build BitMarket website", "Build the BitMarket website according to the mockups. You should use java, SpringMVC, and a bit of spice to make it a nice looking site."));
        jobs.add(createJob(0.12345678901234567687828749832, 3, "How do I redirect in SpringMVC?", "Please see the details on http://stackoverflow.com/q/12215/how-do-i-redirect-in-spring-mvc"));
        return jobs;
    }

    private Job createJob(double price, long id, String title, String body) {
        Job job = new Job();
        job.setId(id);
        job.setTitle(title);
        job.setPrice(new BigDecimal(price));
        job.setBody(body);
        return job;
    }

    @Override
    public Job read(long id) {
        return null;
    }
}
