package co.edu.unbosque.util.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionChecker {

	public static void notValidInputException(String txt) throws NotValidInputException {

		Pattern p = Pattern.compile("[^a-zA-ZñÑ ]");
		Matcher m = p.matcher(txt);

		if (m.find()) {
			throw new NotValidInputException();
		}

	}

	public static void notValidBooleanException(Boolean b) throws NotValidBooleanException {
		if (b == null) {
			throw new NotValidBooleanException();
		}
	}

	public static void negativeIntNumberException(int n) throws NegativeIntNumberException {
		if (n < 0) {
			throw new NegativeIntNumberException();
		}
	}

}
