package adresar;

import java.util.List;

public interface ContactRepository {
	
	List<Contact> findAll();
	//Contact saveContact(Contact contact);

	Contact findById(int id);
}
