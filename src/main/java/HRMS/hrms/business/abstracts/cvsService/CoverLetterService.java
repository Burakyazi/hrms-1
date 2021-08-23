package HRMS.hrms.business.abstracts.cvsService;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.entities.cvs.CoverLetter;

public interface CoverLetterService {

    Result add(String summary, int candidateId);

    DataResult<CoverLetter> getByUSerId(int userId);
}
