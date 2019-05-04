package com.bridgeit.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Popularity {
	DoctorImp doctors =new DoctorImp();
	DoctorSearchImp Doctorimp= new DoctorSearchImp();	
	/**function checks the popular specialization
	 * @return jsonObject
	 */
	@SuppressWarnings("rawtypes")
	public JSONObject popularSpecilization(){
		
		JSONParser parser = new JSONParser();
		JSONObject jsonobject = null;
		try {
			FileReader read = new FileReader(
					"/home/admin1/eclipse-workspace/ObjectOriented_json/clinicmanagementnew/DoctorAppointment.json");
			Object object = parser.parse(read);
			jsonobject = (JSONObject) object;
			
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		Set set=jsonobject.entrySet();
		Iterator itr=set.iterator();
		while(itr.hasNext()){
		
			Map.Entry entry=(Map.Entry)itr.next();
			JSONObject jsonObj=(JSONObject)entry.getValue();
			if(jsonObj.size()==3){
				jsonObj.get("Name");
			//	System.out.println("One of the popular specialization in the clinique is "+entry.getKey());
				JSONObject allDoctors= doctors.displayDoctors();
				JSONObject doctorObject=Doctorimp.byId(allDoctors,entry.getKey());
				System.out.println("One of the popular specialization in the clinique is "+doctorObject);
			}
		}
		
		return jsonobject;
		
	}
	
	/**function checks the popular doctor in the clinic
	 * @return JsonObject
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@SuppressWarnings("rawtypes")
	public JSONObject popularDoctor() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonobject = null;

			FileReader read = new FileReader(
					"/home/admin1/eclipse-workspace/ObjectOriented_json/clinicmanagementnew/DoctorAppointment.json");
			Object object = parser.parse(read);
			jsonobject = (JSONObject) object;
			
		
		Set set=jsonobject.entrySet();
		Iterator itr=set.iterator();
		while(itr.hasNext()){
		
			Map.Entry entry=(Map.Entry)itr.next();
			JSONObject jsonObj=(JSONObject)entry.getValue();
			if(jsonObj.size()>=3){
				System.out.println("One of the popular DoctorId in the clinique is "+entry.getKey());
			}
		}
		return jsonobject;

		}
	

	public static void main(String[] args) {
		
		
		Popularity popular=new Popularity();
		popular.popularSpecilization();
		
}
}
