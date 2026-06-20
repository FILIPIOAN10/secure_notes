package secure_notes.secure_notes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests( (requests)->
                requests
                .requestMatchers("/contact").permitAll()
                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/admin").denyAll()
                .requestMatchers("/admin/**").denyAll()
                .anyRequest().authenticated());

        httpSecurity.csrf(csrf->csrf.disable());
        httpSecurity.sessionManagement( session->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
