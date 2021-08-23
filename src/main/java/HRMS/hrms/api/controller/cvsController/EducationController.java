package HRMS.hrms.api.controller.cvsController;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.business.abstracts.cvsService.EducationService;
import HRMS.hrms.entities.cvs.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationController {

    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody Education education, int candidateId){
        return educationService.addEducation(education, candidateId);
    }

    @GetMapping("/getByDateDesc")
    public DataResult<List<Education>> getByDateDesc(int candidateId){
        return educationService.getEducationsByCandidate_IdOrderByEntryDateDesc(candidateId);
    }

}
