package HRMS.hrms.business.abstracts;

import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.Core.utilities.results.data.SuccessDataResult;
import HRMS.hrms.entities.City;

import java.util.List;

public interface CityService  {

    SuccessDataResult<List<City>> getAll();
    Result addCity(City city);
    DataResult<City> getCityByName(String name);
}
