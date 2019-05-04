package com.bridgeit.service;
import com.bridgeit.model.Patient;
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

import Json_Programs.utility;


public class PatientImp {
	
	
public Patient addPatient(){
		
		Patient patient =new Patient();
		System.out.println("Enter the name");
		String name=utility.inputStringLong();
		patient.setName(name);
		System.out.println("Enter the Id");
		String id=utility.inputString();
		patient.setId(id);
		System.out.println("Enter the Mobile number");
		String mobNo=utility.inputString();
		patient.setMobilenumber(mobNo);
		return patient;
	}

	public void writePatient(Patient patient,JSONObject jsonobject){
		
			
			try {
				FileWriter writer= new FileWriter("/home/admin1/eclipse-workspace/ObjectOriented_json/clinicmanagementnew/Patient.json");
				HashMap<String,Object> main=new HashMap<String,Object>();
				main.put("Name", patient.getName());
				main.put("MobileNumber", patient.getMobilenumber());
				main.put("Id",patient.getId());
				jsonobject.put(patient.getId(), main);
				writer.write(jsonobject.toJSONString());
				writer.flush();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
	
		}
	public JSONObject displayPatient(){
		
		JSONParser parser = new JSONParser();
		JSONObject jsonobject = null;
		try {
			FileReader read = new FileReader(
					"/home/admin1/eclipse-workspace/ObjectOriented_json/clinicmanagementnew/Patient.json");
			Object object = parser.parse(read);
			jsonobject = (JSONObject) object;
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
  
			return jsonobject;	
			
	}
	public JSONObject readPatient() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonobject = null;
	
			FileReader read = new FileReader(
					"/home/admin1/eclipse-workspace/ObjectOriented_json/clinicmanagementnew/Patient.json");
			Object object = parser.parse(read);
			jsonobject = (JSONObject) object;
		

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
		       System.out.println("MobileNumber:- "+jobj.get("MobileNumber"));

		       System.out.println("-------------------------------------------------------");
		    }
		    
			return jsonobject;	
			
	}
	public static void main(String[] args) throws IOException, ParseException {
		PatientImp patient = new PatientImp();
		Patient p1 =patient.addPatient();
		JSONObject json=patient.readPatient();
		patient.writePatient(p1, json);
}
}
