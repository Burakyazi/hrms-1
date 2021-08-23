package HRMS.hrms.business.abstracts.cvsService;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.entities.cvs.SocialLink;

import java.util.List;

public interface SocialLinkService {

    Result add(String url, int id);

    DataResult<List<SocialLink>> getByUserId(int userId);
}
