package HRMS.hrms.dataAccess.abstracts.CvsDao;

import HRMS.hrms.entities.cvs.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverLetterDao extends JpaRepository<CoverLetter,Integer> {

    CoverLetter getByCandidate_Id(int id);
}
