package com.naukriforsagar.NaukriForSagar.SecurityPackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails admin= User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        UserDetails user=User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        UserDetails worker=User.withDefaultPasswordEncoder()
                .username("worker")
                .password("worker")
                .roles("WORKER")
                .build();

        return new InMemoryUserDetailsManager(admin,user,worker);
    }
}

