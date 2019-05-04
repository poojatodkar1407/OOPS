package com.bridgeit.service;

import java.util.ArrayList;

import com.bridgeit.model.Person;

public interface AddressBook {
	void addPerson();
	ArrayList<Person> editPerson(String name);
	void deletePerson(String name);
	ArrayList<Person> sortByLastName(ArrayList<Person> list);
	ArrayList<Person> sortByZip(ArrayList<Person> list);
	void print(ArrayList<Person> list);
}
