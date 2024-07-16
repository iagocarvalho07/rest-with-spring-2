package br.com.iago.restap.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.iago.restap.dataVo.AcconutCredencialVO;
import br.com.iago.restap.dataVo.TokenVo;
import br.com.iago.restap.interfaces.UserRepository;
import br.com.iago.restap.securityJwt.JwtTokenProvider;

@Service
public class AuthService {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	public ResponseEntity signin(AcconutCredencialVO data) {
		try {
			var username = data.getUsername();
			var password = data.getPassword();
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			var user = userRepository.findByUsername(username);
			var tokenResponse = new TokenVo();
			if (user != null) {
				tokenResponse = jwtTokenProvider.createAccessToken(username, user.getRoles());
			} else {
				throw new UsernameNotFoundException("Username" + username + " not found!");
			}
			return ResponseEntity.ok(tokenResponse);
		} catch (Exception e) {
			throw new BadCredentialsException("Invalid Username/ password supplied!");
		}
	}
}
