package com.github.mcortegana.usecases;

import com.github.mcortegana.core.entity.User;
import com.github.mcortegana.core.exception.NotAllowedException;
import com.github.mcortegana.core.port.PasswordEncoder;
import com.github.mcortegana.core.port.UserRepository;

public final class LoginUser {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginUser(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(final String email, final String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotAllowedException("No User Found"));
        String hashedPassword = passwordEncoder.encode(email + password);
        if (!user.getPassword().equals(hashedPassword))
            throw new NotAllowedException("Not Allowed");
        return user;
    }

}
