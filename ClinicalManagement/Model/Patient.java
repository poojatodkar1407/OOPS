package Model;

public class Patient {
	private String name;
	private String id;
	private String phoneNumber;
	private String Age;

	public Patient() {
		super();
	}

	public Patient(String name, String id, String phoneNumber, String age) {
		super();
		this.name = name;
		this.id = id;
		this.phoneNumber = phoneNumber;
		Age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}
	
	@Override
	public String toString() 
	{
		return "Patient [name=" + name + ", id=" + id + ",PhoneNumber=" +phoneNumber+ "]";
}

}
