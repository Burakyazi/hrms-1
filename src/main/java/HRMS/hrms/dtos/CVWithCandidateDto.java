package HRMS.hrms.dtos;

import HRMS.hrms.entities.*;
import HRMS.hrms.entities.cvs.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CVWithCandidateDto {

    private Candidate candidateName;

    private List<Education> educationSet;

    private List<JobExperience> jobExperienceSet;

    private List<Language> languageSet;

    private Image image;

    private GithubLink githubLink;

    private List<SocialLink> socialLinkSet;

    private List<TechnicalSkill> technicalSkillSet;

    private CoverLetter coverLetter;
}
