package com.albathanext.movies;

import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface MovieClient {

    @GetMapping("/discover/movie")
    FeignMessage search(@SpringQueryMap Map<String,String>  keywords);

    @GetMapping("/movie/upcoming")
    FeignMessage discover();

    @GetMapping("/movie/{id}")
    Movie getDetail(@PathVariable("id") Long id);
}