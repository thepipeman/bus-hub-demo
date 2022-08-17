package io.pipecrafts.bushub.management.common.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
interface UserMapper {

  long insert(@Param("entity") User user);

  User selectByUsernameAndRole(@Param("username") String username, @Param("role") UserRole role);

  List<User> selectAll();

  boolean existsByUsernameAndRole(@Param("username") String username, @Param("role") UserRole role);
}
