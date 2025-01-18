package com.unir.poyecto.service;

//@Service
//public class CustomUserDetailsService implements UserDetailsService {
public class CustomUserDetailsService {

//	@Autowired
//	private UsuarioRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Usuario user = userRepository.findByUsername(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found");
//		}
//
//		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//		for (Role role : user.getRoles()) {
//			grantedAuthorities.add(new SimpleGrantedAuthority(role.getNombre()));
//		}
//
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getContrasena(),
//				grantedAuthorities);
//	}
}
