package HRMS.hrms.entities.cvs;

import HRMS.hrms.entities.Candidate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Languages")
@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "İsim boş olamaz")
    private String name;

    @NotNull(message = "Dil seviyesi boş olamaz")
    @Range(min = 1, max = 5, message = "Dil seviyesi 1 ile 5 arasında olmalı")
    private int level;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Candidate candidate;
}
