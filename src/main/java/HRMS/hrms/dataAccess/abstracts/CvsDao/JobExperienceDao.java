package HRMS.hrms.dataAccess.abstracts.CvsDao;

import HRMS.hrms.entities.cvs.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.jar.JarException;

public interface JobExperienceDao extends JpaRepository<JarException,Integer> {

    List<JobExperience> getJobExperiencesByCandidate_IdOrderByStartDateOfWorkDesc(int candidateId);

}
