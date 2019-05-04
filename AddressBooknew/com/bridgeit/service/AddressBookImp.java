package com.bridgeit.service;

import java.util.ArrayList;
import java.util.Collections;

import com.bridgeit.model.Person;

import Json_Programs.utility;

public class AddressBookImp implements AddressBook {

	public ArrayList<Person> list=new ArrayList<Person>();
	
	public AddressBookImp(){}
	AddressBookImp(ArrayList<Person> list){
		this.list=list;
	}
	
	
	/* Function adds person in the list 
	 * @see com.bridgeIt.objectOriented.AddressBook.AddressBook#addPerson()
	 */
	@Override
	public void addPerson() {
		
		Person person=new Person();
		System.out.println("Enter your First name");
		person.setFirstName(utility.inputString());
		System.out.println("Enter your Last name");
		person.setLastname(utility.inputString());
		System.out.println("Enter your Address");
		String st=utility.inputStringLong();
		person.setAddress(st);
		System.out.println("Enter your City");
		person.setCity(utility.inputString());
		System.out.println("Enter your ZipCode");
		person.setZipcode(utility.inputInt());
		System.out.println("Enter your State");
		person.setState(utility.inputString());
		System.out.println("Enter your phone Number");
		person.setPhoneNumber(utility.inputString());
		list.add(person);
		
	}

	/* Function edits the existing person 
	 * @see com.bridgeIt.objectOriented.AddressBook.AddressBook#editPerson(java.lang.String)
	 */
	@Override
	public ArrayList<Person> editPerson(String name) {

		print(list);
	for (Person people : list) {
			if(people.getFirstName().equals(name))	{
				
				System.out.println("Enter your Address");
				String st=utility.inputStringLong();
				people.setAddress(st);
				System.out.println("Enter your City");
				people.setCity(utility.inputString());
				System.out.println("Enter your state");
				people.setState(utility.inputString());
				System.out.println("Enter your ZipCode");
				people.setZipcode(utility.inputInt());
				System.out.println("Enter your phone Number");
				people.setPhoneNumber(utility.inputString());
				print(list);
				return list;
			}
			
			}
		System.out.println("No such name exist.");
		print(list);
		return list;
	}

	/* Function deletes the person from the list
	 * @see com.bridgeIt.objectOriented.AddressBook.AddressBook#deletePerson(java.lang.String)
	 */
	@Override
	public void deletePerson(String name) {
		
		
		for (Person people : list) {
				if(people.getFirstName().equals(name))	{
					list.remove(people);
					break;
				}
				
				}
		System.out.println("No such name exist.");
		print(list);
	}

	/* function sorts the persons according to last name
	 * @see com.bridgeIt.objectOriented.AddressBook.AddressBook#sortByLastName(java.util.ArrayList)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Person> sortByLastName(ArrayList<Person> list) {
		
	Collections.sort(list,new NameComparator());
		
		return list;
	}

	/* function sorts the persons according to zip code
	 * @see com.bridgeIt.objectOriented.AddressBook.AddressBook#sortByZip(java.util.ArrayList)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Person> sortByZip(ArrayList<Person> list) {

		Collections.sort(list,new ZipComparator());
		
		return list;
	}

	
	/* Function prints the list of person
	 * @see com.bridgeIt.objectOriented.AddressBook.AddressBook#print(java.util.ArrayList)
	 */
	@Override
	public void print(ArrayList<Person> list) {
			
		for (Person person : list) {
			
			System.out.println("First Name:- "+person.getFirstName()+" Last Name:- "+person.getLastname());
			System.out.println("Address:- "+person.getAddress());
			System.out.println("City:- "+person.getCity()+" State:- "+person.getState());
			System.out.println("Zip code:- "+person.getZipcode());
			System.out.println();
		}
		
}

}
