package HRMS.hrms.business.abstracts.cvsService;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.entities.cvs.JobExperience;

import java.util.List;

public interface JobExperienceService {

    Result addJobExperience(JobExperience jobExperience, int candidateId);
    DataResult<List<JobExperience>> getJobExperiencesByCandidate_IdOrderByStartDateOfWorkStartDateOfWorkDesc(int candidateId);
}
