package com.openbanking;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.openbanking.util.DatabaseConnector;
import com.openbanking.util.JsonReader;
import com.openbanking.AtmParser;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//AtmParser parser = new AtmParser();		
        //parser.gatherStaticValues();
    	//System.out.println(parser.getBankAtms().size());
    	DatabaseConnector connection = new DatabaseConnector();
    	connection.connect();
    }
}
