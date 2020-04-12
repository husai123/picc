package org.java.order.feign;

import org.java.customer.api.CustomerApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("customer-service")
public interface CustomerClient extends CustomerApi {
}
