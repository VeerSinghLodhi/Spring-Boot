
package com.naukriforsagar.NaukriForSagar.SecurityPackage.EntitiesClassess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users=userRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User Not Found"));

        return new org.springframework.security.core.userdetails.User(
                users.getUsername(),
                users.getPassword(),
                users.isEnabled(),
                true,
                true,
                true,
                users.getRoles().stream()
                        .map(role->new SimpleGrantedAuthority("ROLE_"+role.getName()))
                        .collect(Collectors.toList())
        );
    }
}
