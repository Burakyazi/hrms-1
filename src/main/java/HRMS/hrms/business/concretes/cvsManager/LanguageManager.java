package HRMS.hrms.business.concretes.cvsManager;

import HRMS.hrms.Core.utilities.results.ErrorResult;
import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.SuccessResult;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.Core.utilities.results.data.SuccessDataResult;
import HRMS.hrms.business.abstracts.cvsService.LanguageService;
import HRMS.hrms.dataAccess.abstracts.CandidateDao;
import HRMS.hrms.dataAccess.abstracts.CvsDao.LanguageDao;
import HRMS.hrms.entities.cvs.Language;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageManager implements LanguageService {

    private final LanguageDao languageDao;
    private final CandidateDao candidateDao;

    public LanguageManager(LanguageDao languageDao, CandidateDao candidateDao) {
        this.languageDao = languageDao;
        this.candidateDao = candidateDao;
    }

    @Override
    public Result addLanguageToCandidate(Language language, int candidateId) {
        if(candidateDao.existsById(candidateId)){
            language.setCandidate(candidateDao.getById(candidateId));
            languageDao.save(language);
            return new SuccessResult("Kaydedildi");
        }else{
            return new ErrorResult("Kullanıcı bulunamadı");
        }
    }

    @Override
    public DataResult<List<Language>> getByUserId(int userId) {
        return new SuccessDataResult<>(languageDao.getByCandidate_Id(userId));
    }
}
