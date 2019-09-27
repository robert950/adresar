package adresar;

import java.util.List;

public interface DataRepository {
	
	List<Data> findAll();
	Data save(Data data);


}
