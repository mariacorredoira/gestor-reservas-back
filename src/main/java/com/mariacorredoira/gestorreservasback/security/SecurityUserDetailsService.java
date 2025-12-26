package com.mariacorredoira.gestorreservasback.security;

import com.mariacorredoira.gestorreservasback.users.application.exceptions.UserNotFoundException;
import com.mariacorredoira.gestorreservasback.users.domain.entity.User;
import com.mariacorredoira.gestorreservasback.users.domain.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.getByEmail(username);
            return new SecurityUser(user);

        } catch (UserNotFoundException ex) {
            throw new UsernameNotFoundException(ex.getMessage());
        }
    }
}
