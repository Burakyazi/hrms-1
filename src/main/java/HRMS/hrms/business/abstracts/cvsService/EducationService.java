package HRMS.hrms.business.abstracts.cvsService;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.entities.cvs.Education;

import java.util.List;

public interface EducationService {

     Result addEducation(Education education, int candidateId);
     DataResult<List<Education>> getEducationsByCandidate_IdOrderByEntryDateDesc(int candidateId);
}
