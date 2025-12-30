package com.mariacorredoira.gestorreservasback.users.infrastructure.persistence;

import com.mariacorredoira.gestorreservasback.shared.PageResponse;
import com.mariacorredoira.gestorreservasback.users.application.exceptions.UserNotFoundException;
import com.mariacorredoira.gestorreservasback.users.domain.entity.User;
import com.mariacorredoira.gestorreservasback.users.domain.repository.UserRepository;
import com.mariacorredoira.gestorreservasback.users.infrastructure.persistence.entity.UserEntity;
import com.mariacorredoira.gestorreservasback.users.infrastructure.persistence.mapper.UserInfrastructureMapper;
import com.mariacorredoira.gestorreservasback.users.infrastructure.persistence.spring.SpringUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class MySQLUserRepository implements UserRepository {
    private final SpringUserRepository springUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        UserEntity userEntity = UserInfrastructureMapper.toUserEntity(user, passwordEncoder);
        userEntity = springUserRepository.save(userEntity);
        user = UserInfrastructureMapper.toUserDomain(userEntity);
        return user;
    }

    @Override
    public User update(User user) {
        UserEntity userEntity = UserInfrastructureMapper.toUserEntity(user, passwordEncoder);
        userEntity = springUserRepository.save(userEntity);
        user = UserInfrastructureMapper.toUserDomain(userEntity);
        return user;
    }

    @Override
    public void delete(Long id) {

        springUserRepository.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        Optional<UserEntity> userOpt = springUserRepository.findById(id);
        User user = UserInfrastructureMapper.toUserDomain(userOpt.get());
        return user;
    }

    @Override
    public boolean existsByEmail(String email) {
        return springUserRepository.existsByEmail(email);
    }

    @Override
    public User getByEmail(String email) {
        Optional<UserEntity> userOpt = springUserRepository.findByEmail(email);
        User user = UserInfrastructureMapper.toUserDomain(userOpt.get());
        return user;
    }

    @Override
    public PageResponse<User> findByFilters(String name, String firstSurname, String secondSurname, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<UserEntity> userPage = springUserRepository.searchByFilters(name, firstSurname, secondSurname, pageable);
        List<User> userList = UserInfrastructureMapper.toUsersDomain(userPage.getContent());
        PageResponse<User> users = new PageResponse<>(userList, page, userPage.getTotalElements());
        return users;
    }
}
