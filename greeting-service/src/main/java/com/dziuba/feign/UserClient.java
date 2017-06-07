package com.dziuba.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient("user-service")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/find/{id}")
    Map<String, String> find(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/findByUser/{username}")
    public Map<String, String> findByUser(@PathVariable("username") String username);
}
