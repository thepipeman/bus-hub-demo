package io.pipecrafts.bushub.management.common.security;

import io.pipecrafts.bushub.management.common.user.User;
import io.pipecrafts.bushub.management.common.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthEventHandlers {

  private final UserService userService;

  @EventListener
  public void onSuccessfulAuth(AuthenticationSuccessEvent successEvent) {
    final UserJwtAuthentication authentication = (UserJwtAuthentication) successEvent.getAuthentication();

    if (userService.existsByUsernameAndRole(authentication.getName(), authentication.getRole())) {
      // leave -> existing customer
      return;
    }

    final User user = createUser(authentication);
    userService.create(user);
  }

  private User createUser(UserJwtAuthentication authentication) {
    return User.builder()
      .username(authentication.getName())
      .authId(authentication.getAuthId())
      .role(authentication.getRole())
      .firstName("First Test")
      .lastName("Last Test")
      .build();
  }
}
