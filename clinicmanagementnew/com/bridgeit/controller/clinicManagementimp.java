package com.bridgeit.controller;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.bridgeit.model.Doctor;
import com.bridgeit.model.Patient;
import com.bridgeit.service.Appointment;
import com.bridgeit.service.DoctorImp;
import com.bridgeit.service.DoctorSearchImp;
import com.bridgeit.service.PatientImp;
import com.bridgeit.service.PatientSearchImp;
import com.bridgeit.service.Popularity;

import Json_Programs.utility;

public class clinicManagementimp implements clinicManagement {
	DoctorImp doctorImp =new DoctorImp();
	PatientImp patientImp= new PatientImp();
	Appointment appointment= new Appointment();
	DoctorSearchImp doctorSearch= new DoctorSearchImp();
	PatientSearchImp patientSearch= new PatientSearchImp();
	Popularity popular=new Popularity();
	/* (non-Javadoc)
	 * @see com.bridgeIt.objectOriented.cliniqueManagement.controller.CliniqueManagement#addDoctor()
	 */
	@Override
	public void addDoctor() {
		
		Doctor doctor=DoctorImp.addDoctors();
		System.out.println(doctor);
		JSONObject doctors=doctorImp.readDoctor();
		System.out.println(doctors);
		doctorImp.writeDoctor(doctor,doctors);
		
	}

	@Override
	public void addPatient()  {
		Patient patient=patientImp.addPatient();
		System.out.println(patient);
		try
		{
		JSONObject patients=patientImp.readPatient();
		System.out.println();
		patientImp.writePatient(patient, patients);
		}
		catch(Exception e)
		{
			System.out.println("e");
		}
	}

	@Override
	public void viewDoctors() {
	
		JSONObject doctors=doctorImp.readDoctor();
		System.out.println("1.Take Appointment  2.Search Doctor  3.View all appointments 4.Back");
		int choice = utility.inputInt();
		int loop=7;
		int loop1=88;
		while(loop==7){
			try
			{
			switch(choice){
			case 1:{
				appointment.takeAppointment();
				choice=4;
				loop=6;
				break;
			}
			case 2:{

				
				while(loop1==88){
				System.out.println("Search by:- ");
				System.out.println("1.ByName 2.ById 3.BySpecialization 4.ByAvailabilty 5.back");
				int choose=utility.inputInt();
			
				
			
				switch(choose){
			
				case 1:{
					System.out.println("Enter the name of the doctor");
					Object name=utility.inputStringLong();
					JSONObject doctor=doctorSearch.byName(doctors, name);
					doctorImp.readOneAppointment(doctor.get("Id"));
					System.out.println("1.Take Appointment  2.Search Doctor 3.Back");
					choose = utility.inputInt();
					
					if(choose==3){
					loop1=9;
					};
					break;
				}
				case 2:{
					
					System.out.println("Enter the Id of the doctor");
					Object id=utility.inputString();
					JSONObject doctor=doctorSearch.byId(doctors, id);
					System.out.println(doctor);
					JSONObject appointments=doctorImp.readOneAppointment(doctor.get("Id"));
					System.out.println(appointments);
					System.out.println("1.Take Appointment  2.Search Doctor 3.Back");
					choose = utility.inputInt();
					
					if(choose==3){
					loop1=9;
					};
					break;
				}
				
				case 3:{
					
					System.out.println("Enter the Specialization of the doctor");
					Object specialization=utility.inputStringLong();
					JSONObject doctor=doctorSearch.bySpecilization(doctors, specialization);
					System.out.println("1.Take Appointment  2.Search Doctor 3.Back");
					choose = utility.inputInt();
										
					if(choose==3){
					loop1=9;
					};
										
					break;
				}
				case 4:{
					
					System.out.println("Enter the Availabilty of the doctor");
					Object availabilty=utility.inputString();
					JSONObject doctor=doctorSearch.byAvailability(doctors, availabilty);
					/*JSONObject appointments=doctorImp.readOneAppointment(doctor.get("Id"));
					System.out.println(appointments);*/
					System.out.println("1.Take Appointment  2.Search Doctor 3.Back");
					choose = utility.inputInt();
					
					if(choose==3){
						loop1=9;
					};
					
					break;
				}
				default:{
					loop1=9;
					break;
				}
				
				}
				
				}	
				
				
				
				System.out.println("1.Take Appointment  2.Search Doctor  3.View all appointments 4.Back");
			    choice = utility.inputInt();
				break;
				
			}
			case 3:{
				doctorImp.readDoctorAppointments();
			}
			case 4:{
				
				loop=5;
				break;
			}
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
			
			

	}

	@Override
	public void viewPatients(){
		try {
	JSONObject patient=patientImp.readPatient();
	System.out.println("1.Add patients  2.Search Patient 3.Back");
	int option= utility.inputInt();
	int num=0;
	while(num==0){
	
			
		
		switch(option){
		
		case 1:{
			
			addPatient();
			System.out.println("1.Add patients  2.Search Patient 3.Back");
			option= utility.inputInt();
			break;
		}
		case 2:{
			System.out.println("Search patients by:-");
			System.out.println("1.ID  2.Name  3.Mobile Number");
			int choice = utility.inputInt();
			switch(choice){
				
			case 1:{
				
				System.out.println("Enter the id of the patient");
				Object id =utility.inputString();
				JSONObject searchedPatient=patientSearch.byId(patient, id);
				System.out.println(searchedPatient);
				break;
			}
				
			case 2:{
				
				System.out.println("Enter the name of the patient");
				Object name=utility.inputStringLong();
				JSONObject searchedPatient=patientSearch.byName(patient, name);
				System.out.println(searchedPatient);
				break;
			}
			case 3:{
				
				System.out.println("Enter the Mobile number of the patient");
				Object mobNo=utility.inputString();
				JSONObject searchedPatient=patientSearch.byMobNo(patient, mobNo);
				System.out.println(searchedPatient);
				break;
			}
			}	
		}
		case 3:{
			
			num=1;
			break;
			
		}
		}
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}

	@Override
	public void popularSpecialization() {
		
		popular.popularSpecilization();
		
	}

	@Override
	public void popularDoctor() {

		try {
			popular.popularDoctor();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
