package io.pipecrafts.bushub.management.common.user;

import io.pipecrafts.bushub.management.common.security.UserJwtAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  // should be admin endpoint but for testing purposes, KISS
  @PreAuthorize("hasAuthority('SCOPE_mgmt')")
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<User> readUsers() {
    return userService.readAll();
  }

  @GetMapping(value = "/mydetails", produces = MediaType.APPLICATION_JSON_VALUE)
  @PreAuthorize("hasAuthority('SCOPE_profile')")
  public User readMyDetails(UserJwtAuthentication authentication) {
    final var optionalUserDetails = userService.readOptionalByUsernameAndRole(
      authentication.getName(),
      authentication.getRole()
    );

    return optionalUserDetails.orElseThrow(() -> new RuntimeException("Missing user details"));
  }

}
