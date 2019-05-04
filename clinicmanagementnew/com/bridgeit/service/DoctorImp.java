package com.bridgeit.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgeit.model.Doctor;

import Json_Programs.utility;



public class DoctorImp {
	public static Doctor addDoctors(){
		
		Doctor doctor=new Doctor();
		System.out.println("Enter the name of Doctor");
		String name=utility.inputStringLong();
		doctor.setName(name);
		System.out.println("Enter the Id of Doctor");
		String id=utility.inputString();
		doctor.setId(id);
		System.out.println("Enter the Specialization of Doctor");
		String specialization=utility.inputStringLong();
		doctor.setSpecialization(specialization);
		System.out.println("Enter the Availability");
		String availability=utility.inputString();
		doctor.setAvailability(availability);
		return doctor;
	}
	
	public void writeDoctor(Doctor doctor,JSONObject jsonobject){
	
		
		try {
			FileWriter writer= new FileWriter("/home/admin1/eclipse-workspace/ObjectOriented_json/clinicmanagementnew/Doctors.json");
			HashMap<String,Object> main=new HashMap<String,Object>();
			main.put("Name", doctor.getName());
			main.put("Availability", doctor.getAvailability());
			main.put("Specialization", doctor.getSpecialization());
			main.put("Id", doctor.getId());
			jsonobject.put(doctor.getId(), main);
			
			writer.write(jsonobject.toJSONString());
			writer.flush();
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	}
	
	public JSONObject readOneAppointment(Object id) throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonobject = null;
		DoctorSearchImp docSearch= new DoctorSearchImp();
		JSONObject patients=null;
		FileReader read;

			read = new FileReader(
					"/home/admin1/eclipse-workspace/ObjectOriented_json/clinicmanagementnew/DoctorAppointment.json");
	
			Object object = parser.parse(read);
			jsonobject = (JSONObject) object;
			patients=	(JSONObject) jsonobject.get(id);
			
	
		return patients;
		}
	
	
	
	public JSONObject readDoctorAppointments(){
		
		JSONParser parser = new JSONParser();
		JSONObject jsonobject = null;
		DoctorSearchImp docSearch= new DoctorSearchImp();
		try {
			FileReader read = new FileReader(
					"/home/admin1/eclipse-workspace/ObjectOriented_json/clinicmanagementnew/DoctorAppointment.json");
			Object object = parser.parse(read);
			jsonobject = (JSONObject) object;
		//	System.out.println(jsonobject);
			  Set set=jsonobject.entrySet();//Converting to Set so that we can traverse  
			    Iterator itr=set.iterator();  
			    while(itr.hasNext()){  
		    //Converting to Map.Entry so that we can get key and value separately  
			        Map.Entry entry=(Map.Entry)itr.next();  
			  //      System.out.println(entry.getKey()+"-"+entry.getValue()); 
			//        System.out.println("-----------------------------------------------------");
			        System.out.println("Appointments for Doctor id:- "+entry.getKey());
			       JSONObject jobject= (JSONObject) entry.getValue();
		//	       System.out.println(jobject);
			//   	System.out.println(jsonobject);
				
				  Set set1=jobject.entrySet();//Converting to Set so that we can traverse  
				    Iterator itr1=set1.iterator();  
				    while(itr1.hasNext()){  
			    //Converting to Map.Entry so that we can get key and value separately  
				        Map.Entry entry1=(Map.Entry)itr1.next();    
				       JSONObject jobj= (JSONObject) entry1.getValue();
				  //     System.out.println(jobj);
				 	  System.out.println("Patient Id:-"+jobj.get("Id"));
				       System.out.println("Patient Name:- "+jobj.get("Name"));
				       System.out.println("MobileNumber:- "+jobj.get("MobileNumber"));
				      System.out.println("--------------------------------------------------------------------");
			    }
			    }
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
		}
	
	public JSONObject displayDoctors(){
		
		JSONParser parser = new JSONParser();
		JSONObject jsonobject = null;
		try {
			FileReader read = new FileReader(
					"/home/admin1/eclipse-workspace/ObjectOriented_json/clinicmanagementnew/Doctors.json");
			Object object = parser.parse(read);
			jsonobject = (JSONObject) object;
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		System.out.println(jsonobject);
		return jsonobject;
		
	}
	
	
	public JSONObject readDoctor(){
		
		JSONParser parser = new JSONParser();
		JSONObject jsonobject = null;
		try {
			FileReader read = new FileReader(
					"/home/admin1/eclipse-workspace/ObjectOriented_json/clinicmanagementnew/Doctors.json");
			Object object = parser.parse(read);
			jsonobject = (JSONObject) object;
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		System.out.println(jsonobject);
		  Set set=jsonobject.entrySet();//Converting to Set so that we can traverse  
		    Iterator itr=set.iterator();  
		    while(itr.hasNext()){  
	    //Converting to Map.Entry so that we can get key and value separately  
		        Map.Entry entry=(Map.Entry)itr.next();  
		  //      System.out.println(entry.getKey()+"-"+entry.getValue()); 
		        System.out.println("-----------------------------------------------------");
		        
		       JSONObject jobj= (JSONObject) entry.getValue();
		       System.out.println("Id:-"+jobj.get("Id"));
		       System.out.println("Name:- "+jobj.get("Name"));
		       System.out.println("Specialization:- "+jobj.get("Specialization"));
		       System.out.println("Availability:- "+jobj.get("Availability"));
		       
		       System.out.println("-------------------------------------------------------");
		  /*      Set set1= jobj.entrySet();
		        Iterator itr1=set1.iterator(); 
		        while(itr1.hasNext()){
		            Map.Entry entry1=(Map.Entry)itr1.next();  
		           System.out.println(entry1.getKey()+":-"+entry1.getValue()); 
		        }*/
	}
			return jsonobject;
		
	}
	
	public static void main(String[] args) {
		DoctorImp doc =new DoctorImp();
		
	//	Doctor doc1= doc.addDoctors();
		JSONObject jsonobject= doc.readDoctor();
	
		DoctorSearchImp imp= new DoctorSearchImp();
		
		JSONObject jsonobject1=imp.byAvailability(jsonobject,"AM");
	//	System.out.println(jsonobject1);
}
}
