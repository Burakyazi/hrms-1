package HRMS.hrms.entities.cvs;

import HRMS.hrms.entities.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "social_links")
public class SocialLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Url boş olamaz")
    private String url;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Candidate candidate;
}
