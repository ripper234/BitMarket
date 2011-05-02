package com.bitmarket.services.dal;

import com.bitmarket.model.Job;
import com.bitmarket.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockJobRepository implements JobRepository{
    private UserRepository userRepository = new MockUserRepository();

    @Override
    public List<Job> readAll() {
        List<Job> jobs = new ArrayList<Job>();
        jobs.add(createJob(1, userRepository.read(1), 1, "My first job", "This is just a test job, I don't really want you to do anything."));
        jobs.add(createJob(2, userRepository.read(2), 25, "Build BitMarket website", "Build the BitMarket website according to the mockups. You should use java, SpringMVC, and a bit of spice to make it a nice looking site."));
        jobs.add(createJob(3, userRepository.read(2), 0.12345678901234567687828749832, "How do I redirect in SpringMVC?", "Please see the details on http://stackoverflow.com/q/12215/how-do-i-redirect-in-spring-mvc"));
        jobs.add(createJob(4, userRepository.read(2), 100, "Buy me a Kindle and deliver it to my Israel address (Tel Aviv)", "Kindle 3 WiFi, should cost exactly $140 via Amazon. Please deliver to Tel Aviv, Ben Guryion Street"));
        return jobs;
    }

    private Job createJob(long id, User poster, double price, String title, String body) {
        Job job = new Job();
        job.setId(id);
        job.setTitle(title);
        job.setPrice(new BigDecimal(price));
        job.setBody(body);
        job.setPoster(poster);
        job.setExpiryDate(new Date());
        job.setPostedDate(new Date());
        return job;
    }

    @Override
    public Job read(long id) {
        return null;
    }

    public List<Job> readPostedBy(long userId) {
        // todo - smarter filtering
        List<Job> all = readAll();
        ArrayList<Job> result = new ArrayList<Job>();
        for (Job job : all)
            if (job.getPoster().getId() == userId)
                result.add(job);
        return result;
    }
}
