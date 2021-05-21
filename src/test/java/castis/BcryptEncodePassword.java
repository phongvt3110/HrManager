package castis;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.logging.log4j.*;

//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncodePassword {

	/**
	 * @param args
	 * @throws URISyntaxException 
	 */
	public static final Logger log = LogManager.getLogger(BcryptEncodePassword.class);
	
	public static void main(String[] args) throws InterruptedException, URISyntaxException{
		// TODO Auto-generated method stub		
//		BCryptPasswordEncoder encodePassword = new BCryptPasswordEncoder();
//		String rawPasswordString = "tuanch";
//		System.out.println(encodePassword.encode(rawPasswordString));		
//		System.out.println(System.currentTimeMillis());
//		System.out.println(LocalDate.now());
//		System.out.println(LocalTime.now());
//		System.out.println(LocalDateTime.now());
//		System.out.println(new Date(System.currentTimeMillis()));				
//		System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss").format(LocalDateTime.now()));
//		System.out.println(new Date());		
		
		URI oldUri = new URI("http://10.60.70.228:18080/ADDSse/spotx/data?castis=cd5f732fe8ab2d84e4bc283e36dcd32e-48738.b779c.cf46&multicast=true");
		String newQuery = oldUri.getQuery();
		System.out.println(newQuery);
		boolean isFirstParam = (newQuery == null) || newQuery.equals("");
		System.out.println(isFirstParam);
		String pathName = oldUri.getPath();
		System.out.println(pathName);
		int idx = oldUri.getPath().lastIndexOf("/");
		String fileName = String.format("%s?castis=%s", pathName.substring(idx + 1), 15);
		System.out.println(fileName);
		System.out.println(idx);
		StringBuffer sb = new StringBuffer();
		sb.append("&" + "multicast=true");
		System.out.println(sb.toString());		
		log.info("Finish test");
	}
}
