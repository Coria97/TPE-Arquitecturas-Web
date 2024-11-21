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
                        .requestMatchers("/swagger-ui.html", "/v3/api-docs", "/swagger-resources/**", "/webjars/**").permitAll()
                        // No pudimos hacer que funcionen las auth para los servicios que no pertencen al microservicio-users,
                        // Seguro falta alguna configuracion pero no nos estamos dando cuenta, lo pusheamos porque creemos que suma.
                        // Si volves al commit anterior funcioan todos los eps pero sin auth salvo los de users.
                        //Microservicio stops
                        .requestMatchers(HttpMethod.GET, "/api/stops/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/stops").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/stops/close").hasAuthority(Rol.CLIENT.getAuthority())
                        .requestMatchers(HttpMethod.POST, "/api/stops").hasAuthority(Rol.ADMIN.getAuthority())
                        .requestMatchers(HttpMethod.DELETE, "/api/stops/{id}").hasAuthority(Rol.ADMIN.getAuthority())
                        .requestMatchers(HttpMethod.PUT, "/api/stops/{id}").hasAuthority(Rol.ADMIN.getAuthority())

                        .requestMatchers(HttpMethod.GET, "/api/scooters/usage").hasAuthority(Rol.ADMIN.getAuthority())
                        .requestMatchers(HttpMethod.POST, "/api/scooters").hasAuthority(Rol.ADMIN.getAuthority())
                        .requestMatchers(HttpMethod.DELETE, "/api/scooters/{id}").hasAuthority(Rol.ADMIN.getAuthority())
                        .requestMatchers(HttpMethod.PUT, "/api/scooters/{id}").hasAuthority(Rol.ADMIN.getAuthority())
                        .requestMatchers(HttpMethod.GET, "/api/scooters/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/scooters").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/scooters/{id}/stats").denyAll()

                        .requestMatchers(HttpMethod.DELETE, "/api/admin/scooters/state").hasAuthority(Rol.ADMIN.getAuthority())

                        // Microservicio travels
                        .requestMatchers(HttpMethod.GET, "/api/travels/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/travels").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/travels/{travelId}/finish").hasAuthority(Rol.CLIENT.getAuthority())
                        .requestMatchers(HttpMethod.POST, "/api/travels/{travelId}/stops/start").hasAuthority(Rol.CLIENT.getAuthority())
                        .requestMatchers(HttpMethod.POST, "/api/travels/{travelId}/stops/{stopsId}/end").hasAuthority(Rol.CLIENT.getAuthority())
                        .requestMatchers(HttpMethod.GET, "/api/travels/admin/scooters").hasAuthority(Rol.ADMIN.getAuthority())
                        .requestMatchers(HttpMethod.POST, "/api/travels").hasAuthority(Rol.CLIENT.getAuthority())
                        .requestMatchers(HttpMethod.PUT, "/api/travels/{id}").hasAuthority(Rol.ADMIN.getAuthority())
                        .requestMatchers(HttpMethod.DELETE, "/api/travels/{id}").hasAuthority(Rol.ADMIN.getAuthority())

                        .requestMatchers(HttpMethod.GET, "/api/travel-stops").permitAll()
                        .requestMatchers(HttpMethod.GET, "api/travel-stops/{id}").permitAll()

                        .requestMatchers(HttpMethod.GET, "/api/billings").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/billings/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/billings/admin/bills").hasAuthority(Rol.ADMIN.getAuthority())

                        .requestMatchers(HttpMethod.GET, "/api/billing-methods").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/billing-methods/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/billing-methods").hasAuthority(Rol.ADMIN.getAuthority())
                        .requestMatchers(HttpMethod.PUT, "/api/billing-methods/{id}").hasAuthority(Rol.ADMIN.getAuthority())
                        .requestMatchers(HttpMethod.DELETE, "/api/billing-methods/{id}").hasAuthority(Rol.ADMIN.getAuthority())

                        // Microservicio reports
                        .requestMatchers(HttpMethod.POST, "/api/maintenances").hasAuthority(Rol.REPAIR_MAN.getAuthority())
                        .requestMatchers(HttpMethod.DELETE, "/api/maintenances").hasAuthority(Rol.REPAIR_MAN.getAuthority())
                        .requestMatchers(HttpMethod.PUT, "/api/maintenances/{id}").hasAuthority(Rol.REPAIR_MAN.getAuthority())
                        .requestMatchers(HttpMethod.GET, "/api/maintenances").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/maintenances/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/reports/scooter/usage").permitAll()

                        // Microservicio users
                        .requestMatchers(HttpMethod.POST, "/api/auth").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/users/{id}/account/{accountId}").hasAuthority(Rol.CLIENT.getAuthority())
                        .requestMatchers(HttpMethod.DELETE,"/api/users/{id}/account/{accountId}").hasAuthority(Rol.ADMIN.getAuthority())
                        .requestMatchers(HttpMethod.GET, "/api/accounts/{id}").hasAuthority(Rol.CLIENT.getAuthority())
                        .requestMatchers(HttpMethod.GET, "/api/users/{id}").permitAll()
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
