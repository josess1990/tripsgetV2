package com.openbanking.util;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EndpointExtractor {

	private final static String PARTICIPANT_BANKS = "https://developer.openbanking.org.uk/open-data/participant-store/participant_store.json";

	public static ArrayList<String> getEndpointUrls(String serviceName) {
		ArrayList<String> bankUrls = new ArrayList<String>();
		JSONObject json = new JSONObject();
		try {
			json = JsonReader.readJsonFromUrl(PARTICIPANT_BANKS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(json.toString());
		JSONArray banksArr = json.getJSONArray("data");
		for (Object elemBank : banksArr) {
			JSONObject bank = (JSONObject) elemBank;
			JSONObject supApi = bank.getJSONObject("supportedAPIs");
			if (supApi != null) {
				try {
					JSONArray atmVersions = supApi.getJSONArray(serviceName);
					for (Object version : atmVersions) {
						String bankAtmUrl = bank.getString("baseUrl") +"/"+ version.toString() + "/" + serviceName;
						System.out.println(bankAtmUrl);
						bankUrls.add(bankAtmUrl);
					}
				}catch (Exception e) {
					System.out.println("No " + serviceName+" API for " + bank.getString("name"));
					//e.printStackTrace();
				}

			}
		}
		return bankUrls;
	}
}
