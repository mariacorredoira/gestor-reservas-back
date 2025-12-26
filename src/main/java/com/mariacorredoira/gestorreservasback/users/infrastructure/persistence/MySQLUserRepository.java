package com.mariacorredoira.gestorreservasback.users.infrastructure.persistence;

import com.mariacorredoira.gestorreservasback.users.application.exceptions.EmailAlreadyExistsException;
import com.mariacorredoira.gestorreservasback.users.application.exceptions.UserNotFoundException;
import com.mariacorredoira.gestorreservasback.users.domain.entity.User;
import com.mariacorredoira.gestorreservasback.users.domain.repository.UserRepository;
import com.mariacorredoira.gestorreservasback.users.infrastructure.persistence.entity.UserEntity;
import com.mariacorredoira.gestorreservasback.users.infrastructure.persistence.mapper.UserInfrastructureMapper;
import com.mariacorredoira.gestorreservasback.users.infrastructure.persistence.spring.SpringUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MySQLUserRepository implements UserRepository
{
    private final SpringUserRepository springUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {

        if (springUserRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException(user.getEmail());
        }

        UserEntity userEntity = UserInfrastructureMapper.toUserEntity(user, passwordEncoder);
        userEntity = springUserRepository.save(userEntity);
        user = UserInfrastructureMapper.toUserDomain(userEntity);
        return user;
    }

    @Override
    public User getByEmail(String email) {
        Optional<UserEntity> userOpt = springUserRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            throw new UserNotFoundException(email);
        }
        User user = UserInfrastructureMapper.toUserDomain(userOpt.get());
        return user;
    }
}
