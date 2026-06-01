package com.charlie.JobApplication.review;

import com.charlie.JobApplication.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String reviewDescription;
    private double rating;

    @JsonIgnore
    @ManyToOne
    private Company company;

}
