package HRMS.hrms.dataAccess.abstracts;

import HRMS.hrms.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDao extends JpaRepository<Employer,Integer> {

    Employer getEmployerByEmail(String email);


}
