package io.pipecrafts.bushub.management.common.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

  private final UserMapper userMapper;

  public void create(User user) {
    userMapper.insert(user);
  }

  public Optional<User> readOptionalByUsernameAndRole(String username, UserRole role) {
    return Optional.ofNullable(userMapper.selectByUsernameAndRole(username, role));
  }

  public boolean existsByUsernameAndRole(String username, UserRole userRole) {
    return userMapper.existsByUsernameAndRole(username, userRole);
  }
}
