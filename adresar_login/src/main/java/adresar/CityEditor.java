package adresar;

import java.beans.PropertyEditorSupport;

public class CityEditor extends PropertyEditorSupport{
	
	private CityRepository cityRepository;
	
	public CityEditor (CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	
	
	@Override
	public void setAsText(String text) {
		City city = null;
		for (City c : cityRepository.findAll()) {
			if (c.getId()==Integer.parseInt(text)) {
				city = c;
				break;
			}
		}
		this.setValue(city);
	}


	@Override
	public String getAsText() {
		City city = (City) this.getValue();
		return (city != null ? Integer.toString(city.getId()) : "");
	}

}
