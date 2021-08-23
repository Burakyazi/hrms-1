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
@Table(name = "github_links")
public class GithubLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Github url'i boş olamaz")
    private String url; //TODO Github linki url olarak nasıl alınabilir

    @OneToOne
    @JoinColumn(name = "user_id")
    private Candidate candidate;
}
