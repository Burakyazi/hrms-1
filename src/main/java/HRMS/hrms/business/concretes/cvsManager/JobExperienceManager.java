package HRMS.hrms.business.concretes.cvsManager;

import HRMS.hrms.Core.utilities.results.ErrorResult;
import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.SuccessResult;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.Core.utilities.results.data.SuccessDataResult;
import HRMS.hrms.business.abstracts.cvsService.JobExperienceService;
import HRMS.hrms.dataAccess.abstracts.CandidateDao;
import HRMS.hrms.dataAccess.abstracts.CvsDao.JobExperienceDao;
import HRMS.hrms.entities.cvs.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobExperienceManager implements JobExperienceService {

    private final JobExperienceDao jobExperienceDao;
    private final CandidateDao candidateDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao, CandidateDao candidateDao) {
        this.jobExperienceDao = jobExperienceDao;
        this.candidateDao = candidateDao;
    }

    @Override
    public Result addJobExperience(JobExperience jobExperience, int candidateId) {
        if(candidateDao.existsById(candidateId)){
            jobExperience.setCandidate(candidateDao.getById(candidateId));
            jobExperienceDao.save(jobExperience);
            return new SuccessResult("Kaydedildi");
        }else{
            return new ErrorResult("Kullanıcı bulunamadı");
        }
    }

    @Override
    public DataResult<List<JobExperience>> getJobExperiencesByCandidate_IdOrderByStartDateOfWorkStartDateOfWorkDesc(int candidateId) {
        return new SuccessDataResult<>(jobExperienceDao.getJobExperiencesByCandidate_IdOrderByStartDateOfWorkDesc(candidateId));
    }
}
