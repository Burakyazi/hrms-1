package HRMS.hrms.api.controller.cvsController;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.business.abstracts.cvsService.CoverLetterService;
import HRMS.hrms.entities.cvs.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coverLetter")
public class CoverLetterController {

    private final CoverLetterService coverLetterService;

    @Autowired
    public CoverLetterController(CoverLetterService coverLetterService) {
        this.coverLetterService = coverLetterService;
    }

    @PostMapping("add")
    public Result addCoverLetter(@RequestParam String summary, @RequestParam int userId){
        return coverLetterService.add(summary, userId);
    }

    @GetMapping("/getById")
    public DataResult<CoverLetter> getById(int userId){
        return coverLetterService.getByUSerId(userId);
    }
}
