package HRMS.hrms.business.concretes.cvsManager;

import HRMS.hrms.Core.utilities.results.ErrorResult;
import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.SuccessResult;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.Core.utilities.results.data.SuccessDataResult;
import HRMS.hrms.business.abstracts.CandidateService;
import HRMS.hrms.business.abstracts.cvsService.GithubLinkService;
import HRMS.hrms.dataAccess.abstracts.CandidateDao;
import HRMS.hrms.dataAccess.abstracts.CvsDao.GithubLinkDao;
import HRMS.hrms.entities.Candidate;
import HRMS.hrms.entities.cvs.GithubLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GithubLinkManager implements GithubLinkService {

    private final GithubLinkDao githubLinkDao;
    private final CandidateDao candidateDao;
    private CandidateService candidateService;

    @Autowired
    public GithubLinkManager(GithubLinkDao githubLinkDao, CandidateDao candidateDao) {
        this.githubLinkDao = githubLinkDao;
        this.candidateDao = candidateDao;
    }


    @Override
    public Result add(String url, int candidateId) {

        if(githubLinkDao.existsByUrl(url)) {
            return new ErrorResult("Bu URL daha önce sisteme kaydolmuş");

            Candidate candidate = candidateDao.getById(candidateId);
            GithubLink githubLink = new GithubLink();
            githubLink.setUrl(url);
            githubLink.setCandidate(candidate);
            githubLinkDao.save(githubLink);
            return new SuccessResult("Başarılı");
        }else
        return new ErrorResult("Github linki eklenemedi.");
    }

    @Override
    public DataResult<GithubLink> getbyUserId(int userId) {
        return new SuccessDataResult<>(githubLinkDao.getByCandidate_Id(userId));
    }
}
