package com.mirran.growappbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

//Ev @Configuration här
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                    .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                    .and()
                .formLogin().permitAll();

        //Vilken trafik får de komma in.
        //Annan konfigurering här

        //1. Konfiguerar - vilka endpoints ska vi kunna nå.
        //2. Vilken källa ska det komma ifrån (3000-porten)
        //CORS-problemet ligger inte på 3000-porten, det är på 8080 vi ska konfigurera CORS.
    }

    //Det är här vi behöver konfigurera trafiken in. Att 8080 tillåter CORS.
    //Var vi vill ta emot från (vilken källa).

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
