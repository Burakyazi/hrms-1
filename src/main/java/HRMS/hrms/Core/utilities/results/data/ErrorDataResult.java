package HRMS.hrms.Core.utilities.results.data;

import HRMS.hrms.Core.utilities.results.Result;

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult() {
        super(null,false);

    }

    public ErrorDataResult(String message){
        super(null,false,message);

    }

    public ErrorDataResult(T data, boolean success) {
        super(data, false);
    }

    public ErrorDataResult(T data, boolean success, String message) {
        super(data, false, message);
    }
}
