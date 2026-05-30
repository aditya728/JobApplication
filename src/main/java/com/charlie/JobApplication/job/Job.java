package com.charlie.JobApplication.job;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer minSalary;
    private Integer maxSalary;
    private String location;

    /*
    A noArg Constructor is needed as JPA needs to create instances of entity class while retrieval of data
     */
    public Job(){}

    public Job(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
