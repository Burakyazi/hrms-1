package HRMS.hrms.business.abstracts;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.entities.Employer;

import java.util.List;

public interface EmployerService {

    Result add(Employer employer);
    DataResult<List<Employer>> getAll();
}
