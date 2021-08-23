package HRMS.hrms.entities.cvs;

import HRMS.hrms.entities.Candidate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cover_letters")
public class CoverLetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Ön yazı boş olamaz.")
    private String summary;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private Candidate candidate;
}
