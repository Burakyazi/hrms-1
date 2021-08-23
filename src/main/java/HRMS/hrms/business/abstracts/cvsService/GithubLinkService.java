package HRMS.hrms.business.abstracts.cvsService;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.entities.cvs.GithubLink;

public interface GithubLinkService {

    Result add(String url, int candidateId);

    DataResult<GithubLink> getbyUserId(int userId);
}
