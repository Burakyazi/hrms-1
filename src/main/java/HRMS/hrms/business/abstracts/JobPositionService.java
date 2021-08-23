package HRMS.hrms.business.abstracts;


import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.entities.JobPositions;

import java.util.List;
import java.util.Optional;

public interface JobPositionService {

    DataResult<List<JobPositions>> getAll();
    Result add(JobPositions jobTitle);

    DataResult<List<JobPositions>> getAllActive();
    DataResult<List<JobPositions>> getAllByDeadline();
    DataResult<List<JobPositions>> getAllByCompanyName(String companyName, boolean isActive);
}
