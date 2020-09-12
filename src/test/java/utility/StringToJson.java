package utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StringToJson {

	public static void main(String[] args){
	
	String s  = "\"LastName\": \"XYZ\",\"UserName\": \"Johddn XYZ\",\"Password\": \"Joddhn\",\"Email\": \"Johnddf@gmail.com\"";
	
	String a = "\"LastName\": \"XYZhdjdkdld\",\"UserName\": \"Johddn XYZddf\",\"Password\": \"Joddhn1234444\",\"Email\": \"Johnddsdsdsdsdsdf@gmail.com\"";
	ObjectMapper mapper = new ObjectMapper();
	try {
	  String json = mapper.writeValueAsString(s);
	  System.out.println("ResultingJSONstring = " + json);
	  //System.out.println(json);
	} catch (JsonProcessingException e) {
	   e.printStackTrace();
	}
	
	}
}
