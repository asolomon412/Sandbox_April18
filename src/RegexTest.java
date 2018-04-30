
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
		
		String test = "Antonella Hello 1570 Woodward 48226 (313)555-1212 antonella@grandcircus.co";
		// check for zipcode
		checkRegex("\\d{5}", test);
		
		// check for phone number
		checkRegex("\\(+\\d{3}+\\)+\\d{3}+\\-\\d{4}", test);
		
		// check for email
		checkRegex("\\w+@\\w+\\.\\w{2,4}", test);
		

	}

	public static void checkRegex(String regex, String sentence) {
		// compiles the given regular expression into a pattern
		Pattern check = Pattern.compile(regex);
		// creates a matcher that will match the given input against this pattern
		Matcher checkMatch = check.matcher(sentence);

		// find() - Attempts to find the next subsequence of the input sequence that matches the pattern.
		while (checkMatch.find()) {
			// group() - Returns the input subsequence matched by the previous match.
			if (checkMatch.group().length() != 0) {
				System.out.println(checkMatch.group().trim());
			}
			System.out.println("Starting index: " + checkMatch.start());
			System.out.println("Ending index: " + checkMatch.end());
		}
	}

}
