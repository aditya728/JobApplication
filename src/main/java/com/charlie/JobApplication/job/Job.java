package com.charlie.JobApplication.job;

import lombok.Data;

@Data
public class Job {

    private Long id;
    private String title;
    private String description;
    private Integer minSalary;
    private Integer maxSalary;
    private String location;
}
