package com.github.mcortegana.adapter.dataprovider.jpa.port.impl;

import com.github.mcortegana.adapter.dataprovider.jpa.entity.UserEntity;
import com.github.mcortegana.adapter.dataprovider.jpa.entity.mappers.UserMapperConverter;
import com.github.mcortegana.adapter.dataprovider.jpa.port.RepositoryService;
import com.github.mcortegana.adapter.dataprovider.jpa.repository.UserJpaRepository;
import com.github.mcortegana.core.entity.User;
import com.github.mcortegana.core.exception.NotAllowedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RepositoryServiceImpl implements RepositoryService {

    private final UserJpaRepository jpaRepository;
    private final UserMapperConverter mapperConverter;

    public RepositoryServiceImpl(UserJpaRepository jpaRepository, UserMapperConverter mapperConverter) {
        this.jpaRepository = jpaRepository;
        this.mapperConverter = mapperConverter;
    }

    @Override
    public User create(User user) {
        UserEntity userEntity = mapperConverter.toEntity(user);
        return mapperConverter.toDomain(jpaRepository.saveAndFlush(userEntity));
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(mapperConverter.toDomain(jpaRepository.findById(id)
                .orElseThrow(() -> new NotAllowedException("No user found"))));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(mapperConverter.toDomain(jpaRepository.findByEmail(email)
                .orElseThrow(() -> new NotAllowedException("No found user"))));
    }

    @Override
    public List<User> findAllUsers() {
        return jpaRepository.findAll().stream()
                .map(mapperConverter::toDomain)
                .collect(Collectors.toList());
    }
}
