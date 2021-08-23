package HRMS.hrms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jop_positions")
public class JobPositions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "job_position_id")
    private Integer id;

    @Column(name = "title")
    private String jobName;

    @Column(name = "company_name")
    private String companyName;

    @NotNull
    @Size(min = 30,max = 200)
    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "salary_min")
    private String salaryMin;

    @Column(name = "salary_max")
    private String salaryMax;

    @NotNull
    @Min(value = 1, message = "En az 1 adet açık pozisyon bulunmalı")
    private Integer openPositions;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;


    @NotNull
    @Temporal(TemporalType.DATE)
    private Date applicationDeadline;

    @Column(name = "is_active",columnDefinition = "boolean default true")
    private boolean isActive = true;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Employer employer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
