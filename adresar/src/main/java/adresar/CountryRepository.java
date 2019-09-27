package adresar;

import java.util.List;

public interface CountryRepository {
	
	List<Country> findAll();
	Country findById(int id);

}
