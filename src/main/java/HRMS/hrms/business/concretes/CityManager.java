package HRMS.hrms.business.concretes;

import HRMS.hrms.Core.utilities.results.ErrorResult;
import HRMS.hrms.Core.utilities.results.Result;
import HRMS.hrms.Core.utilities.results.SuccessResult;
import HRMS.hrms.Core.utilities.results.data.DataResult;
import HRMS.hrms.Core.utilities.results.data.ErrorDataResult;
import HRMS.hrms.Core.utilities.results.data.SuccessDataResult;
import HRMS.hrms.business.abstracts.CityService;
import HRMS.hrms.dataAccess.abstracts.CityDao;
import HRMS.hrms.entities.City;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CityManager implements CityService {


    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }


    @Override
    public SuccessDataResult<List<City>> getAll() {
        return new SuccessDataResult<>(cityDao.findAll());
    }

    @Override
    public Result addCity(City city) {
        if (cityDao.existsCityByCityName(city.getCityName()))
            return new ErrorResult("Sehir sistemde mevcut lütfen başka şehir ismi oluşturun...");
        cityDao.save(city);
        return new SuccessResult(city.getCityName() + "Eklendi");
    }

    @Override
    public DataResult<City> getCityByName(String name) {
        if (!cityDao.existsCityByCityName(name))
            return new  ErrorDataResult<>(name + "Sistemde mevcut değil");
        else return new SuccessDataResult<>(cityDao.getByCityName(name));
    }
}
