package HRMS.hrms.api.controller.cvsController;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.business.abstracts.cvsService.GithubLinkService;
import HRMS.hrms.entities.cvs.GithubLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gitHubLinks")
public class GithubLinkController {

    private final GithubLinkService githubLinkService;

    @Autowired
    public GithubLinkController(GithubLinkService githubLinkService) {
        this.githubLinkService = githubLinkService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody String url, int userId){
        return githubLinkService.add(url, userId);
    }

    @GetMapping("/getByUserId")
    public DataResult<GithubLink> getByUserId(int userId){
        return githubLinkService.getbyUserId(userId);
    }
}
