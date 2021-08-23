package HRMS.hrms.business.concretes.cvsManager;

import HRMS.hrms.Core.utilities.results.ErrorResult;
import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.SuccessResult;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.Core.utilities.results.data.SuccessDataResult;
import HRMS.hrms.business.abstracts.cvsService.CoverLetterService;
import HRMS.hrms.dataAccess.abstracts.CandidateDao;
import HRMS.hrms.dataAccess.abstracts.CvsDao.CoverLetterDao;
import HRMS.hrms.entities.Candidate;
import HRMS.hrms.entities.cvs.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoverLettlerManager implements CoverLetterService {

    private final CoverLetterDao coverLetterDao;
    private final CandidateDao candidateDao;

    @Autowired
    public CoverLettlerManager(CoverLetterDao coverLetterDao, CandidateDao candidateDao) {
        this.coverLetterDao = coverLetterDao;
        this.candidateDao = candidateDao;
    }

    @Override
    public Result add(String summary, int candidateId) {
        Candidate candidate = candidateDao.getById(candidateId);
        if (candidateDao.existsById(candidateId)) {
            CoverLetter coverLetter = new CoverLetter();
            coverLetter.setSummary(summary);
            coverLetter.setCandidate(candidate);
            coverLetterDao.save(coverLetter);
            return new SuccessResult("Ön yazı eklendi");
        }
        return new ErrorResult("Kullanıcı bulunamadı");
    }

    @Override
    public DataResult<CoverLetter> getByUSerId(int userId) {
        return new SuccessDataResult<>(coverLetterDao.getByCandidate_Id(userId));
    }
}
