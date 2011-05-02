package com.bitmarket.services.dal;

import com.bitmarket.model.Job;

import java.util.List;

public interface JobRepository extends Repository<Job> {

    List<Job> readAll();
}
