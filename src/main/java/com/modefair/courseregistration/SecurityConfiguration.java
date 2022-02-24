package com.modefair.courseregistration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);

        //http.httpBasic().disable();

        http.
                httpBasic()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
        .and().logout().logoutUrl("/logout");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin123")
                .password("admin123")
                .roles("admin")
                .and()
                .withUser("user123")
                .password("user123")
                .roles("student");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        //return new BCryptPasswordEncoder(); //got bug - Encoded password does not look like BCrypt
        return NoOpPasswordEncoder.getInstance(); //insecure testing
    }

}
