package HRMS.hrms.business.abstracts.cvsService;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.entities.cvs.TechnicalSkill;

import java.util.List;

public interface TechnicalSkillService {

    Result add(String skillName, int id);

    DataResult<List<TechnicalSkill>> getByUserId(int userId);
}
