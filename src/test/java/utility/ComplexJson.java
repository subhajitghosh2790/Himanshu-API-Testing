package utility;

import java.io.FileReader;
import java.util.Date;
import java.util.Map;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.github.wnameless.json.unflattener.JsonUnflattener;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ComplexJson {

	public static void main(final String[] args) {

		/*
		 * final String jsonStr =
		 * "{\"createBooking\": {\"createBookingInput\": {\"reservation\": {\"departureDate\": \"2012-01-05T00:00:00.000Z\",\"arrivalDate\": \"2012-01-08T00:00:00.000Z\",\"hotelCode\": \"1234567\",\"resGuestPaymentRoomStayMappings\": {\"resGuestPaymentRoomStayMapping\": [{\"roomStay\": \"0\",\"resGuest\": \"0\",\"paymentType\": \"0\"}]}}}}}"
		 * ; final JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonStr);
		 * 
		 * System.out.println(jsonObject);
		 */
		//ComplexJson c = new ComplexJson();
		//c.ReqBody();

		System.out.println(new Date().getTime());;

	}

	public void ReqBody() {
		try {
			final JSONParser parser = new JSONParser();
			// Use JSONObject for simple JSON and JSONArray for array of JSON.
			final JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("./crunchify.txt"));

			System.out.println("JSON Object is --> " + jsonObject);
			System.out.println("JSON STRING IS SUBHAJIT ---- > " + jsonObject.toJSONString());

			System.out.println("SUBHAJIT---> GET CLASS ---->" + jsonObject.getClass());

		} catch (final Exception e) {
		}
	}

	public void newReqPL() {
		/*
		 * String jsonStr = "{\"createBooking\": {\"createBookingInput\":
		 * {\"reservation\": {\"departureDate\":
		 * \"2012-01-05T00:00:00.000Z\",\"arrivalDate\":
		 * \"2012-01-08T00:00:00.000Z\",\"hotelCode\":
		 * \"1234567\",\"resGuestPaymentRoomStayMappings\":
		 * {\"resGuestPaymentRoomStayMapping\": [{\"roomStay\": \"0\",\"resGuest\":
		 * \"0\",\"paymentType\": \"0\"}]}}}}}";
		 */

		// String newStrring = jsonStr.replaceAll("\\s", "");

		// System.out.println("New String is --> "+newStrring);

		// final JSONObject jsonObject = (JSONObject)
		// JSONValue.parse(newStrring.toString());
		final JSONParser parser = new JSONParser();
		try {
			final Object obj = parser.parse(new FileReader("./crunchify.txt"));
			// Object obj = (Object) s;
			final JSONObject jsonObject = (JSONObject) obj;

			// final JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonStr);

			System.out.println("JSON Object is --> " + jsonObject);
			System.out.println("JSON STRING IS SUBHAJIT ---- > " + jsonObject.toJSONString());

			System.out.println("SUBHAJIT---> GET CLASS ---->" + jsonObject.getClass());
			// httpRequest.body(jsonObject);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public void m() {
		final JSONParser parser = new JSONParser();
		try {

			// String jsonString = "\"{"name" : "Ronaldo","sport" : "soccer","age" : 25,"id"
			// : 121,"lastScores" : [ 2, 1, 3, 5, 0, 0, 1, 1 ]}\"

			final String s = "abc+zyx";

			// Put above JSON content to crunchify.txt file and change path location
			// Object obj = parser.parse(new FileReader("./crunchify.txt"));
			final Object obj = (Object) s;
			final JSONObject jsonObject = (JSONObject) obj;

			// JsonFlattener: A Java utility used to FLATTEN nested JSON objects
			final String flattenedJson = JsonFlattener.flatten(jsonObject.toString());
			log("\n=====Simple Flatten===== \n" + flattenedJson);

			final Map<String, Object> flattenedJsonMap = JsonFlattener.flattenAsMap(jsonObject.toString());

			log("\n=====Flatten As Map=====\n" + flattenedJson);
			// We are using Java8 forEach loop. More info: http://crunchify.me/1VIwm0l
			flattenedJsonMap.forEach((k, v) -> log(k + " : " + v));

			// Unflatten it back to original JSON
			final String nestedJson = JsonUnflattener.unflatten(flattenedJson);
			System.out.println("\n=====Unflatten it back to original JSON===== \n" + nestedJson);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private static void log(final String flattenedJson) {
		System.out.println(flattenedJson);

	}

}
