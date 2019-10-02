package adresar;

import java.util.List;

public interface SexRepository {
	List<Sex> findAll();
	Sex findById(int id);

}
