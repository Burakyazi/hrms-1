package HRMS.hrms.Core.utilities.results.data;

import HRMS.hrms.Core.entities.User;

import java.util.List;

public class SuccessDataResult<T> extends DataResult<T>{

    public SuccessDataResult(T data) {
        super(data, true);
    }

    public SuccessDataResult(T data, boolean success, String message) {
        super(data, true, message);
    }
    public SuccessDataResult(DataResult<List<User>> all, String dataCompleted){
        super(null,true);
    }

    public SuccessDataResult(String message){
        super(null,true,message);
    }

}
