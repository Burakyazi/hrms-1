package HRMS.hrms.api.controller;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.business.abstracts.JobPositionService;
import HRMS.hrms.entities.JobPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/jobTitles")
public class JobPositionController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobTitleService) {
        this.jobPositionService = jobTitleService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobPositions>> getAll(){
        return jobPositionService.getAll();
    }

    @PostMapping("/add")
    public Result addJobTitle(@RequestBody JobPositions jobTitle){
        return jobPositionService.add(jobTitle);
    }

    @GetMapping("/getAllActive")
    public DataResult<List<JobPositions>> getAllActive(){
        return jobPositionService.getAllActive();
    }

    @GetMapping("/getAllByDeadline")
    public DataResult<List<JobPositions>> getAllByDeadline(){
        return jobPositionService.getAllByDeadline();
    }

    @PostMapping("/getAllByCompanyName")
    public DataResult<List<JobPositions>> getAllByCompanyName(String companyName, boolean isActive){
        return jobPositionService.getAllByCompanyName(companyName, isActive);
    }

}
