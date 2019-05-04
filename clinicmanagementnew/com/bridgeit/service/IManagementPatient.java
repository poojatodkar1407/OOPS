package com.bridgeit.service;

import org.json.simple.JSONObject;

public interface IManagementPatient {
	JSONObject byName(JSONObject jsonObject, Object name);

	/**
	 * function searches the patient by mobile number in the clinic
	 * 
	 * @param jsonObject patients list
	 * @param mobNo      mobile number of patient
	 * @return Object of particular patient
	 */
	JSONObject byMobNo(JSONObject jsonObject, Object mobNo);

	/**
	 * function searches the patient id in the clinic
	 * 
	 * @param jsonObject patients list
	 * @param id         of the patient
	 * @return Object of particular patient
	 */
	JSONObject byId(JSONObject jsonObject, Object id);
}
