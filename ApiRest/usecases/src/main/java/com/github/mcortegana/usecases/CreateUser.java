package com.github.mcortegana.usecases;

import com.github.mcortegana.core.entity.User;
import com.github.mcortegana.core.exception.UserAlreadyExistException;
import com.github.mcortegana.core.port.IdGenerator;
import com.github.mcortegana.core.port.PasswordEncoder;
import com.github.mcortegana.core.port.UserRepository;
import com.github.mcortegana.usecases.validator.UserValidator;

public class CreateUser {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final IdGenerator idGenerator;

    public CreateUser(UserRepository repository,
                      PasswordEncoder passwordEncoder,
                      IdGenerator idGenerator) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.idGenerator = idGenerator;
    }

    public User create(final User user) {
        UserValidator.validateCreateUser(user);
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistException("Alreade exist user register with "+user.getFirstName());
        }
        User userToSave = new User();
        userToSave.setId(idGenerator.generate());
        userToSave.setEmail(user.getEmail());
        userToSave.setLastName(user.getLastName());
        userToSave.setFirstName(user.getFirstName());
        userToSave.setPassword(passwordEncoder.encode(user.getEmail()+user.getPassword()));
        return repository.create(user);
    }

}
