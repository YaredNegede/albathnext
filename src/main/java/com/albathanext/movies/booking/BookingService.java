package com.albathanext.movies.booking;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingService {
    ResponseEntity<Optional<List<BookingResult>>> getByRange(LocalDateTime start, LocalDateTime end);

    ResponseEntity<Optional<BookingResult>> update(BookingResult result);

    ResponseEntity<Void> save(BookingResult result);

    ResponseEntity<Optional<BookingResult>> search(long id);

    ResponseEntity<Void> cancel(long id);

    ResponseEntity<Optional<Page<BookingResult>>> getAll(Pageable page);
}
