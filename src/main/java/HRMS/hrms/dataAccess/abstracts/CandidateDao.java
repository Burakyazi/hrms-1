package HRMS.hrms.dataAccess.abstracts;

import HRMS.hrms.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateDao extends JpaRepository<Candidate,Integer> {

    Candidate findByEmail(String email);

    Candidate getById(int candidateId);
}
