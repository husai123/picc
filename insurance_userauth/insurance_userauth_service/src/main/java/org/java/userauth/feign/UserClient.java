package org.java.userauth.feign;

import org.java.user.api.EmployeeApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("user-service")
public interface UserClient extends EmployeeApi {
}
