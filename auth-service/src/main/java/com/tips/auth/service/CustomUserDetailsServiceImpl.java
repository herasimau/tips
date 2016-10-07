package com.tips.auth.service;


import com.tips.auth.model.CurrentUser;
import com.tips.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @author herasimau on 07.10.2016.
 */
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {


    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       return userRepository.findByEmail(email).
               map(user -> new CurrentUser(user))
               .orElseThrow(()-> new UsernameNotFoundException("user not found with "+email));

    }
}
