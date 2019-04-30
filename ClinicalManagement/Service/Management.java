package Service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public interface Management {
	public void add() throws JsonParseException, JsonMappingException, IOException;
	public void display() throws JsonParseException, JsonMappingException, IOException;
	public void search() throws JsonParseException, JsonMappingException, IOException;
	public void addDoctor(String doctorName)throws JsonParseException, JsonMappingException, IOException;
	public void deleteDoctor() throws JsonParseException, JsonMappingException, IOException;
	public void addPatient(String patientName) throws JsonParseException, JsonMappingException, IOException;
	public void deletePatient()throws JsonParseException, JsonMappingException, IOException;
	public void editDoctor() throws JsonParseException, JsonMappingException, IOException;
	public void editPatient() throws JsonParseException, JsonMappingException, IOException;
	public void searchDoctorByName() throws JsonParseException, JsonMappingException, IOException;
	public void searchDoctorById() throws JsonParseException, JsonMappingException, IOException;
	public void searchDoctorBySpecialization() throws JsonParseException, JsonMappingException, IOException;
	public void searchDoctorByAvailability() throws JsonParseException, JsonMappingException, IOException;
	public void searchPatientByName() throws JsonParseException, JsonMappingException, IOException;
	public void searchPatientById() throws JsonParseException, JsonMappingException, IOException;
	public void searchPatientByNumber() throws JsonParseException, JsonMappingException, IOException;
	public void displayDoctor() throws JsonParseException, JsonMappingException, IOException;
	public void displayPatient() throws JsonParseException, JsonMappingException, IOException;
	public void appointment() throws JsonParseException, JsonMappingException, IOException;
	public void saveFile();
	public void createFile();
	
}