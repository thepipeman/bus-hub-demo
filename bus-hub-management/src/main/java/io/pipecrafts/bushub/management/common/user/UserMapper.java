package io.pipecrafts.bushub.management.common.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
interface UserMapper {

  long insert(@Param("entity") User user);

  User selectByUsernameAndRole(@Param("username") String username, @Param("role") UserRole role);

  boolean existsByUsernameAndRole(@Param("username") String username, @Param("role") UserRole role);
}
