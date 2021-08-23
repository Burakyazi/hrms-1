package HRMS.hrms.business.concretes.cvsManager;

import HRMS.hrms.Core.utilities.results.ErrorResult;
import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.SuccessResult;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.Core.utilities.results.data.SuccessDataResult;
import HRMS.hrms.business.abstracts.cvsService.TechnicalSkillService;
import HRMS.hrms.dataAccess.abstracts.CandidateDao;
import HRMS.hrms.dataAccess.abstracts.CvsDao.TechnicalSkillDao;
import HRMS.hrms.entities.Candidate;
import HRMS.hrms.entities.cvs.TechnicalSkill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalSkillManager implements TechnicalSkillService {

    private final TechnicalSkillDao technicalSkillDao;
    private final CandidateDao candidateDao;

    public TechnicalSkillManager(TechnicalSkillDao technicalSkillDao, CandidateDao candidateDao) {
        this.technicalSkillDao = technicalSkillDao;
        this.candidateDao = candidateDao;
    }


    @Override
    public Result add(String skillName, int id) {
        if(candidateDao.existsById(id)){
            Candidate candidate = candidateDao.getById(id);
            TechnicalSkill technicalSkill = new TechnicalSkill();
            technicalSkill.setSkillName(skillName);
            technicalSkill.setCandidate(candidate);
            technicalSkillDao.save(technicalSkill);
            return new SuccessResult("Başarılı");
        }else{
            return new ErrorResult("Kullanıcı bulunamadı");
        }
    }

    @Override
    public DataResult<List<TechnicalSkill>> getByUserId(int userId) {
        return new SuccessDataResult<>(technicalSkillDao.getByCandidate_Id(userId));
    }
}
