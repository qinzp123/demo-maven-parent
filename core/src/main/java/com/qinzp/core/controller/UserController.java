package com.qinzp.core.controller;

import com.qinzp.core.entity.User;
import com.qinzp.core.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qinzp
 * @time 2019-11-07 16:37:01
 */

@RestController
@Slf4j
@RequestMapping("/core")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @GetMapping("/users/{lastName}/{age}")
    public User getUser(@PathVariable(name="lastName",required = false) String lastName,@PathVariable Integer age) {
        User user = userRepository.findByLastNameAndAge(lastName, age);
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        User save = userRepository.save(user);
        return save;
    }


}
