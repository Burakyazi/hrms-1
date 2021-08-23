package HRMS.hrms.business.concretes;

import HRMS.hrms.Core.utilities.results.ErrorResult;
import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.SuccessResult;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.Core.utilities.results.data.SuccessDataResult;
import HRMS.hrms.Core.utilities.results.verification.EmailVerification;
import HRMS.hrms.business.abstracts.CandidateService;
import HRMS.hrms.dataAccess.abstracts.CandidateDao;
import HRMS.hrms.entities.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private final CandidateDao candidateDao;
    private  EmailVerification emailVerification;


    @Autowired
    public CandidateManager(CandidateDao candidateDao) {
        super();
        this.candidateDao = candidateDao;

    }

    @Override
    public DataResult<List<Candidate>> findAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
    }

    @Override
    public Result add(Candidate candidate) {

        if (candidate.getEmail() == null || candidate.getFirstName() == null || candidate.getLastName() == null ||
        candidate.getPassword() == null || candidate.getIdentityNumber() == null || candidate.getBirthYear() == 0) {
            return new ErrorResult("Tüm alanlar zorunludur!");
        }
        if (!checkController(candidate.getEmail())) {
            return new ErrorResult("Email kullanılmaktadır.");
        }
        if (!checkController(candidate.getIdentityNumber())) {
            return new ErrorResult("Tc kimlik numarası kullanılmaktadır");
        }
        if (!emailVerification.checkUserEmail(candidate)) {
            return new ErrorResult("Kullanıcı email gecerli değildir.");
        }

        candidateDao.save(candidate);

        return  new SuccessResult("Candidate Eklendi");


    }

    protected boolean checkController(String info) {
        if (candidateDao.findByEmail(info) == null) {
            return true;
        }
        return false;
    }
}
