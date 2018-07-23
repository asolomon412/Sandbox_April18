
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
		// Three ways to use regex in java
		// 1st way
		Pattern p = Pattern.compile(".s");// . represents single character
		Matcher m = p.matcher("as");
		boolean b = m.matches();

		// 2nd way
		boolean b2 = Pattern.compile(".s").matcher("as").matches();

		// 3rd way
		boolean b3 = Pattern.matches(".s", "as");

		System.out.println(b + " " + b2 + " " + b3);
		
		// The . (dot) represents a single character.
		System.out.println(Pattern.matches(".s", "as"));//true (2nd char is s)  
		System.out.println(Pattern.matches(".s", "mk"));//false (2nd char is not s)  
		System.out.println(Pattern.matches(".s", "mst"));//false (has more than 2 char)  
		System.out.println(Pattern.matches(".s", "amms"));//false (has more than 2 char)  
		System.out.println(Pattern.matches("..s", "mas"));//true (3rd char is s)
		
		// character classes
		System.out.println(Pattern.matches("[bvm]", "bvmd"));//true  
		System.out.println(Pattern.matches("[amn]", "a"));//true (among a or m or n)  
		System.out.println(Pattern.matches("[amn]", "ammmna"));//false (m and a comes more than once)  
		
		// quantifiers
		System.out.println("? quantifier ....");  
		System.out.println(Pattern.matches("[amn]?", "a"));//true (a or m or n comes one time)  
		System.out.println(Pattern.matches("[amn]?", "aaa"));//false (a comes more than one time)  
		System.out.println(Pattern.matches("[amn]?", "aammmnn"));//false (a m and n comes more than one time)  
		System.out.println(Pattern.matches("[amn]?", "aazzta"));//false (a comes more than one time)  
		System.out.println(Pattern.matches("[amn]?", "am"));//false (a or m or n must come one time)  
		  
		System.out.println("+ quantifier ....");  
		System.out.println(Pattern.matches("[amn]+", "a"));//true (a or m or n once or more times)  
		System.out.println(Pattern.matches("[amn]+", "aaa"));//true (a comes more than one time)  
		System.out.println(Pattern.matches("[amn]+", "aammmnn"));//true (a or m or n comes more than once)  
		System.out.println(Pattern.matches("[amn]+", "aazzta"));//false (z and t are not matching pattern)  
		  
		System.out.println("* quantifier ....");  
		System.out.println(Pattern.matches("[amn]*", "ammmna"));//true (a or m or n may come zero or more times)  
		
		// short codes
		System.out.println("metacharacters d...."); // \\d means digit  
		  
		System.out.println(Pattern.matches("\\d", "abc"));//false (non-digit)  
		System.out.println(Pattern.matches("\\d", "1"));//true (digit and comes once)  
		System.out.println(Pattern.matches("\\d", "4443"));//false (digit but comes more than once)  
		System.out.println(Pattern.matches("\\d", "323abc"));//false (digit and char)  
		  
		System.out.println("metacharacters D...."); // \\D means non-digit  
		  
		System.out.println(Pattern.matches("\\D", "abc"));//false (non-digit but comes more than once)  
		System.out.println(Pattern.matches("\\D", "1"));//false (digit)  
		System.out.println(Pattern.matches("\\D", "4443"));//false (digit)  
		System.out.println(Pattern.matches("\\D", "323abc"));//false (digit and char)  
		System.out.println(Pattern.matches("\\D", "m"));//true (non-digit and comes once)  
		  
		System.out.println("metacharacters D with quantifier....");  
		System.out.println(Pattern.matches("\\D*", "mak"));//true (non-digit and may come 0 or more times)  

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

		// find() - Attempts to find the next subsequence of the input sequence that
		// matches the pattern.
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
