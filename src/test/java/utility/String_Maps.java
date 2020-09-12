package utility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class String_Maps {

	public static void main(String args[]) {

		Map<String, String> map = new HashMap<>();

		String str = "A:1, B:   2,C:3,D:4";

		Map<String, String> result = Arrays.stream(str.split(",")).map(s -> s.split(":"))
				.collect(Collectors.toMap(a -> a[0], // key
						a -> a[1] // value
				));

		
	}

}
