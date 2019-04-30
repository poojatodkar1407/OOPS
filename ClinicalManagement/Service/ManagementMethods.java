package Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import Json_Programs.Utility;
import Model.Appointment;
import Model.Doctor;
import Model.Patient;

public class ManagementMethods implements Management {

	int personListIndex = 0;
	ObjectMapper objectmapper = new ObjectMapper();
	List<String> fileList = new ArrayList<>();
	List<Patient> patientList = new ArrayList<>();
	List<Doctor> doctorList = new ArrayList<>();
	List<Appointment> appointmentList = new ArrayList<>();
	Utility utility = new Utility();

	@Override
	public void addDoctor(String fileName) throws JsonParseException, JsonMappingException, IOException {
		// Utility utility = new Utility();
		File doctorObject = new File(fileName + ".json");

		if (doctorObject.length() == 0) {
			Doctor doctor = new Doctor();
			System.out.println("Enter the name");
			doctor.setName(utility.singleStringInput());

			System.out.println("Enter the id");
			doctor.setId(utility.singleStringInput());

			System.out.println("Enter the specialization");
			doctor.setSpecialization(utility.singleStringInput());

			System.out.println("Enter the availability");
			doctor.setAvailability(utility.singleStringInput());

			System.out.println(doctor);
			doctorList.add(doctor);
		} else {
			List<Doctor> doctorList = objectmapper.readValue(doctorObject, new TypeReference<List<Doctor>>() {
			});
			doctorList.addAll(doctorList);
			Doctor doctor = new Doctor();

			System.out.println("Enter the name");
			doctor.setName(utility.singleStringInput());

			System.out.println("Enter the id");
			doctor.setId(utility.singleStringInput());

			System.out.println("Enter the specialization");
			doctor.setSpecialization(utility.singleStringInput());

			System.out.println("Enter the availability");
			doctor.setAvailability(utility.singleStringInput());

			doctorList.add(doctor);

		}
	}

	@Override
	public void addPatient(String fileName) throws JsonParseException, JsonMappingException, IOException {

		File patientObject = new File(fileName + ".json");
		Patient patient = new Patient();
		if (patientObject.length() == 0) {

			System.out.println("Enter the name");
			patient.setName(utility.singleStringInput());

			System.out.println("Enter the id");
			patient.setId(utility.singleStringInput());

			System.out.println("Enter the phone number");
			patient.setPhoneNumber(utility.singleStringInput());

			System.out.println("Enter the age");
			patient.setAge(utility.singleStringInput());

			System.out.println(patient);
			patientList.add(patient);
		} else {
			List<Doctor> doctorList = objectmapper.readValue(patientObject, new TypeReference<List<Patient>>() {
			});
			patientList.addAll(patientList);
			System.out.println("Enter the name");
			patient.setName(utility.singleStringInput());

			System.out.println("Enter the id");
			patient.setId(utility.singleStringInput());

			System.out.println("Enter the phone number");
			patient.setPhoneNumber(utility.singleStringInput());

			System.out.println("Enter the age");
			patient.setAge(utility.singleStringInput());

			System.out.println(patient);
			patientList.add(patient);

		}
	}

	@Override
	public void deleteDoctor() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Enter the name of person u want to delete");
		String filename = utility.singleStringInput();
		File doctorObject = new File(filename + ".json");

