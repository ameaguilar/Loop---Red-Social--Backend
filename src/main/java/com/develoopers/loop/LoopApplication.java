package com.develoopers.loop;

import com.develoopers.loop.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoopApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoopApplication.class, args);
	} // main

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter(){

        // Creamos la instancia del registro de nuestro filtro JwtFilter
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();

        // Registramos el filtro
        registrationBean.setFilter(new JwtFilter());

        // Agregamos las rutas que queremos proteger gracias a este filtro
        registrationBean.addUrlPatterns("/loop/post/*");
        registrationBean.addUrlPatterns("/loop/users/*");

        return registrationBean;
    }// jwtFilter

} // develoopers.loop
