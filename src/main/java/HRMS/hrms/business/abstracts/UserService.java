package HRMS.hrms.business.abstracts;

import HRMS.hrms.Core.entities.User;
import HRMS.hrms.Core.utilities.results.data.DataResult;

import java.util.List;
import java.util.Optional;

public interface UserService {

    DataResult<List<User>> getAll();
    DataResult<Optional<User>> getUserByEmail(String email);
}
