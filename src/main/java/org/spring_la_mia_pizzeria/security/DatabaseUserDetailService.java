package org.spring_la_mia_pizzeria.security;

import java.util.Optional;

import org.spring_la_mia_pizzeria.model.User;
import org.spring_la_mia_pizzeria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionUser = userRepository.findByUsername(username);

        if (optionUser.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return new DatabaseUserDetails(optionUser.get());
    }

}
