package com.tpe.microservicio_stops.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="microservicio-users",  url = "http://localhost:8083")
public interface UserFeignClient {
    @GetMapping("/api/users/{userId}/rol")
    boolean getUserRol(@PathVariable Long userId);
}