		if (doctorObject.length() == 0) {
			System.out.println("Empty");
		} else {
			doctorList.clear();
			doctorList = objectmapper.readValue(doctorObject, new TypeReference<List<Doctor>>() {
			});
			System.out.println("Enter the name of doctor to be deleted");
			String name = utility.singleStringInput();
			for (int i = 0; i < doctorList.size(); i++) {
				if (name.equals(doctorList.get(i).getName())) {
					doctorList.remove(i);
					break;
				}
			}
			utility.writeObjectToJson(doctorList, filename + ".json");
		}
	}

	@Override
	public void deletePatient() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Enter the name of person u want to delete");
		String filename = utility.singleStringInput();
		File patientObject = new File(filename + ".json");

		if (patientObject.length() == 0) {
			System.out.println("Empty");
		} else {
			patientList.clear();
			patientList = objectmapper.readValue(patientObject, new TypeReference<List<Doctor>>() {
			});
			System.out.println("Enter the name of doctor to be deleted");
			String name = utility.singleStringInput();
			for (int i = 0; i < patientList.size(); i++) {
				if (name.equals(patientList.get(i).getName())) {
					patientList.remove(i);
					break;
				}
			}
			utility.writeObjectToJson(patientList, filename + ".json");
		}
	}

	@Override
	public void displayDoctor() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Enter the filename from which u want to be display");
		String filename = utility.singleStringInput();
		File doctorObject = new File(filename + ".json");

		if (doctorObject.length() == 0) {
			System.out.println("No entry found");
		} else {
			doctorList.clear();

			List doctorList = objectmapper.readValue(doctorObject, new TypeReference<List<Doctor>>() {
			});

			doctorList.clear();

			for (int i = 0; i < doctorList.size(); i++) {
				System.out.println(doctorList.get(i));
			}
		}

	}

	@Override
	public void displayPatient() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Enter the filename from which u want to be display");
		String filename = utility.singleStringInput();
		File patientObject = new File(filename + ".json");

		if (patientObject.length() == 0) {
			System.out.println("No entry found");
		} else {
			patientList.clear();

			List patientList = objectmapper.readValue(patientObject, new TypeReference<List<Patient>>() {
			});

			patientList.clear();

			for (int i = 0; i < patientList.size(); i++) {
				System.out.println(patientList.get(i));
			}
		}
	}

	@Override
	public void display() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("1. Display doctor");
		System.out.println("2. Display Patient");

		int ch = utility.IntegerInput();

		switch (ch) {
		case 1:
			System.out.println("Displaying doctor");
			displayDoctor();
			break;

		case 2:
			System.out.println("Displaying patient");
			displayPatient();
			break;

		default:
			System.out.println("Invalid");
			return;
		}
	}

	@Override
	public void add() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("1. Add doctor");
		System.out.println("2. Add Patient");
		System.out.println("3. Delete doctor");
		System.out.println("4. Delete patient");
		System.out.println("5. Edit doctor");
		System.out.println("6. Edit patient");
		System.out.println("7. Back to the menu");
		System.out.println("Enter the choice");
		int ch = utility.IntegerInput();

		switch (ch) {
		case 1:
			System.out.println("Enter the filename");
			String doctorName = utility.singleStringInput();
			addDoctor(doctorName);
			break;

		case 2:
			System.out.println("Enter the patient name");
			String patientName = utility.singleStringInput();
			addPatient(patientName);
			break;

		case 3:
			deleteDoctor();
			System.out.println("doctor deleted");
			break;

		case 4:
			deletePatient();
			System.out.println("patient deleted");
			break;

		case 5:
			editDoctor();
			System.out.println("Doctor is edited");
			break;

		case 6:
			editPatient();
			System.out.println("patient edited");
			break;

		case 7:
			return;

		}
	}

	@Override
	public void search() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("1. searching for doctor");
		System.out.println("2. searching for patient");

		int ch = utility.IntegerInput();
		switch (ch) {
		case 1:
			System.out.println("For doctor");
			System.out.println("1. DoctorID");
			System.out.println("1. DoctorName");
			System.out.println("1. DoctorAvailability");
			System.out.println("1. DoctorSpecialization");

			int ch1 = utility.IntegerInput();
			switch (ch) {
			case 1:
				System.out.println("searchin the doctor by id");
				searchDoctorById();
				break;

			case 2:
				System.out.println("searching the patient by name");
				searchDoctorByName();
				break;

			case 3:
				System.out.println("searching doctor by availability");
				searchDoctorByAvailability();
				break;

			case 4:
				System.out.println("searching doctor by specialization");
				searchDoctorBySpecialization();
				break;

			}
			break;

		case 2:
			System.out.println("For patient");
			System.out.println("1. patientId");
			System.out.println("1. patientName");
			System.out.println("1. patientPhoneNumber");

			int ch2 = utility.IntegerInput();
			switch (ch2) {
			case 1:
				System.out.println("searching by id");
				searchPatientById();
				break;

			case 2:
				System.out.println("searching by name");
				searchPatientByName();
				break;

			case 3:
				System.out.println("searching by phone number");
				searchPatientByNumber();
				break;

			case 4:
				System.out.println("invalid");

			}
			break;

		default:
			System.out.println("Invalid");
		}
	}

	@Override
	public void searchDoctorByName() throws JsonParseException, JsonMappingException, IOException {
		int cnt = 0, i = 0;

		System.out.println("Enter the name of doctor for searching");
		String name = utility.singleStringInput();
		File doctorObject = new File(name + ".json");
		if (doctorObject.length() == 0) {
			System.out.println("File is empty");
		} else {
			System.out.println("Enter the name of doctor for searching");
			String name1 = utility.singleStringInput();
			doctorList.clear();

			List doctorList1 = objectmapper.readValue(doctorObject, new TypeReference<List<Doctor>>() {
			});
			doctorList.addAll(doctorList1);

			for (i = 0; i < doctorList.size(); i++) {
				if (name1.equals(doctorList.get(i).getName())) {
					cnt++;
					break;
				}
			}
			if (cnt > 0) {
				System.out.println("doctor found");
				System.out.println(doctorList.get(i));
			} else {
				System.out.println("not found");
			}
		}
	}

	@Override
	public void searchDoctorById() throws JsonParseException, JsonMappingException, IOException {
		int cnt = 0, i = 0;

		System.out.println("Enter the name of doctor for searching");
		String name = utility.singleStringInput();
		File doctorObject = new File(name + ".json");
		if (doctorObject.length() == 0) {
			System.out.println("File is empty");
		} else {
			System.out.println("Enter the name of doctor for searching");
			String name1 = utility.singleStringInput();
			doctorList.clear();

			List doctorList1 = objectmapper.readValue(doctorObject, new TypeReference<List<Doctor>>() {
			});
			doctorList.addAll(doctorList1);

			for (i = 0; i < doctorList.size(); i++) {
				if (name1.equals(doctorList.get(i).getId())) {
					cnt++;
					break;
				}
			}
			if (cnt > 0) {
				System.out.println("doctor found");
				System.out.println(doctorList.get(i));
			} else {
				System.out.println("not found");
			}
		}
	}

	@Override
	public void searchDoctorBySpecialization() throws JsonParseException, JsonMappingException, IOException {
		int cnt = 0, i = 0;

		System.out.println("Enter the name of doctor for searching");
		String name = utility.singleStringInput();
		File doctorObject = new File(name + ".json");
		if (doctorObject.length() == 0) {
			System.out.println("File is empty");
		} else {
			System.out.println("Enter the name of doctor for searching");
			String name1 = utility.singleStringInput();
			doctorList.clear();

			List doctorList1 = objectmapper.readValue(doctorObject, new TypeReference<List<Doctor>>() {
			});
			doctorList.addAll(doctorList1);

			for (i = 0; i < doctorList.size(); i++) {
				if (name1.equals(doctorList.get(i).getSpecialization())) {
					cnt++;
					break;
				}
			}
			if (cnt > 0) {
				System.out.println("doctor found");
				System.out.println(doctorList.get(i));
			} else {
				System.out.println("not found");
			}
		}
	}

	@Override
	public void searchDoctorByAvailability() throws JsonParseException, JsonMappingException, IOException {
		int cnt = 0, i = 0;

		System.out.println("Enter the name of doctor for searching");
		String name = utility.singleStringInput();
		File doctorObject = new File(name + ".json");
		if (doctorObject.length() == 0) {
			System.out.println("File is empty");
		} else {
			System.out.println("Enter the name of doctor for searching");
			String name1 = utility.singleStringInput();
			doctorList.clear();

			List doctorList1 = objectmapper.readValue(doctorObject, new TypeReference<List<Doctor>>() {
			});
			doctorList.addAll(doctorList1);

			for (i = 0; i < doctorList.size(); i++) {
				if (name1.equals(doctorList.get(i).getAvailability())) {
					cnt++;
					break;
				}
			}
			if (cnt > 0) {
				System.out.println("doctor found");
				System.out.println(doctorList.get(i));
			} else {
				System.out.println("not found");
			}
		}
	}

	@Override
	public void searchPatientById() throws JsonParseException, JsonMappingException, IOException {
		int cnt = 0, i = 0;

		System.out.println("Enter the id of patient for searching");
		String name = utility.singleStringInput();
		File patientObject = new File(name + ".json");
		if (patientObject.length() == 0) {
			System.out.println("File is empty");
		} else {
			System.out.println("Enter the id of patient for searching");
			String name1 = utility.singleStringInput();
			patientList.clear();

			List patientList1 = objectmapper.readValue(patientObject, new TypeReference<List<Doctor>>() {
			});
			patientList.addAll(patientList1);

			for (i = 0; i < patientList.size(); i++) {
				if (name1.equals(patientList.get(i).getId())) {
					cnt++;
					break;
				}
			}
			if (cnt > 0) {
				System.out.println("patient found");
				System.out.println(patientList.get(i));
			} else {
				System.out.println("not found");
			}
		}
	}

	@Override
	public void searchPatientByName() throws JsonParseException, JsonMappingException, IOException {
		int cnt = 0, i = 0;

		System.out.println("Enter the name of patient for searching");
		String name = utility.singleStringInput();
		File patientObject = new File(name + ".json");
		if (patientObject.length() == 0) {
			System.out.println("File is empty");
		} else {
			System.out.println("Enter the name of patient for searching");
			String name1 = utility.singleStringInput();
			patientList.clear();

			List patientList1 = objectmapper.readValue(patientObject, new TypeReference<List<Doctor>>() {
			});
			patientList.addAll(patientList1);

			for (i = 0; i < patientList.size(); i++) {
				if (name1.equals(patientList.get(i).getName())) {
					cnt++;
					break;
				}
			}
			if (cnt > 0) {
				System.out.println("patient found");
				System.out.println(patientList.get(i));
			} else {
				System.out.println("not found");
			}
		}
	}

	@Override
	public void searchPatientByNumber() throws JsonParseException, JsonMappingException, IOException {
		int cnt = 0, i = 0;

		System.out.println("Enter the name of patient for searching");
		String name = utility.singleStringInput();
		File patientObject = new File(name + ".json");
		if (patientObject.length() == 0) {
			System.out.println("File is empty");
		} else {
			System.out.println("Enter the name of doctor for searching");
			String name1 = utility.singleStringInput();
			patientList.clear();

			List patientList1 = objectmapper.readValue(patientObject, new TypeReference<List<Doctor>>() {
			});
			patientList.addAll(patientList1);

			for (i = 0; i < patientList.size(); i++) {
				if (name1.equals(patientList.get(i).getPhoneNumber())) {
					cnt++;
					break;
				}
			}
			if (cnt > 0) {
				System.out.println("patient found");
				System.out.println(patientList.get(i));
			} else {
				System.out.println("not found");
			}
		}
	}

	@Override
	public void appointment() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Enter the doctor name whon you want to get the appointment");
		String name = utility.singleStringInput();
		File appointmentObject = new File(name + ".json");
		Appointment appointment = new Appointment();

		if (appointmentObject.length() == 0) {

			System.out.println("Enter the doctor name");
			appointment.setDoctorName(utility.singleStringInput());

			System.out.println("Enter the patient name");
			appointment.setPatientName(utility.singleStringInput());

			System.out.println("Enter the date");
			appointment.setDate(utility.singleStringInput());

			System.out.println("Enter the time");
			appointment.setTime(utility.singleStringInput());

			System.out.println(appointment);

			appointmentList.add(appointment);

			utility.writeObjectToJson(appointmentList, name + ".json");
		} else {
			appointmentList.clear();
			List<Appointment> appointmentList = objectmapper.readValue(appointmentObject,
					new TypeReference<List<Appointment>>() {
					});
			appointmentList.addAll(appointmentList);
			System.out.println();
			System.out.println("Enter the doctor name");
			appointment.setDoctorName(utility.singleStringInput());

			System.out.println("Enter the patient name");
			appointment.setPatientName(utility.singleStringInput());

			System.out.println("Enter the date");
			appointment.setDate(utility.singleStringInput());

			System.out.println("Enter the time");
			appointment.setTime(utility.singleStringInput());

			System.out.println(appointment);

			appointmentList.add(appointment);
			utility.writeObjectToJson(appointmentList, name + ".json");
		}
	}


