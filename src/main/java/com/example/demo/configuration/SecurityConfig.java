package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests().antMatchers("*").permitAll();
//                .antMatchers("/pingnot").anonymous()
//                .antMatchers("/**").authenticated().and().exceptionHandling().and().httpBasic()
//                .authenticationEntryPoint(authenticationEntryPoint).and().sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authorizeRequests().antMatchers("/swagger-ui.html").authenticated().and()
//                .formLogin().permitAll().and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
//        http.addFilterBefore(new BasicAuthenticationFilter(authenticationManager()), BasicAuthenticationFilter.class);
    }
}