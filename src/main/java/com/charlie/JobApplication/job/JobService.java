package com.charlie.JobApplication.job;

import java.util.List;

public interface JobService {

    List<Job> findALlJobs();

    void createJob(Job job);
}
