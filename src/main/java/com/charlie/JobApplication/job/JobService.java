package com.charlie.JobApplication.job;

import java.util.List;

public interface JobService {

    List<Job> findAllJobs();

    void createJob(Job job);

    Job getJobById(Long id);
}
