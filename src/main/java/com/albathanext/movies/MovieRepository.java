package com.albathanext.movies;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie,Long> {
}
