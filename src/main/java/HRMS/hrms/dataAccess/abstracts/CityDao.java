package HRMS.hrms.dataAccess.abstracts;

import HRMS.hrms.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {

    City getByCityName(String cityName);

    boolean existsCityByCityName(String cityName);

}