@Override
	public void editDoctor() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Editing Doctor:-");
		System.out.println("Enter File Name from which doctor");
		String fileName = utility.singleStringInput();
		fileName = fileName + ".json";
		File doctorFileObject = new File(fileName);
		if (doctorFileObject.length() == 0) {
			System.out.println("file is empty!");
		} else {
			System.out.println("Enter Name of person to be edited");
			String name = utility.singleStringInput();
			List<Doctor> doctorFileList = objectmapper.readValue(doctorFileObject, new TypeReference<List<Doctor>>() {
			});
			doctorList.addAll(doctorFileList);
			System.out.println(doctorList);
			for (int i = 0; i < doctorList.size(); i++) {
				if (name.equals(((Doctor) doctorList.get(i)).getName())) {
					System.out.println("1.Change name");
					System.out.println("2.Chage id");
					System.out.println("3.Specialization");
					System.out.println("4.Avalibility");

					int ch = utility.IntegerInput();
					switch (ch) {
					case 1:
						System.out.println("Enter the Name to Repalce==>");
						String nametoRepalce = utility.singleStringInput();
						doctorList.get(i).setName(nametoRepalce);
						break;
					case 2:
						System.out.println("Enter the Id to change==>");
						String idtoReplace = utility.singleStringInput();
						doctorList.get(i).setId(idtoReplace);
						break;
					case 3:
						System.out.println("Enter the Specialization==>");
						String specialization = utility.singleStringInput();
						doctorList.get(i).setSpecialization(specialization);

						break;
					case 4:
						System.out.println("Enter the Avaliblity");
						String avaliability = utility.singleStringInput();
						doctorList.get(i).setAvailability(avaliability);
						break;

					}
					break;
				}

			}

		}
	}
