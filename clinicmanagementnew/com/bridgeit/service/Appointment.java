package com.bridgeit.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Json_Programs.utility;

public class Appointment {
	public void takeAppointment(){
		DoctorImp doctors =new DoctorImp();
		PatientImp patients=new PatientImp(); 
		JSONObject allDoctors= doctors.displayDoctors();
		JSONObject allpatient=patients.displayPatient();
		DoctorSearchImp Doctorimp= new DoctorSearchImp();	
		System.out.println("Enter the ID of the doctor");
		Object doctorId=utility.inputString();
		JSONObject doctorObject=Doctorimp.byId(allDoctors,doctorId);
		if(doctorObject==null){
			System.out.println("No such doctor is present with this Id");
			return;
		}
		if(doctorObject.size()==5){
			System.out.println("Todays appointments are full..plz visit tommorrow");
			return;
		}
		System.out.println("Enter your patient ID");
		Object patientId=utility.inputString();
		PatientSearchImp patientImp=new PatientSearchImp();
		JSONObject patientObject=patientImp.byId(allpatient, patientId);
		
		if(patientObject==null){
			
			System.out.println("No such patient Id is present");
			return;
		}
		try {
			writeDoctorAppointments(doctorObject,patientObject);
			writePatientsAppointments(doctorObject,patientObject);
		} catch (Exception e) {
			System.out.println("Appointment is taken already");
			return;
		}
		
	}
	
	/**function takes doctor and patient object to write it into file
	 * @param doctor jsonObject of doctor
	 * @param patient jsonObject of patient
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	public void writeAppointment(JSONObject doctor,JSONObject patient){
		
		
		
	JSONObject patients=new JSONObject();
	JSONArray j1= new JSONArray();
	j1.add(patient);
	HashMap<String,HashMap<String,JSONArray>> doctorHash=new HashMap<String,HashMap<String,JSONArray>>();
	HashMap<String,JSONArray> subHash=new  HashMap<String,JSONArray>();
	subHash.put("Appointments",j1);
	doctorHash.put((String) doctor.get("Id"),subHash);
	patients.putAll(doctorHash);
	try {
		FileWriter write= new FileWriter("//home//bridgeit//Downloads//shiv//JavaPrograms//src//com//bridgeIt//objectOriented//cliniqueManagement//files//Appointment.json");
		write.write(patients.toJSONString());
		write.flush();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}
	
	/**function adds the patient into doctors list 
	 * @param doctor jsonObject
	 * @param patient jsonObject
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "unused", "resource" })
	public void writeDoctorAppointments(JSONObject doctor,JSONObject patient) throws IOException, ParseException{
		
		JSONObject appointments=readDoctorAppointments();
	//	System.out.println(appointments+"ic");
		Object key=appointments.get((String) doctor.get("Id"));
		System.out.println(key);
		HashMap<String,JSONObject> map =new HashMap<String,JSONObject>();
		JSONObject jobj =new JSONObject();
		jobj.put(patient.get("Id"),patient );
		if(key==null){
			HashMap<String,JSONObject> doctorHash=new HashMap<String,JSONObject>();
			doctorHash.put((String) doctor.get("Id"), jobj);
			appointments.putAll(doctorHash);
		}else{
				JSONObject doctorList = (JSONObject)key;
			JSONObject objects=(JSONObject)appointments.get(key);
			doctorList.put(patient.get("Id"),patient);
				
		}
		try {
			FileWriter write= new FileWriter("//home//bridgeit//Downloads//shiv//JavaPrograms//src//com//bridgeIt//objectOriented//cliniqueManagement//files//DoctorAppointment.json");
			write.write(appointments.toJSONString());
			write.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**function adds the doctors in patients appointment list
	 * @param doctor
	 * @param patient
	 */
	@SuppressWarnings({ "unchecked", "unused", "resource" })
	public void writePatientsAppointments(JSONObject doctor,JSONObject patient){
		
		JSONObject appointments=readPatientAppointments();
		//	System.out.println(appointments+"ic");
		Object key=appointments.get((String) patient.get("Id"));
		System.out.println(key);
		HashMap<String,JSONObject> map =new HashMap<String,JSONObject>();
		JSONObject jobj =new JSONObject();
		jobj.put(doctor.get("Id"),doctor );
		if(key==null){
			HashMap<String,JSONObject> patientHash=new HashMap<String,JSONObject>();
			patientHash.put((String) patient.get("Id"), jobj);
			appointments.putAll(patientHash);
		}else{
				JSONObject patientList = (JSONObject)key;
			JSONObject objects=(JSONObject)appointments.get(key);
			patientList.put(doctor.get("Id"),doctor);
				
		}
		try {
			FileWriter write= new FileWriter("/home/admin1/eclipse-workspace/ObjectOriented_json/clinicmanagementnew/PatientAppointment.json");
			write.write(appointments.toJSONString());
			write.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**function reads the doctors appointments of the day
	 * @return jsonObject
	 * @throws ParseException 
	 * @throws IOException 
	 */
	public JSONObject readDoctorAppointments() throws IOException, ParseException{
		
		JSONObject jsonObject=null;
		
			FileReader read = new FileReader("/home/admin1/eclipse-workspace/ObjectOriented_json/clinicmanagementnew/DoctorAppointment.json");
			JSONParser parse= new JSONParser();
			Object object=parse.parse(read);
			jsonObject=(JSONObject)object;
		
		
		return jsonObject;
		
	}
	/**function reads patients appointment with doctors
	 * @return
	 */
	public JSONObject readPatientAppointments(){
		
		JSONObject jsonObject=null;
		try {
			FileReader read = new FileReader("/home/admin1/eclipse-workspace/ObjectOriented_json/clinicmanagementnew/PatientAppointment.json");
			JSONParser parse= new JSONParser();
			Object object=parse.parse(read);
			jsonObject=(JSONObject)object;
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		
		return jsonObject;
		
	}
	public static void main(String[] args) {
		
		Appointment appoint=new Appointment();
		appoint.takeAppointment();
	//	appoint.writeAppointment(doctor, patient);

	}

}
