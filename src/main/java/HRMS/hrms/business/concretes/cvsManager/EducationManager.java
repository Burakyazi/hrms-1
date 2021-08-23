package HRMS.hrms.business.concretes.cvsManager;

import HRMS.hrms.Core.utilities.results.ErrorResult;
import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.SuccessResult;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.Core.utilities.results.data.SuccessDataResult;
import HRMS.hrms.business.abstracts.cvsService.EducationService;
import HRMS.hrms.dataAccess.abstracts.CandidateDao;
import HRMS.hrms.dataAccess.abstracts.CvsDao.EducationDao;
import HRMS.hrms.entities.cvs.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationManager implements EducationService {

    private final EducationDao educationDao;
    private final CandidateDao candidateDao;

    @Autowired
    public EducationManager(EducationDao educationDao, CandidateDao candidateDao) {
        this.educationDao = educationDao;
        this.candidateDao = candidateDao;
    }


    @Override
    public Result addEducation(Education education, int candidateId) {
        if(candidateDao.existsById(candidateId)){
            education.setCandidate(candidateDao.getById(candidateId));
            educationDao.save(education);
            return new SuccessResult("Kaydedildi");
        }else{
            return new ErrorResult("Kullanıcı bulunamadı");
        }
    }

    @Override
    public DataResult<List<Education>> getEducationsByCandidate_IdOrderByEntryDateDesc(int candidateId) {
        return new SuccessDataResult<>(educationDao.getEducationsByCandidate_IdOrderByEntryDateDesc(candidateId));
    }
}
