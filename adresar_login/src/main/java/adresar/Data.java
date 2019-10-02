package adresar;

public class Data {

	int id;
	Contact contact;
	Country country;
	City city;
	Address address;
	Sex sex;	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Data (int id, Contact contact, Country country, City city, Address address, Sex sex) {
		this.contact = contact;
		this.country = country;
		this.city = city;
		this.address = address;
		this.sex = sex;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	
}

