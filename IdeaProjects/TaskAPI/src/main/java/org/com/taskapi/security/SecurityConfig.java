package org.com.taskapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity
@Configuration
public class SecurityConfig {
   @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
http
        .csrf(csrf -> csrf.disable())
       .authorizeHttpRequests(auth -> auth .requestMatchers(HttpMethod.GET, "/tasks/**")
               .permitAll().anyRequest()
               .authenticated())
        .httpBasic(Customizer.withDefaults());
       return http.build();
   }

   @Bean
   public PasswordEncoder psw(){
       return new BCryptPasswordEncoder();

   }
@Bean
   public <psw> UserDetailsService userDetailsService(PasswordEncoder encoder){
       UserDetails user1= User.builder()
               .username("Dawan")
               .password(encoder.encode ("123456"))
               .roles("USER")
               .build();


       UserDetails user2= User.builder()
               .username("Rania")
               .password(encoder.encode ("123456"))
               .roles("ADMIN")
               .build();

       return  new InMemoryUserDetailsManager(user1,user2);
   }
}
