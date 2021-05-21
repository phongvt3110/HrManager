package castisvn.commonUtils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class CommonGenerator {
	private static final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	public static final String passwordGenetor(String pass) {
		return bcrypt.encode(pass);
	}
}
