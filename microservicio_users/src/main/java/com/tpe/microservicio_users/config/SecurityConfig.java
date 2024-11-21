package com.tpe.microservicio_users.config;


import com.tpe.microservicio_users.enums.Rol;
import com.tpe.microservicio_users.security.JwtFilter;
import com.tpe.microservicio_users.security.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final TokenProvider tokenProvider;

    public SecurityConfig( TokenProvider tokenProvider ) {
        this.tokenProvider = tokenProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain( final HttpSecurity http ) throws Exception {
        http
                .csrf( AbstractHttpConfigurer::disable );
        http
                .sessionManagement( s -> s.sessionCreationPolicy( SessionCreationPolicy.STATELESS ) );
        http
                .securityMatcher("/api/**" )
                .authorizeHttpRequests( authz -> authz
                        .requestMatchers("/swagger-ui.html", "/v2/api-docs", "/swagger-resources/**", "/webjars/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/users/{id}/account/{accountId}").hasAuthority(Rol.CLIENT.getAuthority())
                        .requestMatchers(HttpMethod.DELETE,"/api/users/{id}/account/{accountId}").hasAuthority(Rol.ADMIN.getAuthority())
                        .requestMatchers(HttpMethod.GET, "/api/accounts/{id}").hasAuthority(Rol.CLIENT.getAuthority())
                        .requestMatchers(HttpMethod.GET, "/api/users/{id}").hasAuthority(Rol.CLIENT.getAuthority())
                        .requestMatchers(HttpMethod.PUT, "/api/users/{id}").hasAuthority(Rol.CLIENT.getAuthority())
                        .requestMatchers(HttpMethod.DELETE, "/api/users/{id}").hasAuthority(Rol.CLIENT.getAuthority())
                        .requestMatchers(HttpMethod.POST, "/api/accounts").hasAuthority(Rol.CLIENT.getAuthority())
                        .requestMatchers(HttpMethod.GET, "/api/accounts").hasAuthority(Rol.CLIENT.getAuthority())
                        .requestMatchers(HttpMethod.GET, "/api/users").hasAuthority(Rol.ADMIN.getAuthority())
                        .anyRequest().authenticated()


                )
                .httpBasic( Customizer.withDefaults())
                .addFilterBefore( new JwtFilter( this.tokenProvider ), UsernamePasswordAuthenticationFilter.class );
        return http.build();
    }


}