@Override
	public void editPatient() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Editing Patient:-");
		System.out.println("Enter File Name from which Patient");
		String fileName = utility.singleStringInput();
		fileName = fileName + ".json";
		File patientFileObject = new File(fileName);
		if (patientFileObject.length() == 0) {
			System.out.println("file is empty!");
		} else {
			System.out.println("Enter Name of Patient to be edited");
			String name = utility.singleStringInput();
			List<Patient> patientFileList = objectmapper.readValue(patientFileObject,
					new TypeReference<List<Doctor>>() {
					});
			patientList.addAll(patientFileList);
			System.out.println(patientList);
			for (int i = 0; i < patientList.size(); i++) {
				if (name.equals(((Patient) patientList.get(i)).getName())) {
					System.out.println("1.Change name");
					System.out.println("2.Chage id");
					System.out.println("3.PhoneNumber");

					int ch = utility.IntegerInput();
					switch (ch) {
					case 1:
						System.out.println("Enter the Name to Repalce==>");
						String nametoRepalce = utility.singleStringInput();
						patientList.get(i).setName(nametoRepalce);
						break;
					case 2:
						System.out.println("Enter the Id to change==>");
						String idtoReplace = utility.singleStringInput();
						patientList.get(i).setId(idtoReplace);
						break;
					case 3:
						System.out.println("Enter the Specialization==>");
						String phNumber = utility.singleStringInput();
						patientList.get(i).setPhoneNumber(phNumber);

						break;

					}
					break;
				}

			}

		}
	}
@Override
	public void saveFile() {
		System.out.println("Saving the file");
		System.out.println("1.Saving the Person");
		System.out.println("2.Saving the Patient");
		int ch = utility.IntegerInput();
		switch (ch) {

		case 1:
			System.out.println("Enter the File name to Save:=>");
			String fileName = utility.singleStringInput();
			System.out.println(doctorList);
			utility.writeObjectToJson(doctorList, fileName + ".json");
			doctorList.clear();
			break;
		case 2:
			System.out.println("Saving the Patient");
			System.out.println("Enter the File name to Save:=>");
			String fileName1 = utility.singleStringInput();
			System.out.println(patientList);
			utility.writeObjectToJson(patientList, fileName1 + ".json");
			patientList.clear();
			break;
		case 3:
			return;
		}
	}
@Override
	public void createFile() {
		System.out.println("Enter the file Name:==>");
		String filename = utility.singleStringInput();
		String path = filename + ".json";
		try {
			File file = new File(path);
			boolean created = file.createNewFile();
			if (created) {
				System.out.println("file has been Created");
			} else {
				System.out.println("File is already present");
			}
		} catch (IOException e) {
			System.out.println("Exception Occured:" + e);
			e.printStackTrace();
		}
		//filelist.add(filename);
	}
}
