package adresar;

import java.util.List;

public interface AddressRepository {

	List<Address> findAll();
	Address findById(int id);

}
