package HRMS.hrms.api.controller.cvsController;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.business.abstracts.cvsService.SocialLinkService;
import HRMS.hrms.entities.cvs.SocialLink;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/socialLinks")
public class SocialLinkController {

    private final SocialLinkService socialLinkService;

    public SocialLinkController(SocialLinkService socialLinkService) {
        this.socialLinkService = socialLinkService;
    }
    @PostMapping("/add")
    public Result add(String url, int userId){
        return socialLinkService.add(url, userId);
    }

    @GetMapping("/getByUserId")
    public DataResult<List<SocialLink>> getByUserId(int userId){
        return socialLinkService.getByUserId(userId);
    }
}
