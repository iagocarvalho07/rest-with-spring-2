package br.com.iago.restap.servises;


import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import br.com.iago.restap.interfaces.UserRepository;

@Service
public class UserServices2 implements UserDetailsService {

	@Autowired
	UserRepository repostiroty;


	public UserServices2(UserRepository repostiroty) {
		this.repostiroty = repostiroty;
	}


	private Logger logger = Logger.getLogger(UserServices2.class.getName());

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("find one User by name!" + username);
		var user = repostiroty.findByUsername(username);
		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException(" user name" + username + "not found");
		}
	}
}
