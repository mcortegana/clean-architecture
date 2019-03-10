package com.github.mcortegana.core.port;

import com.github.mcortegana.core.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public User create(User user);

    public Optional<User> findById(String id);

    public Optional<User> findByEmail(String email);

    public List<User> findAllUsers();
}
