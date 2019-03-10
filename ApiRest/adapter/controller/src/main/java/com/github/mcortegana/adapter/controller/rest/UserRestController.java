package com.github.mcortegana.adapter.controller.rest;

import com.github.mcortegana.adapter.controller.model.UserWeb;
import com.github.mcortegana.adapter.controller.model.mapper.UserWebMapper;
import com.github.mcortegana.core.entity.User;
import com.github.mcortegana.usecases.CreateUser;
import com.github.mcortegana.usecases.FindUser;
import com.github.mcortegana.usecases.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/users")
public class UserRestController {

    private final CreateUser createUser;
    private final LoginUser loginUser;
    private final FindUser findUser;
    private final UserWebMapper userWebMapper;

    @Autowired
    public UserRestController(final CreateUser createUser, final LoginUser loginUser,
                              final FindUser findUser, final UserWebMapper userWebMapper) {
        this.createUser = createUser;
        this.loginUser = loginUser;
        this.findUser = findUser;
        this.userWebMapper = userWebMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody final UserWeb userWeb) {
        User userDomain = userWebMapper.toDomain(userWeb);
        return new ResponseEntity<>(createUser.create(userDomain), HttpStatus.CREATED);
    }

    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestParam("email") final String email,
                                   @RequestParam("password") final String password) {
        UserWeb userWeb = userWebMapper.toWeb(loginUser.login(email, password));
        return new ResponseEntity<>(userWeb, HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUser(@PathVariable("userId") String userId) {
        UserWeb userWeb = userWebMapper.toWeb(findUser.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found")));
        return new ResponseEntity<>(userWeb, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllUsers() {
        List<UserWeb> userWebList = findUser.listAllUsers().stream()
                .map(userWebMapper::toWeb)
                .collect(Collectors.toList());

        return new ResponseEntity<>(userWebList, HttpStatus.OK);
    }

}
