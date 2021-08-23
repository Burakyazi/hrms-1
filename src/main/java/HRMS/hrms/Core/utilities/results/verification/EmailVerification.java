package HRMS.hrms.Core.utilities.results.verification;

import HRMS.hrms.Core.entities.User;


public interface EmailVerification {

    boolean checkUserEmail(User user);
}
