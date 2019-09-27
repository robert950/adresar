package adresar;

public class Contact {

	private String firstName, lastName, phone, eMail;
	private int id, sexId, addressId;
	
	public Contact (String fName, String lName, String phone, String eMail, int id, int sexId, int addressId) {
		firstName = fName;
		lastName = lName;
		this.phone = phone;
		this.eMail = eMail;
		this.id = id;
		this.sexId = sexId;
		this.addressId = addressId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSexId() {
		return sexId;
	}

	public void setSexId(int sexId) {
		this.sexId = sexId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	
	
	
}
