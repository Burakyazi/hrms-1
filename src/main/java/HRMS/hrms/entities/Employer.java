package HRMS.hrms.entities;

import HRMS.hrms.Core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@Entity
public class Employer extends User {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_address")
    private String webAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_verified",columnDefinition = "booleaned default false")
    private boolean isVerified = false;

    @OneToMany(mappedBy = "employer")
    private List<JobPositions> jobPositions;




}
