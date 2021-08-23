package HRMS.hrms.api.controller;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.business.abstracts.EmployerService;
import HRMS.hrms.entities.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/Employers")
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll(){
       return employerService.getAll();
    }

    @PostMapping("/add")
    public Result addEmployer(@RequestBody Employer employer){
        return employerService.add(employer);
    }
}
