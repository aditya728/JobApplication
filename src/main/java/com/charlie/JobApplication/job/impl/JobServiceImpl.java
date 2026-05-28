package com.charlie.JobApplication.job.impl;

import com.charlie.JobApplication.job.Job;
import com.charlie.JobApplication.job.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAllJobs() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job : jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public ResponseEntity<String> deleteJobById(Long id) {
        for(Job job : jobs){
            if(job.getId().equals(id)){
                jobs.remove(job);
                return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Job with ID: " + id + " does not exist.", HttpStatus.NOT_FOUND);
    }
}
