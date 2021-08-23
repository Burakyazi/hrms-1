package HRMS.hrms.business.concretes;

import HRMS.hrms.Core.utilities.results.ErrorResult;
import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.SuccessResult;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.Core.utilities.results.data.SuccessDataResult;
import HRMS.hrms.business.abstracts.JobPositionService;
import HRMS.hrms.dataAccess.abstracts.JobPositionDao;
import HRMS.hrms.entities.JobPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private final JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobTitleDao) {
        super();
        this.jobPositionDao = jobTitleDao;
    }
    @Override
    public DataResult<List<JobPositions>> getAll() {
        return new SuccessDataResult<List<JobPositions>>(jobPositionDao.findAll()
        );
    }

    @Override
    public Result add(JobPositions jobTitle) {

        if (!CheckTitle(jobTitle.getJobName())) {
            return new ErrorResult("Lütfen tekrar deneyiniz! Bu pozisyon sistemde mevcuttur.");
        }
        jobPositionDao.save(jobTitle);
        return new  SuccessResult("Pozisyon eklendi.");
    }


    @Override
    public DataResult getAllActive() {
        return new DataResult<>(jobPostingListingDtoList(jobPositionDao.getAllByIsActiveIsTrue()),true,"Veri getirildi");
    }

    @Override
    public DataResult<List<JobPositions>> getAllByDeadline() {
        return new DataResult<>(jobPostingListingDtoList(jobPositionDao.getAllByApplicationDeadline()), true,"Veri getirildi");
    }

    @Override
    public DataResult<List<JobPositions>> getAllByCompanyName(String companyName, boolean isActive) {
        return new SuccessDataResult<>(jobPositionDao.getAllByCompanyName(companyName), isActive, "Veri getirildi");
    }

    private boolean CheckTitle(String title){
        if (jobPositionDao.findById(title) == null) {
            return true;
        }
        return false;
    }

    private List<JobPositions> jobPostingListingDtoList(List<JobPositions> jobPostingList){

        List<JobPositions> jobPostingWithEmployerAndJobPositionDtos = new ArrayList<>();
        JobPositions dto;

        for (JobPositions posting : jobPostingList) {
            dto = new JobPositions();
            dto.setId(posting.getId());
            dto.setCompanyName(posting.getEmployer().getCompanyName());
            dto.setJobName(posting.getJobName());
            dto.setOpenPositions(posting.getOpenPositions());
            dto.setCreateDate(posting.getCreateDate());
            dto.setApplicationDeadline(posting.getApplicationDeadline());
            jobPostingWithEmployerAndJobPositionDtos.add(dto);
        }
        return jobPostingWithEmployerAndJobPositionDtos;
    }
}
