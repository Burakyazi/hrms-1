package HRMS.hrms.api.controller.cvsController;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.business.abstracts.cvsService.LanguageService;
import HRMS.hrms.entities.cvs.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }


    @PostMapping("/add")
    public Result add(@Valid @RequestBody Language language, int candidateId){
        return languageService.addLanguageToCandidate(language, candidateId);
    }
}
