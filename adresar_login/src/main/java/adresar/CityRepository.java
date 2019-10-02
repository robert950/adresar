package adresar;

import java.util.List;

public interface CityRepository {
	
	List<City> findAll();
	City findById(int id);
}
