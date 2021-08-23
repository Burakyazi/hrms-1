package HRMS.hrms.business.concretes;

import HRMS.hrms.Core.utilities.results.ErrorResult;
import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.SuccessResult;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.Core.utilities.results.data.SuccessDataResult;
import HRMS.hrms.Core.utilities.results.verification.EmailVerification;
import HRMS.hrms.Core.utilities.results.verification.HrmsVerification;
import HRMS.hrms.business.abstracts.EmployerService;
import HRMS.hrms.dataAccess.abstracts.EmployerDao;
import HRMS.hrms.entities.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private final EmployerDao employerDao;
    private HrmsVerification hrmsVerification;
    private EmailVerification emailVerification;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        super();
        this.employerDao = employerDao;
    }


    @Override
    public Result add(Employer employer) {

        if (employer.getEmail() == null || employer.getCompanyName() == null || employer.getWebAddress() == null
        || employer.getPassword()== null || employer.getPhoneNumber() == null) {
            return new ErrorResult("Tüm alanlar doldurulmalıdır.");

        } else if (!checkEmployerController(employer.getEmail())){
            return new ErrorResult("Email adresi kullanılmaktadır!");

        } else if (!emailVerification.checkUserEmail(employer)){
            return new ErrorResult("email geçerli değildir!");

        } else if (!hrmsVerification.checkHrmsController(employer)) {
            return new ErrorResult("Personel onaylanmadı!");
        }else {
            employerDao.save(employer);
            return new SuccessResult("Personel Eklendi.");
        }
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll()
        );
    }

    public boolean checkEmployerController(String info) {
        if (employerDao.getEmployerByEmail(info) == null) {
            return true;
        }
        return false;
    }
}
