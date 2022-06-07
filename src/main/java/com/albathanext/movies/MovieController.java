package com.albathanext.movies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/movie")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/getDetail/{id}")
    public ResponseEntity<Optional<MovieResult>> getDetail(@PathVariable("id") long id){
        return movieService.getDetail(id);

    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieResult>> search(@RequestParam("key") String name,@RequestParam("value") String description){

        Map<String, String> key = new HashMap<>();

        key.put(name,description);

        return movieService.search(key);

    }

    @GetMapping("/query")
    public ResponseEntity<List<MovieResult>> discover(@RequestParam("query") String query){

        return movieService.discover(query);

    }

    @GetMapping("/discover")
    public ResponseEntity<List<MovieResult>> discover(){

        return movieService.discover();

    }

}
