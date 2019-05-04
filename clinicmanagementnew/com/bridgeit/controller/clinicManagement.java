package com.bridgeit.controller;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public interface clinicManagement {
	void addDoctor();

	/**
	 * function adds the patients in the clinic
	 * @throws ParseException 
	 * @throws IOException 
	 */
	void addPatient() throws IOException, ParseException;

	/**
	 * function displays the doctors in the clinic
	 * @throws ParseException 
	 * @throws IOException 
	 */
	void viewDoctors() throws IOException, ParseException;

	/**
	 * function displays the patients in the clinic
	 * @throws ParseException 
	 * @throws IOException 
	 */
	void viewPatients() throws IOException, ParseException;

	/**
	 * function checks the popular specialization in the clinic
	 */
	void popularSpecialization();

	void popularDoctor();

	/**
	 * /** function checks the popular doctors in the clinic
	 * @throws ParseException 
	 * @throws IOException 
	 */
	//void popularDoctor() throws IOException, ParseException;
}
