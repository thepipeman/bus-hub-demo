package io.pipecrafts.bushub.management.common.user;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Value
@Builder
@Alias("User")
public class User {

  Long id;

  @NonNull
  String authId;

  @NonNull
  String username;

  @NonNull
  String firstName;

  String middleName;

  @NonNull
  String lastName;

  @NonNull
  UserRole role;
}
