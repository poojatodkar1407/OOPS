package com.bridgeit.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.codehaus.jackson.map.ObjectMapper;

import com.bridgeit.model.Person;

public class JacksonClass {
	public static void main(String[] args) {
		try {
			
			FileWriter filewriter=new FileWriter("/home/admin1/eclipse-workspace/ObjectOriented_json/good.json");
			PrintWriter printwrite=new PrintWriter(filewriter);
			Person p=new Person();
			p.setLastname("pooja");
			p.setCity("mumbai");
			ObjectMapper mapping = new ObjectMapper();
			mapping.writeValue(printwrite, p);
			printwrite.flush();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	
	}

}
