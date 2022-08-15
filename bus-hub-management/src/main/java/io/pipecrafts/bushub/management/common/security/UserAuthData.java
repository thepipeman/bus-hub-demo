package io.pipecrafts.bushub.management.common.security;

import io.pipecrafts.bushub.management.common.user.UserRole;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserAuthData {
  String authId;
  UserRole role;
}
