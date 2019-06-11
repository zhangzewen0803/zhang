package com.bawei.user.controller;

import com.bawei.user.pojo.User;
import com.bawei.user.service.UserFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("feign")
public class FeignController {
    @Autowired
    UserFeignClient userFeignClient;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userFeignClient.queryUserById(id);
    }
}