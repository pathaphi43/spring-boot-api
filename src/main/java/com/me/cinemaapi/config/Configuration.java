package com.me.cinemaapi.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@org.springframework.context.annotation.Configuration
@Data
public class Configuration {

    @Value(value = "${spring.application.name}")
    private String applicationName;

    @Value(value = "${spring.application.version}")
    private String applicationVersion;
}
