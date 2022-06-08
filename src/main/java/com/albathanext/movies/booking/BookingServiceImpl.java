package com.albathanext.movies.booking;

import com.albathanext.movies.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    ModelMapper modelMapper = new ModelMapper();

    BookingRepository bookingRepository;

    MovieRepository movieRepository;

    public BookingServiceImpl( BookingRepository bookingRepository, MovieRepository movieRepository) {
        this.bookingRepository = bookingRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public ResponseEntity<Optional<List<BookingResult>>>  getByRange(LocalDateTime start, LocalDateTime end) {

        List<Booking> bookings = this.bookingRepository.findByDateTimeBetween(start,end);

        List<BookingResult> ret = bookings.stream().map(booking -> this.modelMapper.map(bookings, BookingResult.class)).collect(Collectors.toList());

        return ResponseEntity.ok(Optional.of(ret));

    }

    @Override
    public ResponseEntity<Optional<BookingResult>> update(BookingResult result) {

        Booking booking = this.modelMapper.map(result, Booking.class);

        this.bookingRepository.save(booking);

        return ResponseEntity.ok().build();

    }

    @Override
    public ResponseEntity<Void> save(BookingResult result) {

        Booking booking = this.modelMapper.map(result, Booking.class);

        booking.getMovie().setId(0); // this is just for cache and protect transient error

        movieRepository.save(booking.getMovie());

        this.bookingRepository.save(booking);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Optional<BookingResult>> search(long id) {

        Optional<BookingResult> res = this.bookingRepository.findById(id).map(booking -> this.modelMapper.map(booking, BookingResult.class));

        return ResponseEntity.ok(res);
    }

    @Override
    public ResponseEntity<Void> cancel(long id) {

        Booking result = this.bookingRepository.findById(id).get();

        result.setStatus(Status.cancel);

        this.bookingRepository.save(result);

        return ResponseEntity.ok().build();

    }

    @Override
    public ResponseEntity<Optional<Page<BookingResult> >> getAll(Pageable page) {

        Page<Booking> found = this.bookingRepository.findAll(page);

        Page<BookingResult> res = found.map(booking -> this.modelMapper.map(booking, BookingResult.class));

        return ResponseEntity.ok(Optional.of(res));

    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        this.bookingRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
