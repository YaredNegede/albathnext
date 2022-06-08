package com.albathanext.movies.booking;

import com.albathanext.movies.MovieResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingResult {

    private Long id;

    @NotNull
    private MovieResult movie;

    @NotNull
    private LocalDate dateTime;

    @NotNull
    private String venu;

    @NotNull
    private String status="new";

    private Integer numberofPerson;

}
