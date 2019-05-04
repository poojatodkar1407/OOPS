package com.bridgeit.model;

public class Appointment {
	private String doctorName;
	private String doctorId;
	private String PatientName;
	private String date;
	private String time;
	private String patientId;
	private String availability;
	private String patientnumber;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getPatientName() {
		return PatientName;
	}

	public void setPatientName(String patientName) {
		PatientName = patientName;
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

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getPatientnumber() {
		return patientnumber;
	}

	public void setPatientnumber(String patientnumber) {
		this.patientnumber = patientnumber;
	}

	@Override
	public String toString() {
		return "Appointment [doctorName=" + doctorName + ", doctorId=" + doctorId + ", PatientName=" + PatientName
				+ ", date=" + date + ", time=" + time + ", patientId=" + patientId + ", availability=" + availability
				+ ", patientnumber=" + patientnumber + "]";
	}

}
