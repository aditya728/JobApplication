package com.charlie.JobApplication.job.impl;

import com.charlie.JobApplication.job.Job;
import com.charlie.JobApplication.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findALlJobs() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }
}
