package Model;

public class Doctor {
	private String Name;
	private String Id;
	private String Availability;
	private String Specialization;

	public Doctor() {
		super();
	}

	public Doctor(String name, String id, String availability, String specialization) {
		super();
		Name = name;
		Id = id;
		Availability = availability;
		Specialization = specialization;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getAvailability() {
		return Availability;
	}

	public void setAvailability(String availability) {
		Availability = availability;
	}

	public String getSpecialization() {
		return Specialization;
	}

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

	@Override
	public String toString() {
		return "Doctor [name = " + Name + ", id = " + Id + ",specialization = " + Specialization + " , availabiltity = "
				+ Availability + "]";
	}

}