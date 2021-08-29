package castisvn.repository;

//import castisvn.commonUtils.EmailFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import castisvn.entities.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username_or_email) throws UsernameNotFoundException {		
		
//		User user = new User();
//		if(EmailFormat.checkEmailValidFormat(username_or_email)) {
//			user = userRepository.getUserByEmail(username_or_email);
//		} else {
//			user = userRepository.getUserByUsername(username_or_email)
//			.orElseThrow(() -> new UsernameNotFoundException("Could not find user"));
//		}
		
		User user = userRepository.getUserByUsername(username_or_email)
				.orElseThrow(() -> new UsernameNotFoundException("Could not find user"));
		return new MyUserDetails(user);
	}

}
