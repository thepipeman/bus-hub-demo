package io.pipecrafts.bushub.management.common.security.tool;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.*;

@PreAuthorize("hasAuthority('SCOPE_mgmt')")
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface AdminEndpoint {
}
