package com.albathanext.movies.booking;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * View all bookings
 * Cancel a Booking
 * Search booking (keyword search that will look into email, first and last name)
 * Nice to have: Filter bookings by date range.
 * Nice to have: Update existing booking
 */
@RestController
@RequestMapping("api/v1/booking")
public class BookingController {

    BookingService bookingService;

    @GetMapping("/")
    public ResponseEntity<Optional<Page<BookingResult>>>  getAll(@PathVariable("id") Pageable page){

        return bookingService.getAll(page);

    }

    @GetMapping("/cancel/{id}")
    public ResponseEntity<Optional<BookingResult>> cancel(@PathVariable("id") long id){

        bookingService.cancel(id);

        return ResponseEntity.ok().build();

    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Optional<BookingResult>> search(@PathVariable("id") long id){

        return bookingService.search(id);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<BookingResult>> update(BookingResult result){

        return this.bookingService.update(result);

    }

    @GetMapping("/between")
    public ResponseEntity<Optional<List<BookingResult>>> getByRange(@RequestParam("start") LocalDateTime start,@RequestParam("end") LocalDateTime end){

        return bookingService.getByRange(start,end);

    }

}
