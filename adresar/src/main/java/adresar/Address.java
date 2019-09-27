package adresar;

public class Address {

	private String street, street_NO;
	private int id, cityId;
	
	public Address (String street, String street_NO, int id, int cityId){
		this.street = street;
		this.street_NO = street_NO;
		this.id = id;
		this.cityId = cityId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet_NO() {
		return street_NO;
	}

	public void setStreet_NO(String street_NO) {
		this.street_NO = street_NO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	
}
