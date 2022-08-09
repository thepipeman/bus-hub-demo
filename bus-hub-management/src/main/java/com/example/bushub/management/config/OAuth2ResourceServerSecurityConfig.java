package com.example.bushub.management.config;

import com.example.bushub.management.config.jwt.CustomJwtAuthConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
public class OAuth2ResourceServerSecurityConfig {

  private final CustomJwtAuthConverter customJwtAuthConverter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeRequests()
      .anyRequest()
      .hasAuthority("SCOPE_mgmt")
      .and()
      .oauth2ResourceServer(oauth2 -> oauth2
        .jwt(jwt -> jwt.jwtAuthenticationConverter(customJwtAuthConverter))
      );

    return httpSecurity.build();
  }

//  @Bean
//  public JwtAuthenticationConverter jwtAuthenticationConverter() {
//    JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
//        grantedAuthoritiesConverter.setAuthoritiesClaimName();
//  }

}
