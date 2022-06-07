package com.albathanext.movies;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService{

    ModelMapper modelMapper = new ModelMapper();

    MovieClient movieClient;

    MovieRepository movieRepository;

    public MovieServiceImpl(MovieClient movieClient, MovieRepository movieRepository) {
        this.movieClient = movieClient;
        this.movieRepository = movieRepository;
    }

    @Override
    public ResponseEntity<List<MovieResult>> search(Map<String,String>  keywords) {

        FeignMessage movies = movieClient.search(keywords);

        List<MovieResult> res = movies.getResults().stream().map(movie -> this.modelMapper.map(movie,MovieResult.class)).collect(Collectors.toList());

        return ResponseEntity.of(Optional.of((res)));

    }

    @Override
    public ResponseEntity<List<MovieResult>> discover() {

        FeignMessage movies = movieClient.discover();

        List<MovieResult> res = movies.getResults().stream().map(movie -> this.modelMapper.map(movie,MovieResult.class)).collect(Collectors.toList());

        return ResponseEntity.of(Optional.of((res)));

    }

    @Override
    public ResponseEntity<List<MovieResult>> discover(String query) {

        FeignMessage movies = movieClient.discover(query);

        List<MovieResult> res = movies.getResults().stream().map(movie -> this.modelMapper.map(movie,MovieResult.class)).collect(Collectors.toList());

        return  ResponseEntity.ok(res);

    }

    @Override
    public ResponseEntity<Optional<MovieResult>> getDetail(long id) {

        Movie result = movieClient.getDetail(id);

        MovieResult returnValue = this.modelMapper.map(result, MovieResult.class);

        return  ResponseEntity.ok(Optional.of(returnValue));

    }

}
