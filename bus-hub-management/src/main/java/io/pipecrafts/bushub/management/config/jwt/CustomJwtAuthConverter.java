package io.pipecrafts.bushub.management.config.jwt;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import io.pipecrafts.bushub.management.common.security.AuthHandler;
import io.pipecrafts.bushub.management.common.security.UserJwtAuthentication;
import io.pipecrafts.bushub.management.common.user.UserRole;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomJwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {

  private final Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
  private final AuthHandler authHandler;

  private static final String principalClaimName = "username";
  private static final String subjectClaim = "sub";
  private static final String rolesClaim = "roles";

  @Override
  public final AbstractAuthenticationToken convert(Jwt jwt) {
    Collection<GrantedAuthority> authorities = jwtGrantedAuthoritiesConverter.convert(jwt);
    final String principalClaimValue = jwt.getClaimAsString(principalClaimName);
    final String subClaimValue = jwt.getClaimAsString(subjectClaim);
    final UserRole role = getRole(jwt);

    // Authentication object can be customized through this.
    final UserJwtAuthentication authentication = new UserJwtAuthentication(
      jwt,
      authorities,
      principalClaimValue,
      subClaimValue,
      role
    );

    // hack this should be handled with user registration
    authHandler.createUserOrSkip(authentication);
    return authentication;
  }

  private UserRole getRole(Jwt jwt) {
    final Set<String> roles = Sets.newHashSet(jwt.getClaimAsStringList(rolesClaim));

    // todo optimize with static initialization
    final Set<String> userRoles = Arrays.stream(UserRole.values())
      .map(UserRole::name)
      .collect(Collectors.toSet());

    final List<String> commonRoles = Lists.newArrayList(CollectionUtils.intersection(roles, userRoles));
    if (commonRoles.size() > 1) {
      throw new RuntimeException("Invalid roles setup, only one user role definition is required per user.");
    }

    return UserRole.valueOf(commonRoles.get(0));
  }
}
