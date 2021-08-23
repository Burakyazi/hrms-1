package HRMS.hrms.business.abstracts.cvsService;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.entities.cvs.Language;

import java.util.List;

public interface LanguageService {

    Result addLanguageToCandidate(Language language, int candidateId);

    DataResult<List<Language>> getByUserId(int userId);
}
