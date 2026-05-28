package com.charlie.JobApplication.job;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobService {

    List<Job> findAllJobs();

    void createJob(Job job);

    Job getJobById(Long id);

    ResponseEntity<String> deleteJobById(Long id);
}
