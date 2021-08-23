package HRMS.hrms.entities.cvs;

import HRMS.hrms.entities.Candidate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "job_experiences")
public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Candidate candidate;

    @NotBlank(message = "Firma ismi boş olamaz")
    private String companyName;

    @NotBlank(message = "İş pozisyonu boş olamaz")
    private String jobPosition;

    @NotNull(message = "İşe giriş tarihi boş olamaz (örn: 2021-08-16)")
    @Column(columnDefinition = "DATE")
    private LocalDate startDateOfWork;

    @Column(columnDefinition = "DATE")
    private LocalDate dismissalDate;

    @NotNull(message = "İş çıkış bilgisi boş olamaz (örn: true veya false)")
    private boolean isDismissed;


}
