package Model;

public class Appointment {
	private String doctorName;
	private int doctorId;
	private String date;
	private String time;
	private String patientName;
	private int patientId;
	private String Availability;
	private String patientNumber;

	public Appointment() {

	}

	public Appointment(String doctorName, int doctorId, String date, String time, String patientName, int patientId,
			String availability, String patientNumber) {
		super();
		this.doctorName = doctorName;
		this.doctorId = doctorId;
		this.date = date;
		this.time = time;
		this.patientName = patientName;
		this.patientId = patientId;
		Availability = availability;
		this.patientNumber = patientNumber;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getAvailability() {
		return Availability;
	}

	public void setAvailability(String availability) {
		Availability = availability;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	@Override
	public String toString() {
		return "Appointment [doctorName = " + doctorName + " , doctorId = " + doctorId + ",patientName = " + patientName
				+ ",patientId = " + patientId + "" + ", Availability = " + Availability + ",patientNumber = "
				+ patientNumber + "]";
	}
}
