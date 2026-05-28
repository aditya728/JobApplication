package com.charlie.JobApplication.job;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAllJobs(){
        return jobService.findAllJobs();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){
        jobService.createJob(job);
        return "Job added successfully";
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id){
        Job job =  jobService.getJobById(id);
        if(job != null){
            return job;
        }
        return new Job(-1L, "Job with ID: " + id + " does Not Exist");
    }
}
