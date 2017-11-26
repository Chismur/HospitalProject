package com.hospitalproject.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by kingm on 14.11.2017.
 */
@Configuration
@ComponentScan("com.hospitalproject")
@ImportResource("classpath:spring.xml")
public class SpringConfig {

}
