package HRMS.hrms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "verify_codes")
@Entity
public class VerifyEmail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "code")
    private String code;

    @Column(name = "is_Confirmed",columnDefinition = "boolean default false")
    private boolean isConfirmed = false;

}
