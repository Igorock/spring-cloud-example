package com.dziuba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dziuba.feign.UserClient;

import java.util.Map;

@RestController
public class GreetingController {

    @Autowired
    private UserClient userClient;

    @RequestMapping(method = RequestMethod.GET, value = "/byId/{userId}")
    public String greeting(@PathVariable Long userId) {
        Map<String, String> response = userClient.find(userId);
        return "Hello, " + response.get("name") + "! Instance ID: " + response.get("instanceId");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/byUser/{user}")
    public String greetingByUser(@PathVariable String user) {
        Map<String, String> response = userClient.findByUser(user);
        return "Hello, " + response.get("name") + "! Instance ID: " + response.get("instanceId");
    }
}
