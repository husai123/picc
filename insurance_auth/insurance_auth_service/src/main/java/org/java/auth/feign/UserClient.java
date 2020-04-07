package org.java.auth.feign;

import org.java.customer.api.CustomerApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("user-service")
public interface UserClient extends CustomerApi {
}
