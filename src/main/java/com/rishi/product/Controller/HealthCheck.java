package com.rishi.product.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    /**
     * @return ok status for api
     */
    @GetMapping("/healthCheck")
    public String HealthCheck()
    {
        return "Ok";
    }
}
