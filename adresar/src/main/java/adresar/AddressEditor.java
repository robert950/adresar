package adresar;

import java.beans.PropertyEditorSupport;

public class AddressEditor extends PropertyEditorSupport{
	
	
	private AddressRepository AddressRepository;
	
	public AddressEditor (AddressRepository AddressRepository) {
		this.AddressRepository = AddressRepository;
	}
	
	
	@Override
	public void setAsText(String text) {
		Address Address = null;
		for (Address a : AddressRepository.findAll()) {
			if (a.getId()==Integer.parseInt(text)) {
				Address = a;
				break;
			}
		}
		this.setValue(Address);
	}


	@Override
	public String getAsText() {
		Address Address = (Address) this.getValue();
		return (Address != null ? Integer.toString(Address.getId()) : "");
	}

}
