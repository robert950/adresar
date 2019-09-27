package adresar;

import java.beans.PropertyEditorSupport;

public class CountryEditor extends PropertyEditorSupport{
	
	
	private CountryRepository countryRepository;
	
	public CountryEditor (CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	
	@Override
	public void setAsText(String text) {
		Country country = null;
		for (Country c : countryRepository.findAll()) {
			if (c.getId()==Integer.parseInt(text)) {
				country = c;
				break;
			}
		}
		this.setValue(country);
	}


	@Override
	public String getAsText() {
		Country country = (Country) this.getValue();
		return (country != null ? Integer.toString(country.getId()) : "");
	}

}
