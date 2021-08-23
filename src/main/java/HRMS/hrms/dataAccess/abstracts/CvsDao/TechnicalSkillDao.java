package HRMS.hrms.dataAccess.abstracts.CvsDao;

import HRMS.hrms.entities.cvs.TechnicalSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnicalSkillDao extends JpaRepository<TechnicalSkill,Integer> {

    List<TechnicalSkill> getByCandidate_Id(int id);

}
