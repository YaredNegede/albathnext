package com.albathanext.movies.booking;

import com.albathanext.movies.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private Status status;

    @NotNull
    private LocalDate dateTime;

    @NotNull
    @OneToMany
    private Set<Movie> movie;

    @NotNull
    private String venu;

    @NotNull
    private Integer numberofPerson;

    public void setStatus(Status cancel) {
        this.status = cancel;
    }
}
