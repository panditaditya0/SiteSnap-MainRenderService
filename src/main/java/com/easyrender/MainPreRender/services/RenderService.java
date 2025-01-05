package com.easyrender.MainPreRender.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "feignClient", url = "http://localhost:8080/api/render")
public interface RenderService {

    @PostMapping
    String getPageSource(@RequestParam("websiteUrl")  String websiteUrl,
                         @RequestParam("websiteDomain")  String websiteDomain);
}
