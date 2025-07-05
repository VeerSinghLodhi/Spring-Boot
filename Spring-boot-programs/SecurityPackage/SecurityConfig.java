package com.naukriforsagar.NaukriForSagar.SecurityPackage;

import com.naukriforsagar.NaukriForSagar.SecurityPackage.EntitiesClassess.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasAnyRole("USER","ADMIN")
                        .requestMatchers("/worker/**").hasAnyRole("WORKER","USER","ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form->form
                        .loginPage("/login")
                        .permitAll())
                .logout(logout->logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll())
                .exceptionHandling(exception->exception
                        .accessDeniedPage("/access-denied"));

        return http.build();

    }
    @Autowired
    MyUserDetailsService myUserDetailsService;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain filterChain2(HttpSecurity http)throws Exception{
//        http
//                .authorizeHttpRequests(auth->auth
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/user/**").hasAnyRole("USER","ADMIN")
//                        .requestMatchers("/worker/**").hasAnyRole("WORKER","USER","ADMIN")
//                        .anyRequest().authenticated()
//                );
//        return http.build();
//    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http)throws  Exception{
        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder.userDetailsService(myUserDetailsService)
                .passwordEncoder(passwordEncoder());
        return authBuilder.build();
    }


//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//                http
//                .authorizeHttpRequests(auth ->auth.anyRequest().authenticated())
//                .formLogin(form->form.loginPage("/login").permitAll())
//                .logout(logout->logout.permitAll());
//        return http.build();
//    }
}
