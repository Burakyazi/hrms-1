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
@Table(name = "educations")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Candidate candidate;

    @NotBlank(message = "Okul ismi boş olamaz")
    private String schoolName;

    @NotBlank(message = "Bölüm boş olamaz")
    private String schoolDepartmentName;

    @NotNull(message = "Mezuniyet bilgisi boş olamaz (örn: true veya false)")
    private boolean isGraduated;

    //https://vladmihalcea.com/whats-new-in-jpa-2-2-java-8-date-and-time-types/
    //https://www.baeldung.com/jpa-java-time#after-java-8

    @NotNull(message = "Okul başlangıç tarihi boş olamaz (örn: 2021-08-16)")
    @Column(columnDefinition = "DATE")
    private LocalDate entryDate;

    @Column(columnDefinition = "DATE")
    private LocalDate graduationDate;
}
