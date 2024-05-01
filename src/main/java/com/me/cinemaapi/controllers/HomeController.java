package com.me.cinemaapi.controllers;

import com.me.cinemaapi.config.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class HomeController {
    private final Configuration configuration;

    @GetMapping
    public String hello() {
        return String.format("%s version:%s",configuration.getApplicationName(),configuration.getApplicationVersion()) ;
    }
}
