package com.github.mcortegana.usecases;

import com.github.mcortegana.core.entity.User;
import com.github.mcortegana.core.port.UserRepository;

import java.util.List;
import java.util.Optional;

public class FindUser {

    private final UserRepository repository;

    public FindUser(final UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> findById(final String id){
        return repository.findById(id);
    }

    public List<User> listAllUsers(){
        return repository.findAllUsers();
    }

}
