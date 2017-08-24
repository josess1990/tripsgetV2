package com.openbanking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.openbanking.util.EndpointExtractor;
import com.openbanking.util.JsonReader;

public class AtmParser {

	private final String PARTICIPANT_BANKS = "https://developer.openbanking.org.uk/open-data/participant-store/participant_store.json";
	private String last_update = "";

	public ArrayList<String> getBankAtms() {
		return null;

	}

	public void gatherStaticValues() {
		ArrayList<String> languagesArr = new ArrayList<String>();
		ArrayList<String> atmServicesArr = new ArrayList<String>();
		ArrayList<String> currenciesArr = new ArrayList<String>();
		ArrayList<String> locationCategoryArr = new ArrayList<String>();

		for (String atmEndpoint : EndpointExtractor.getEndpointUrls("atms")) {
			JSONObject jsonResponse = new JSONObject();

			try {
				System.out.println("opening: " + atmEndpoint);
				jsonResponse = JsonReader.readJsonFromUrl(atmEndpoint);

				JSONArray atmArr = jsonResponse.getJSONArray("data");
				for (Object atmElem : atmArr) {
					JSONObject atm = (JSONObject) atmElem;

					// Currency
					for (Object currency : atm.getJSONArray("Currency")) {
						if (!currenciesArr.contains(currency.toString())) {
							currenciesArr.add(currency.toString());
						}
					}

					// Language
					for (Object languages : atm.getJSONArray("SupportedLanguages")) {
						if (!languagesArr.contains(languages.toString().toUpperCase())) {
							languagesArr.add(languages.toString().toUpperCase());
						}
					}

					// ATM services
					for (Object service : atm.getJSONArray("ATMServices")) {
						if (!atmServicesArr.contains(service.toString())) {
							atmServicesArr.add(service.toString());
						}
					}
					Atm atmObj = new Atm();
					atmObj.bank_name = atm.getJSONObject("Organisation").getJSONObject("ParentOrganisation").getJSONObject("OrganisationName").getString("LegalName");
					atmObj.id = atm.getString("ATMID");
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (String currency : currenciesArr) {
			System.out.println(currency);
		}

		for (String language : languagesArr) {
			System.out.println(language);
		}

		for (String service : atmServicesArr) {
			System.out.println(service);
		}

	}

}
