package adresar;

import java.beans.PropertyEditorSupport;

public class ContactEditor extends PropertyEditorSupport{
	
	private ContactRepository contactRepository;
	
	public ContactEditor (ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	
	@Override
	public void setAsText(String text) {
		Contact contact = null;
		for (Contact c : contactRepository.findAll()) {
			if (c.getId()==Integer.parseInt(text)) {
				contact = c;
				break;
			}
		}
		this.setValue(contact);
	}


	@Override
	public String getAsText() {
		Contact contact = (Contact) this.getValue();
		return (contact != null ? Integer.toString(contact.getId()) : "");
	}

}
