package io.pipecrafts.bushub.management.common.security;

import io.pipecrafts.bushub.management.common.user.UserRole;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;

public class UserJwtAuthentication extends JwtAuthenticationToken {

  @Getter
  private final String authId;

  @Getter
  private final UserRole role;
  public UserJwtAuthentication(
    Jwt jwt,
    Collection<? extends GrantedAuthority> authorities,
    String name,
    String authId,
    UserRole role
  ) {
    super(jwt, authorities, name);
    this.authId = authId;
    this.role = role;
  }
}
