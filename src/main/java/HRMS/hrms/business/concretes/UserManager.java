package HRMS.hrms.business.concretes;

import HRMS.hrms.Core.dataAccess.UserDao;
import HRMS.hrms.Core.entities.User;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.Core.utilities.results.data.SuccessDataResult;
import HRMS.hrms.business.abstracts.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserManager implements UserService {

    private String dataCompleted = "data_Completed";

    private final UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll());
    }

    @Override
    public DataResult<Optional<User>> getUserByEmail(String email) {
        return new SuccessDataResult<Optional<User>>(this.userDao.findByEmail(email));
    }

}
