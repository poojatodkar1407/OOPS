package com.bridgeit.service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public interface AddressBookManager {
	void readFile() throws JsonParseException, JsonMappingException, IOException;
	boolean createFile(String file) throws IOException;
}
