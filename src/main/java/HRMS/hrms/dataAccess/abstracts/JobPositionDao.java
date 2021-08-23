package HRMS.hrms.dataAccess.abstracts;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.entities.JobPositions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPositionDao extends JpaRepository<JobPositions,Integer> {

    JobPositions findById(String title);
    boolean existsById(String jobId);
    List<JobPositions> getAllByIsActiveIsTrue();

    @Query("Select new HRMS.hrms.entities.JobPositions" +
           "(jp.id,jp.title,jp.openPositions,jp.createDate,jp.applicationDeadline)" +
            "from JobPositions jp where jp.applicationDeadline")
    List<JobPositions> getAllByApplicationDeadline();

    @Query("Select new HRMS.hrms.entities.JobPositions" +
            "(jp.id,jp.title,jp.openPositions,jp.createDate,jp.applicationDeadline)" +
            "from JobPositions jp where jp.employer.companyName = ?1 and jp.isActive = ?2\"")
    List<JobPositions> getAllByCompanyName(String companyName);
    @Query("Select new HRMS.hrms.entities.JobPositions" +
            "(jp.id,j.title,jp.openPositions,jp.createDate,jp.applicationDeadline)" +
            "from JobPositions jp where jp.isActive = ?1")
    List<JobPositions> getAllByActiveJobs(boolean activeJobs);




}
