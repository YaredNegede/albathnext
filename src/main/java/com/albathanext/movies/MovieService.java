package com.albathanext.movies;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MovieService {

    ResponseEntity<List<MovieResult>> search(Map<String,String>  keywords);

    ResponseEntity<List<MovieResult>> discover();
    ResponseEntity<List<MovieResult>> discover(String query);

    ResponseEntity<Optional<MovieResult>> getDetail(long id);

}
