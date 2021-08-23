package HRMS.hrms.business.concretes.cvsManager;

import HRMS.hrms.Core.utilities.results.ErrorResult;
import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.SuccessResult;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.Core.utilities.results.data.SuccessDataResult;
import HRMS.hrms.business.abstracts.cvsService.SocialLinkService;
import HRMS.hrms.dataAccess.abstracts.CandidateDao;
import HRMS.hrms.dataAccess.abstracts.CvsDao.SocialLinkDao;
import HRMS.hrms.entities.Candidate;
import HRMS.hrms.entities.cvs.SocialLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SocialLinkManager implements SocialLinkService {

    private final SocialLinkDao socialLinkDao;
    private final CandidateDao candidateDao;

    @Autowired
    public SocialLinkManager(SocialLinkDao socialLinkDao, CandidateDao candidateDao) {
        this.socialLinkDao = socialLinkDao;
        this.candidateDao = candidateDao;
    }

    @Override
    public Result add(String url, int id) {
        if (socialLinkDao.existsByUrl(url))
            return new ErrorResult("Bu URL daha önce sisteme kaydolmuş");

        if (candidateDao.existsById(id)) {
            Candidate candidate = candidateDao.getById(id);
            SocialLink socialLink = new SocialLink();
            socialLink.setUrl(url);
            socialLink.setCandidate(candidate);
            socialLinkDao.save(socialLink);
            return new SuccessResult("Başarılı");
        } else {
            return new ErrorResult("Kullanıcı bulunamadı");
        }
    }

    @Override
    public DataResult<List<SocialLink>> getByUserId(int userId) {
        return new SuccessDataResult<>(socialLinkDao.getByCandidate_Id(userId));
    }
}
