package com.bridgeit.controller;

import com.bridgeit.service.DoctorImp;

import Json_Programs.utility;

public class ControllerMain {
	public static void main(String[] args) {
		clinicManagementimp imp = new clinicManagementimp();
		DoctorImp doctorImp = new DoctorImp();
		System.out.println("Press the following to perform");
		System.out.println(
				"1.Add Doctor \n2.View Doctors\n3.View Patients\n4.Appointments\n5.Popular Doctor\n6.Popular specilization\n7.Exit");
		int choice = utility.inputInt();
		int num = 9;
		while (num == 9) {

			switch (choice) {
			case 1: {
				imp.addDoctor();
				System.out.println(
						"1.Add Doctor \n2.View Doctors\n3.View Patients\n4.Appointments\n5.Popular specilization\n6.Popular Doctor\n7.Exit");
				choice = utility.inputInt();
				break;
			}
			case 2: {
				imp.viewDoctors();
				System.out.println(
						"1.Add Doctor \n2.View Doctors\n3.View Patients\n4.Appointments\n5.Popular specilization\n6.Popular Doctor\n7.Exit");
				choice = utility.inputInt();
				break;
			}
			case 3: {
				imp.viewPatients();
				System.out.println(
						"1.Add Doctor \n2.View Doctors\n3.View Patients\n4.Appointments\n5.Popular specilization\n6.Popular Doctor\n7.Exit");
				choice = utility.inputInt();
				break;
			}
			case 4: {
				// imp.viewDoctors();
				doctorImp.readDoctorAppointments();
				System.out.println(
						"1.Add Doctor \n2.View Doctors\n3.View Patients\n4.Appointments\n5.Popular specilization\n6.Popular Doctor\n7.Exit");
				choice = utility.inputInt();
				break;

			}
			case 5: {

				imp.popularDoctor();
				System.out.println(
						"1.Add Doctor \n2.View Doctors\n3.View Patients\n4. Appointments\n5.Popular specilization\n6.Popular Doctor\n7.Exit");
				choice = utility.inputInt();
				break;
			}
			case 6: {

				imp.popularSpecialization();
				System.out.println(
						"1.Add Doctor \n2.View Doctors\n3.View Patients\n4. Appointments\n5.Popular specilization\n6.Popular Doctor\n7.Exit");
				choice = utility.inputInt();
				break;
			}
			case 7: {
				System.exit(0);
			}
			default: {
				System.out.println("Entered wrong option");
				break;
			}

			}

		}

	}
}
