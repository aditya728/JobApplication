package com.charlie.JobApplication.company;

import com.charlie.JobApplication.job.Job;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    /*
    1. One company will have many jobs so OneToMany relationship is made
    2. mappedBy = "company" tells JPA that the relationship is managed by the 'company' field in the Job entity.
       So that no other join table is created
    3. Added JsonIgnore at this point because if not added then while json coversion, it will go in a infinite loop
       eg.: Job has company & company has jobs again and so on
     */
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Job> jobs;
}
