package com.dziuba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dziuba.model.UserEntity;
import com.dziuba.repository.UserRepository;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class UserController {

    @Value("${eureka.instance.instanceId}")
    private String instanceId;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/find/{id}")
    public Map<String, String> find(@PathVariable Long id) {
        UserEntity userEntity = userRepository.findOne(id);
        Map<String, String> result = new LinkedHashMap<>();
        result.put("instanceId", instanceId);
        result.put("name", userEntity.getUsername());

        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findByUser/{username}")
    public Map<String, String> findByUser(@PathVariable String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        Map<String, String> result = new LinkedHashMap<>();
        result.put("instanceId", instanceId);
        result.put("name", userEntity.getFirstName() + " " + userEntity.getLastName());

        return result;
    }
}
