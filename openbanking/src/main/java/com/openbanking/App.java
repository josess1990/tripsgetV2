package com.openbanking;

import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.openbanking.util.PgsqlConnection;
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
    	AtmParser parser = new AtmParser();		
        parser.gatherStaticValues();
    	System.out.println(parser.getBankAtms().size());
//    	PgsqlConnection connection = new PgsqlConnection();
//    	try {
//			connection.executeStatement("hola");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
}
