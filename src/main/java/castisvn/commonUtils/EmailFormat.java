package castisvn.commonUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class EmailFormat {
	private static final String EMAIL_PATTERN =
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	public static boolean checkEmailValidFormat(String email) {
		Matcher matcher = pattern.matcher(email);		
		return matcher.matches();
	}
}
