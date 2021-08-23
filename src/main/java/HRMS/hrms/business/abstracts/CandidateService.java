package HRMS.hrms.business.abstracts;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.entities.Candidate;

import java.util.List;

public interface CandidateService {

    DataResult<List<Candidate>> findAll();
    Result add(Candidate candidate);

}
