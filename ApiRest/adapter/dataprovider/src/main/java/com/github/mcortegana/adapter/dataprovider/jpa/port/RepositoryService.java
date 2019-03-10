package com.github.mcortegana.adapter.dataprovider.jpa.port;

import com.github.mcortegana.core.entity.User;
import com.github.mcortegana.core.port.UserRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoryService extends UserRepository {

    @Override
    User create(User user);

    @Override
    Optional<User> findById(String id);

    @Override
    Optional<User> findByEmail(String email);

    @Override
    List<User> findAllUsers();
}
